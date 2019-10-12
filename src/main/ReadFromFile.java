package main;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ReadFromFile {

    private static final String srtUrlEn = "/Users/LALEH/Movies/friend/SUBDL.com__friends./Friends.S01E01.The.One.Where.Monica.Gets.A.Roommate.720p.BluRay-BS.srt";
    private static final String srtUrlFa = "/Users/LALEH/Downloads/shFixed/friends101HowItAllBegan.srt";

    private List getFile(String srtAddress) throws IOException {
        File file = new File(srtAddress);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List list = new ArrayList();
        while ((st = br.readLine()) != null){
            list.add(st);
        }
        return list;
    }

    private Set initilizeList (List srt) {
        Set set = new LinkedHashSet(srt);
        return set;
    }

    //# todo split all the subtitles
    //# todo find each sentence and compare with another one
    //# todo find every word and meanings
    //# todo ability to find similar word in each episode
    //# todo handle all exception (read from file and ...)
    //# todo read multi form by threads
    //# todo use java 8 new features

    private List<MySubtitleModel> makeSubtitleModel(List sub) {
        List<MySubtitleModel> list = new ArrayList();
        String subTime = "";
        Integer subEnInx = 1;
        String subEn = "";
        for (int i = 0 ; i < sub.size() ; i++){
            boolean isNumber = Pattern.matches("^[-+]?\\d+(\\.\\d+)?$" , sub.get(i) + "");
            if(isNumber) subEnInx = Integer.parseInt(sub.get(i) + "");
            if(sub.get(i).toString().length() > 2 && !sub.get(i).toString().contains("-->") && !isNumber ) subEn += sub.get(i);
            if(sub.get(i).toString().contains("-->") ) subTime = sub.get(i) + "";
            if(subEn.length() > 2 && sub.get(i).toString().length() < 2) {
                list.add(new MySubtitleModel(subTime, subEnInx, subEn, 1, ""));
                subEn = "";
            }
        }
        return list;
    }

    private List<MySubtitleModel> mix2list(List<MySubtitleModel> l1 , List<MySubtitleModel> l2) {
        for (MySubtitleModel o1 : l1){
            for(MySubtitleModel o2 : l2){
                if(o1.getSubEnInx() == o2.getSubEnInx()){
                    o1.setSubFaInx(o2.getSubEnInx());
                    o1.setSubFa(o2.getSubEn());
                }
            }
        }
        return l1;
    }

    private Set<String> newWords(List<MySubtitleModel> l){
        Set<String> set = new HashSet();
        for (MySubtitleModel o1 : l) {
            String[] sArray = o1.getSubEn().split(" ");
            for(String s : sArray){
                boolean b = Pattern.matches("[a-zA-Z]+\\.?" , s);
                if(b && s.length() > 2) set.add(s);
            }
        }
        return set;
    }

    public static void main(String[] args) throws IOException {
        ReadFromFile rff = new ReadFromFile();
        List srtListEn = rff.getFile(srtUrlEn);
        List srtListFa = rff.getFile(srtUrlFa);
        List listEn = rff.makeSubtitleModel(srtListEn);
        List listFa = rff.makeSubtitleModel(srtListFa);
        List finalList = rff.mix2list(listEn , listFa);
        Set<String> nw = rff.newWords(listEn);
        MakeCsvFile writer = new MakeCsvFile();
        writer.rightOnFile(nw);
        srtListEn.size();
    }
}
