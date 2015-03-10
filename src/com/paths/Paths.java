package com.paths;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Paths{
    public static void main(String[] args) throws Exception {
        Map<String, List<String>> routes = new HashMap<String, List<String>>();
        Map<String, String> citiesAndCountry = new HashMap<String, String>();

        String option = args[0];
        File fileName = new File(args[1]);
        File citiesFile = new File(args[3]);
        Path path = new Path();
        if(!fileName.exists()){
        System.out.println("No database named "+fileName+" found");
            return;
        }
        PathReader pr = new PathReader();
        routes = pr.readPath(fileName);

        CitiesReader cr = new CitiesReader();
        citiesAndCountry = cr.readCity(citiesFile);

        String source = args[4];
        String destination = args[5];

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