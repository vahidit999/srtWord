package main;

import java.io.Externalizable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Test {
    private static final String srtUrlEn = "/Users/LALEH/Movies/friend/SUBDL.com__friends./Friends.S01E24.The.One.Where.Rachel.Finds.Out.720p.BluRay-BS.srt";
    private static final String srtUrlFa = "/Users/LALEH/Movies/friend/friends--first-season_farsi_persian-1456452/shFixed/FriendsS01E24.srt";

    static public void main(String[] args) throws IOException {
        ReadFromFile rff = new ReadFromFile();
        List srtListEn = ReadFile.getFile(srtUrlEn);
        List srtListFa = ReadFile.getFile(srtUrlFa);
        List listEn = rff.makeSubtitleModel(srtListEn);
        List listFa = rff.makeSubtitleModel(srtListFa);
        //List finalList = rff.mix2list(listEn, listFa);
        rff.mix2listCoresponding(listEn, listFa);
        Set<String> nw = rff.newWords(listEn);
        MakeCsvFile.writeOnFile(nw);
        srtListEn.size();
    }
}
