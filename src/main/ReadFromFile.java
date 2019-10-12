package main;

import java.io.*;
import java.util.*;

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

    //# todo split all the subtitles
    //# todo find each sentence and compare with another one
    //# todo find every word and meanings
    //# todo ability to find similar word in each episode
    //# todo handle all exception (read from file and ...)
    //# todo read multi form by threads
    //# todo use java 8 new features


    public static void main(String[] args) throws IOException {
        ReadFromFile rff = new ReadFromFile();
        List srtListEn = rff.getFile(srtUrlEn);
        List srtListFa = rff.getFile(srtUrlFa);
        srtListEn.size();
    }
}
