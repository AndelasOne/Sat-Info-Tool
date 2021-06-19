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

public class GermanChannels implements IPlugin {

    /**
     * Filter Method which only filters for german channels
     * @param input array list of satellites
     * @return Satellite Composite
     * @throws IllegalAccessException
     */
    @Override
    public AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException {

        // only satellites with german channels
        StructNode<String> root = new StructNode<>();
        ArrayNode<String> satellites = new ArrayNode<>();
        root.addPair("Satellites with german channels", satellites);
        String germanIdentifier = ".* ger";

        for (Satellite sat:input
             ) {
            StructNode<String> satellite = new StructNode<>();
            addObjectLeaves(satellite, sat);
            ArrayNode<String> channels = new ArrayNode<>();
            satellite.addPair("german channels", channels);
            // iterate over channels of satellite
            for (Channel currentChannel:sat.getChannels()
                 ) {
                // check for german channel
                if (currentChannel.a_pid.matches(germanIdentifier)){
                    // set channel name
                    StructNode<String> channel = new StructNode<>();

                    // create channel with all leaves and add channel to satellite composite
                    addObjectLeaves(channel, currentChannel);
                    channels.addElement(channel);
                }
            }
            if (channels.getSize() != 0){
                satellites.addElement(satellite);
            }
        }
        return root;
    }

    /**
     * Adds Field values of Object to a Composite
     * @param node that gets appended by leaves
     * @param obj that donates the values for the Composite
     * @throws IllegalAccessException
     */
    private void addObjectLeaves(StructNode<String> node, Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f: fields){
            int mod = f.getModifiers();
            if (Modifier.isPrivate(mod)) continue;

            String key = f.getName();
            String value = (String) f.get(obj);
            Leaf<String> newLeaf = new Leaf<>(value);
            node.addPair(key, newLeaf);
        }
    }

}
