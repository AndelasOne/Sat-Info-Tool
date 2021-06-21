package plugins;
import java.util.HashMap;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 17.06.2021, Donnerstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Transponder {


    private final String frequency;
    private final HashMap<String, Integer> programs;


    public String getFrequency() {
        return frequency;
    }

    /**
     *
     * @param frequency of transponder
     */
    public Transponder(String frequency) {
        this.frequency = frequency;
        this.programs = new HashMap<String, Integer>();
    }

    /**
     * Adds a new program or increases counter if not exist
     * @param type
     */
    public void addNextProgram(String type){
        // if not exist then add program counter with value one
        int count = 1;

        //check if available
        if (programs.containsKey(type)){
            count = programs.get(type) + 1;
        }

        programs.put(type, count);
    }

    /**
     * get Programs of Transponder
     * @return HashMap of programs
     */
    public HashMap<String, Integer> getPrograms() {
        return programs;
    }
}
