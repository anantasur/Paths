package com.paths;

import java.util.*;

public class Path {
    Map<String, List<String>> routes = new HashMap<String, List<String>>();
    Map<String,String> cityCountryMap = new HashMap<String, String>();
    public void insertPath (Map<String, List<String>> routes){
        this.routes = routes;
    }

    public void insertMap(Map<String, String> citiesAndCountry) {
        this.cityCountryMap = citiesAndCountry;
    }

    public boolean isPresent(String city){
        Set<String> sourceStations = routes.keySet();
        if(sourceStations.contains(city))
            return true;
        else{
            for(String source : sourceStations){
                List<String> destinations = routes.get(source) ;
                if(destinations.contains(city))
                    return true;
            }
        }
        return false;
    }

    public List<List<String>> getPath(String source, String destination) {
        List<String> fullPath = new ArrayList<String>();
        List<List<String>> allPaths = new ArrayList<List<String>>();
        givePath(fullPath, allPaths,source, destination);
        return allPaths;
    }

    private void givePath(List<String> fullPath, List<List<String>> allPaths,String source, String destination) {
        fullPath.add(source);
        if (source.equals(destination)) {
            allPaths.add(new ArrayList<String>(fullPath));
            fullPath.remove(source);
            return;
        }
        int size = routes.get(source).size();
        List<String> destinations = routes.get(source);
        for (int i = 0; i < destinations.size(); i++) {
            if (!fullPath.contains(destinations.get(i))) {
                givePath(fullPath, allPaths, destinations.get(i), destination);
            }
        }
        fullPath.remove(source);
    }

    public String printPath(String source, String destination) throws Exception {
        List<List<String>> allPaths = getPath(source, destination);
        int size = allPaths.size();
        String fullRoute = "";
        for(int i = 0; i < size; i++){
            List<String> fullPath = allPaths.get(i);
            int sizeOfEachPath = fullPath.size();
            if((fullPath.get(0).equals(source)) && (fullPath.get(sizeOfEachPath-1).equals(destination))) {
                String route = "";
                for (int j = 0; j < sizeOfEachPath; j++) {
                    String pathWithCity = fullPath.get(j);
                    if (j > 0) {
                        route += "->" + pathWithCity + "[" + cityCountryMap.get(pathWithCity) + "]";
                    } else {
                        route += (i+1)+" " + pathWithCity + "[" + cityCountryMap.get(pathWithCity) + "]";
                    }
                }
                fullRoute = fullRoute+"\n"+ route;
            }
        }
        return fullRoute;
    }
}