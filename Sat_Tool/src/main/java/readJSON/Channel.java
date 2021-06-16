package readJSON;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 16.06.2021, Mittwoch
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Channel {
    final String sid;
    final String type;
    final String name;
    final String v_pid;
    final String a_pid;
    final String compression;
    final String url;
    final String enc;
    final String pckg;
    final String res;

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
