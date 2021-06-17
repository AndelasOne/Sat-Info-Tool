/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 16.06.2021, Mittwoch
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package readJSON;


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

    public String getSid() {
        return sid;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getV_pid() {
        return v_pid;
    }

    public String getCompression() {
        return compression;
    }

    public String getUrl() {
        return url;
    }

    public String getEnc() {
        return enc;
    }

    public String getPckg() {
        return pckg;
    }

    public String getRes() {
        return res;
    }

    public String getA_pid() {
        return a_pid;
    }
}
