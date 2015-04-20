package com.example.s521942.androidproject.Events;

import java.util.Date;

/**
 * Created by S521942 on 4/19/2015.
 */
public class Event {
    String name;
    String Desc;
    String date;

    public Event(String name, String desc, String date) {
        this.name = name;
        Desc = desc;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
