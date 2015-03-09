package com.paths;

/**
 * Created by ananthur on 3/9/2015.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class CitiesReader{
    public Map<String,String> readCity(File fileName) throws IOException{
        Map<String,String> cityCountryMap = new HashMap<String,String>();
        BufferedReader br = new BufferedReader(new FileReader("data/cities.txt"));
        String line = ""+br.readLine();
        while(line != null){
            String places[] = line.split(",");
            cityCountryMap.put(places[0],places[1]);
            line = br.readLine();
        }
        return cityCountryMap;
    }
}
