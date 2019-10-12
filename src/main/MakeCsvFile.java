package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

public class MakeCsvFile {
    public void rightOnFile (Set<String> set) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter p = new PrintWriter("newWords.txt"  , "UTF-8");
        for (String s : set)
            p.println(s);
        p.close();
    }
}
