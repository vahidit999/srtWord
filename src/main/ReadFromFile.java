package main;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class ReadFromFile {

    {
        System.out.println("this is initializer block");
    }

    public List<MySubtitleModel> makeSubtitleModel(List sub) {
        List<MySubtitleModel> list = new ArrayList();
        String subTime = "";
        Integer subEnInx = 1;
        String subtitle = "";
        Time startTime = null;
        Time endTime = null;

        for (int i = 0; i < sub.size(); i++) {
            boolean isNumber = Pattern.matches("^[-+]?\\d+(\\.\\d+)?$", sub.get(i) + "");
            if (isNumber) subEnInx = Integer.parseInt(sub.get(i) + "");
            if (sub.get(i).toString().length() > 2 && !sub.get(i).toString().contains("-->") && !isNumber)
                subtitle += sub.get(i);
            if (sub.get(i).toString().contains("-->")) {
                startTime = Time.valueOf(sub.get(i).toString().split("-->")[0].split(",")[0].trim());
                endTime = Time.valueOf(sub.get(i).toString().split("-->")[1].split(",")[0].trim());
                subTime = sub.get(i) + "";
            }
            if (subtitle.length() > 2 && sub.get(i).toString().length() < 2) {
                list.add(new MySubtitleModel(subTime, subEnInx, subtitle, startTime, endTime));
                subtitle = "";
            }
        }
        return list;
    }

    public void mix2listCoresponding (List<MySubtitleModel> l1, List<MySubtitleModel> l2){
        AtomicInteger i = new AtomicInteger(0);
        l1.stream().forEach(m1->{
            l2.stream().forEach(m2->{
                if (  m1.getStartTime().equals(m2.getStartTime())) {
                    System.out.println(m1.getSubtitle() + " ---- " + m2.getSubtitle());
                    i.getAndIncrement();
                }
            });

        });

        for (MySubtitleModel m1 : l1) {

        }
        System.out.println("total count : " + i);
    }
    public List<MySubtitleModel> mix2list(List<MySubtitleModel> l1, List<MySubtitleModel> l2) {
        for (MySubtitleModel o1 : l1) {
            for (MySubtitleModel o2 : l2) {
                if (o1.getSubEnInx() == o2.getSubEnInx()) {
                    o1.setSubEnInx(o2.getSubEnInx());
                    o1.setSubtitle(o2.getSubtitle());
                }
            }
        }
        return l1;
    }

    public Set<String> newWords(List<MySubtitleModel> l) {
        Set<String> set = new TreeSet();
        for (MySubtitleModel o1 : l) {
            String[] sArray = o1.getSubtitle().split(" ");
            for (String s : sArray) {
                boolean b = Pattern.matches("[a-zA-Z]+\\.?", s);
                if (b && s.length() > 2) set.add(s.split("\\.")[0].toLowerCase());
            }
        }
        return set;
    }

}
