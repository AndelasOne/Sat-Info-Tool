/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package readJSON;

import java.util.ArrayList;

public class Satellite {
    final String pol;

    public String getSat() {
        return sat;
    }

    final String sat;
    final String orbital;
    final String sym;
    final String freq;

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    final ArrayList<Channel> channels;

    public Satellite(String pol, String sat, String orbital, String sym, String freq, ArrayList<Channel> channels) {
        this.pol = pol;
        this.sat = sat;
        this.orbital = orbital;
        this.sym = sym;
        this.freq = freq;
        this.channels = channels;
    }


}
