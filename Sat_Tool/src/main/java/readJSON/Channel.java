/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 16.06.2021, Mittwoch
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package readJSON;


public class Channel {
    public final String sid;
    public final String type;
    public final String name;
    public final String v_pid;
    public final String a_pid;
    public final String compression;
    public final String url;
    public final String enc;
    public final String pckg;
    public final String res;

    /**
     *
     * @param sid id of the channel
     * @param type type of the channel. E.g Radion or TV
     * @param name name of the channel
     * @param v_pid Video-PID
     * @param a_pid Audio-PID
     * @param compression Compression method used
     * @param url url
     * @param enc Encoding technology used
     * @param pckg package
     * @param res resolution
     */
    public Channel(String sid, String type, String name, String v_pid, String a_pid, String compression, String url, String enc, String pckg, String res) {
        this.sid = sid;
        this.type = type;
        this.name = name;
        this.v_pid = v_pid;
        this.a_pid = a_pid;
        this.compression = compression;
        this.url = url;
        this.enc = enc;
        this.pckg = pckg;
        this.res = res;
    }
}
