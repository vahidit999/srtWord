package main;

import java.io.Serializable;
import java.sql.Time;

public class MySubtitleModel implements Serializable {

    private String subtitleTime;
    private Time startTime;
    private Time endTime;
    private Integer subEnInx;
    private String subtitle;
    MySubtitleModel(String subtitleTime, Integer subEnInx, String subtitle , Time startTime , Time endTime) {
        this.subtitleTime = subtitleTime;
        this.subEnInx = subEnInx;
        this.subtitle = subtitle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSubtitleTime() {
        return subtitleTime;
    }

    public void setSubtitleTime(String subtitleTime) {
        this.subtitleTime = subtitleTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getSubEnInx() {
        return subEnInx;
    }

    public void setSubEnInx(Integer subEnInx) {
        this.subEnInx = subEnInx;
    }
}
