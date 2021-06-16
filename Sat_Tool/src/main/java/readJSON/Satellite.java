package readJSON;

import java.util.ArrayList;

public class Satellite {
    final String pol;
    final String sat;
    final String orbital;
    final String sym;
    final String freq;
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
