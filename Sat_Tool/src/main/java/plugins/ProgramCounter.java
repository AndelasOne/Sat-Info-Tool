/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package plugins;

import dhbw.swe.*;
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
        StructNode<String> root = new StructNode<>();
        ArrayNode<String> satelliteComposites = new ArrayNode<>();
        root.addPair("Results: Program Counter", satelliteComposites);

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

            StructNode<String> newSatComposite = new StructNode<>();
            ArrayNode<String> transponderComposites = new ArrayNode<>();
            newSatComposite.addPair(satName, transponderComposites);

            HashMap<String, Transponder>  transponderHashMap = satellites.get(satName);
            for (String freq: transponderHashMap.keySet()
                 ) {

                StructNode<String> newTransponderComposite = new StructNode<>();
                ArrayNode<String> programComposite = new ArrayNode<>();

                newTransponderComposite.addPair("freq" + freq, programComposite);
                Transponder  transponder = transponders.get(freq);

                // add leaves of transponder
                addTransponderLeaves(newTransponderComposite, transponder.getPrograms());

                // add transponder composite to sat composite
                transponderComposites.addElement(newTransponderComposite);
            }
            satelliteComposites.addElement(newSatComposite);
        }
        return root;
    }


    /**
     * Adds Field values of Object to a Struct Node
     * @param composite struct node to append leaves
     * @param programs of composite
     */
    private void addTransponderLeaves(StructNode<String> composite, HashMap<String, Integer> programs) {
        for (String type: programs.keySet()){
            int count = programs.get(type);

            Leaf<String> newLeaf = new Leaf<>(Integer.toString(count));
            composite.addPair(type, newLeaf);
        }
    }




}
