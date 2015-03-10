package com.paths;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Paths{
    public static void main(String[] args) throws Exception {
        Map<String, List<String>> routes = new HashMap<String, List<String>>();
        Map<String, String> citiesAndCountry = new HashMap<String, String>();

        int optionIndex = Arrays.asList(args).indexOf("-f");
        int cityOptionIndex = Arrays.asList(args).indexOf("-c");
        File fileName = new File(args[optionIndex+1]);
        File citiesFile = new File(args[cityOptionIndex+1]);
        Path path = new Path();
        if (!fileName.exists()) {
            System.out.println("No database found");
            return;
        }
        PathReader pr = new PathReader();
        routes = pr.readPath(fileName);

        CitiesReader cr = new CitiesReader();
        citiesAndCountry = cr.readCity(citiesFile);

        String source = args[args.length-1];
        String destination = args[args.length-2];

        path.insertMap(citiesAndCountry);
        path.insertPath(routes);

        if(!path.isPresent(source)){
            System.out.println("No city named '"+source+"' in database");
            return;
        }
        if(!path.isPresent(destination)){
            System.out.println("No city named '"+destination+"' in database");
            return;
        }
        System.out.println(path.printPath(source,destination));
    }
}