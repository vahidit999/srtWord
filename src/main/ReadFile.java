package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List getFile(String srtAddress) throws IOException {
        File file = new File(srtAddress);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List list = new ArrayList();
        while ((st = br.readLine()) != null) {
            list.add(st);
        }
        return list;
    }
}
