package main;

import java.io.Serializable;

public class MySubtitleModel implements Serializable {

    MySubtitleModel (String subTime ,Integer subEnInx,String subEn ,Integer subFaInx,String subFa ){
        this.subTime = subTime;
        this.subEnInx = subEnInx;
        this.subEn = subEn;
        this.subFaInx = subFaInx;
        this.subFa = subFa;
    }

    private String subTime ;
    private Integer subEnInx;
    private String subEn ;
    private Integer subFaInx;
    private String subFa ;

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public String getSubEn() {
        return subEn;
    }

    public void setSubEn(String subEn) {
        this.subEn = subEn;
    }

    public String getSubFa() {
        return subFa;
    }

    public void setSubFa(String subFa) {
        this.subFa = subFa;
    }

    public Integer getSubEnInx() {
        return subEnInx;
    }

    public void setSubEnInx(Integer subEnInx) {
        this.subEnInx = subEnInx;
    }

    public Integer getSubFaInx() {
        return subFaInx;
    }

    public void setSubFaInx(Integer subFaInx) {
        this.subFaInx = subFaInx;
    }
}
