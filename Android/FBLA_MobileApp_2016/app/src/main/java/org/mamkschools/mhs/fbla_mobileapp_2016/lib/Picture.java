package org.mamkschools.mhs.fbla_mobileapp_2016.lib;

/**
 * Created by jackphillips on 5/5/16.
 */
public class Picture {
    public int entryid;
    public double geolat;
    public double geolong;
    public double dist;
    public String created;
    public String title;
    public String username;
    public double priority;
    public double hours;

    public Picture(int entryid, double geolat, double geolong, String created, String title, String username, double priority, double hours){
        this.entryid = entryid;
        this.geolat = geolat;
        this.geolong = geolong;
        this.dist = dist;
        this.created = created;
        this.title = title;
        this.username = username;
        this.priority = priority;
        this.hours = hours;
    }
}