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

public class CreateTree implements IPlugin {

    /**
     * Filter Method which only filters for german channels
     * @param input array list of satellites
     * @return Satellite Composite
     * @throws IllegalAccessException
     */
    @Override
    public AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException {

        // only satellites with german channels
        Composite<String> root = new Composite<>("Results: German Channels");

        for (Satellite sat:input
             ) {
            Composite<String> newSatComposite = new Composite<>(sat.sat);

            // iterate over channels of satellite
            for (Channel currentChannel:sat.getChannels()
                 ) {

                // set channel name
                Composite<String> newChannelComposite = new Composite<>(currentChannel.name);

                // create channel with all leaves and add channel to satellite composite
                addObjectLeaves(newChannelComposite, currentChannel);
                newSatComposite.addComposite(newChannelComposite);
            }
            addObjectLeaves(newSatComposite, sat);
            root.addComposite(newSatComposite);
        }
        return root;
    }

    /**
     * Adds Field values of Object to a Composite
     * @param composite that gets appended by leaves
     * @param obj that donates the values for the Composite
     * @throws IllegalAccessException
     */
    private void addObjectLeaves(Composite<String> composite, Object obj) throws IllegalAccessException {
        Field[] channelFields = obj.getClass().getDeclaredFields();
        for (Field f: channelFields){
            int mod = f.getModifiers();
            if (Modifier.isPrivate(mod)) continue;

            Leaf<String> newLeaf = new Leaf<>((String) f.get(obj));
            composite.addLeaf(newLeaf);
        }
    }

}