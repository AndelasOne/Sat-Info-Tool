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

public class ProgramCounter implements IPlugin {
    @Override
    public AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException {

        // count
        Composite<String> root = new Composite<>("Results: ");

        ArrayList<Transponder> transponders = new ArrayList<>();

        // first iteration to get transponders
        for (Satellite sat:input
        ) {
            int transponderIdx = containsTransponder(sat, transponders);
            Transponder transponder = new Transponder(sat.freq);
            if (transponderIdx == -1) {
                transponders.add(transponder);
            }
            // iterate over channels of satellite and create Program List
            for (Channel currentChannel:sat.getChannels()
            ) {
                int programIdx = containsProgramType(currentChannel, transponder.getPrograms());
                if( programIdx != -1){
                    transponder.getPrograms().get(programIdx).increaseAmount(); // increase Amount of Programs
                }
                else{
                    Program program = new Program(currentChannel.type, sat.freq, 1);
                    transponder.appendProgram(program);
                }
            }
        }

        // second iteration to build up the composite tree
        for (Satellite sat:input
        ) {
            Composite<String> newSatComposite = new Composite<>(sat.sat);
            addSatLeaves(newSatComposite, sat);
            for (Transponder t:transponders
                 ) {
                Composite<String> newTransponderComposite = new Composite<>(sat.freq);
                addTransponderLeaves(newTransponderComposite, t.getPrograms());

                // add transponder composite
                newSatComposite.addComposite(newTransponderComposite);
            }
            root.addComposite(newSatComposite);
        }
        return root;
    }

    private int containsTransponder(final Satellite satellite, final ArrayList<Transponder> transponder){
        int idx = 0;
        for (Transponder t:transponder
        ) {
            // check if type already exist in transponder arraylist
            if (satellite.freq.equals(t.getFrequency())){
                return idx;
            }
            idx++;
        }
        return -1;
    }

    private int containsProgramType(final Channel channel, final ArrayList<Program> programs){
        int idx = 0;
        for (Program p:programs
             ) {
            // check if type already exist in program arraylist
            if (channel.type.equals(p.getType())){
                return idx;
            }
            idx++;
        }
        return -1;
    }

    private void addTransponderLeaves(Composite<String> composite, ArrayList<Program> programs) {
        for (Program p: programs){
            Leaf<String> newLeaf = new Leaf<>(p.getType()+ ": " + p.getAmount());
            composite.addLeaf(newLeaf);
        }
    }

    private void addSatLeaves(Composite<String> composite, Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f: fields){
            int mod = f.getModifiers();
            if (Modifier.isPrivate(mod))  continue; //skips channels

            String fieldName = f.getName();
            Leaf<String> newLeaf = new Leaf<>(fieldName+ ": " + (String) f.get(obj));
            composite.addLeaf(newLeaf);
        }
    }

}

