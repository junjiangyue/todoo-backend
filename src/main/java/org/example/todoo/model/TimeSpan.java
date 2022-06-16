package org.example.todoo.model;

import com.alibaba.fastjson.JSONObject;

public class TimeSpan {
    public JSONObject time;
    public JSONObject Monday;
    public JSONObject Tuesday;
    public JSONObject Wednesday;
    public JSONObject Thursday;
    public JSONObject Friday;
    public JSONObject Saturday;
    public JSONObject Sunday;

    public TimeSpan(String section, String time){
        this.time.put("section",section);
        this.time.put("time",time);

    }

    public JSONObject getTime() {
        return time;
    }

    public void setTime(JSONObject time) {
        this.time = time;
    }

    public JSONObject getMonday() {
        return Monday;
    }

    public void setMonday(JSONObject monday) {
        Monday = monday;
    }

    public JSONObject getTuesday() {
        return Tuesday;
    }

    public void setTuesday(JSONObject tuesday) {
        Tuesday = tuesday;
    }

    public JSONObject getWednesday() {
        return Wednesday;
    }

    public void setWednesday(JSONObject wednesday) {
        Wednesday = wednesday;
    }

    public JSONObject getThursday() {
        return Thursday;
    }

    public void setThursday(JSONObject thursday) {
        Thursday = thursday;
    }

    public JSONObject getFriday() {
        return Friday;
    }

    public void setFriday(JSONObject friday) {
        Friday = friday;
    }

    public JSONObject getSaturday() {
        return Saturday;
    }

    public void setSaturday(JSONObject saturday) {
        Saturday = saturday;
    }

    public JSONObject getSunday() {
        return Sunday;
    }

    public void setSunday(JSONObject sunday) {
        Sunday = sunday;
    }
}
