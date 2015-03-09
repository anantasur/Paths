package com.paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.File;

class Paths{
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> routes = new HashMap<String, List<String>>();
        Map<String, String> citiesAndCountry = new HashMap<String, String>();

        String option = args[0];
        File fileName = new File(args[1]);
        Path path = new Path();
        if(!fileName.exists()){
            System.out.println("No database named "+fileName+" found");
            return;
        }
        PathReader pr = new PathReader();
        routes = pr.readPath(fileName);

        CitiesReader cr = new CitiesReader();
        citiesAndCountry = cr.readCity(fileName);
//        System.out.println("======"+citiesAndCountry);

        for (String entry : citiesAndCountry.keySet()){
            City e = new City(entry, citiesAndCountry.get(entry));
            entry.toString();
        }

        String source = args[2];
        String destination = args[3];

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