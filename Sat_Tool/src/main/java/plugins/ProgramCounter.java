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
import dhbw.swe.Leaf;
import readJSON.Channel;
import readJSON.Satellite;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;


public class ProgramCounter implements IPlugin {
    @Override
    public AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException {

        // count
        Composite<String> root = new Composite<>("Results: Program Counter");


        HashMap<String, HashMap<String, Transponder>> satellites  = new HashMap<>(); // Map of sat-name and transponders
        HashMap<String, Transponder> transponders = new HashMap<>(); // Map of freq and transponder



        // first iteration to get transponders
        for (Satellite currentSat:input
        ) {
            if (!transponders.containsKey(currentSat.freq)){
                Transponder newTransponder = new Transponder(currentSat.freq);
                transponders.put(currentSat.freq, newTransponder);
            }

            Transponder currentTransponder = transponders.get(currentSat.freq);
            // iterate over channels of satellite and add programs
            for (Channel currentChannel:currentSat.getChannels()
            ) {
                currentTransponder.addNextProgram(currentChannel.type);
            }

            if (!satellites.containsKey(currentSat.sat)){
                satellites.put(currentSat.sat, transponders);
            }
        }

        // second iteration to build up the composite tree
        for (String satName:satellites.keySet()
        ) {
            Composite<String> newSatComposite = new Composite<>(satName);
            HashMap<String, Transponder>  transponderHashMap = satellites.get(satName);
            for (String freq: transponderHashMap.keySet()
                 ) {
                Composite<String> newTransponderComposite = new Composite<>("freq: " + freq);
                Transponder  transponder = transponders.get(freq);

                // add leaves of transponder
                addTransponderLeaves(newTransponderComposite, transponder.getPrograms());

                // add transponder composite to sat composite
                newSatComposite.addComposite(newTransponderComposite);
            }
            root.addComposite(newSatComposite);
        }
        return root;
    }

    private void addTransponderLeaves(Composite<String> composite, HashMap<String, Integer> programs) {
        for (String type: programs.keySet()){
            int count = programs.get(type);
            Leaf<String> newLeaf = new Leaf<>(type+ ": " + count);
            composite.addLeaf(newLeaf);
        }
    }
    

}

