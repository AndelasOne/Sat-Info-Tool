package readJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadJSON {
    /**
     * create array of all satellites
     * @param file satellite json file
     * @return array of satellites
     */
    public static ArrayList<Satellite> createSatelliteArray(String file) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            Object obj = parser.parse(reader);

            JSONArray jSatArray = (JSONArray) obj;

            ArrayList<Satellite> satArray = new ArrayList<>();
            for (Object jSat:jSatArray
            ) {
                satArray.add(parseSatellite((JSONObject) jSat));
            }
            return satArray;
        }

        //exception which occurs when an input/output operations fails / parse operations fails
        catch (IOException | ParseException message) {
            message.printStackTrace();
        }
        return null;
    }

    /**
     * create JSONArray of channels for all Satellites
     * @param satellite satellite json-object
     * @return satellite object
     */
    private static Satellite parseSatellite(JSONObject satellite) {

        String pol = (String) satellite.get("pol");
        String sat = (String) satellite.get("sat");
        String orbital = (String) satellite.get("orbital");
        String freq = (String) satellite.get("freq");
        String sym = (String) satellite.get("sym");

        System.out.printf("*--- Sat: %-14s Orbital: %-10s Pol: %-6s Freq: %-8s Sym: %-8s %n", sat, orbital, pol, freq, sym);

        JSONArray jChannels = (JSONArray) satellite.get("channels");
        ArrayList<Channel> channelArray = new ArrayList<>();
        for (Object jChannel:jChannels
             ) {
            channelArray.add(parseChannel((JSONObject) jChannel));
        }
        return new Satellite(pol, sat, orbital, freq, sym, channelArray);
    }

    /**
     * parse single channel of json-object
     * @param channel json-object
     * @return channel object
     */
    private static Channel parseChannel(JSONObject channel){
        String sid = (String) channel.get("sid");
        String type = (String) channel.get("type");
        String name = (String) channel.get("name");
        String v_pid = (String) channel.get("v_pid");
        String a_pid = (String) channel.get("a_pid");
        String compression = (String) channel.get("compression");
        String url = (String) channel.get("url");
        String enc = (String) channel.get("enc");
        String pckg = (String) channel.get("package");   //pakkage with kk
        String res = (String) channel.get("res");
        System.out.printf("---* Name: %-25s - Compression: %-10s Encryption: %-8s  Type %-8s %n", name, compression, enc, type);

        return new Channel(sid,type,name, v_pid, a_pid, compression, url, enc, pckg, res );
    }

}
