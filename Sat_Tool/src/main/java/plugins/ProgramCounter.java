/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package plugins;

import dhbw.swe.AbstractNode;
import dhbw.swe.Composite;
import dhbw.swe.IPlugin;
import readJSON.Channel;
import readJSON.Satellite;

import java.util.ArrayList;

public class ProgramCounter implements IPlugin {
    @Override
    public AbstractNode<String> filter(ArrayList<Satellite> input) {
        // count
        Composite<String> root = new Composite<>("Results: ");

        for (Satellite sat:input
        ) {
            Composite<String> groupedSatellitesByFrequency = new Composite<>(sat.sat);

            // iterate over channels of satellite
            for (Channel currentChannel:sat.getChannels()
            ) {

            }


        }
        return root;
    }
}
