/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package readJSON;

import java.util.Collections;
import java.util.List;

public class Satellite {
    public final String pol;
    public final String sat;
    public final String orbital;
    public final String sym;
    public final String freq;
    private final List<Channel> channels;

    public List<Channel> getChannels() {
        return Collections.unmodifiableList(channels);
    }

    public Satellite(String pol, String sat, String orbital, String sym, String freq, List<Channel> channels) {
        this.pol = pol;
        this.sat = sat;
        this.orbital = orbital;
        this.sym = sym;
        this.freq = freq;
        this.channels = channels;
    }

}
