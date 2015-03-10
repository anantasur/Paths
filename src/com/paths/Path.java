package com.paths;

/**
 * Created by ananthur on 3/9/2015.
 */
import java.util.*;

public class Path {
     Map<String, List<String>> routes = new HashMap<String, List<String>>();
    Map<String,String> cityCountryMap = new HashMap<String, String>();
    Queue path = new LinkedList();
    {
        List<String> bangalore = new ArrayList<String>();
        bangalore.add("Singapore");

        List<String> singapore = new ArrayList<String>();
        singapore.add("Seoul");
        singapore.add("Bangalore");
        singapore.add("Dubai");

        List<String> seoul = new ArrayList<String>();
        seoul.add("Singapore");
        seoul.add("Beijing");

        List<String> beijing = new ArrayList<String>();
        beijing.add("Seoul");
        beijing.add("Tokyo");

        List<String> dubai = new ArrayList<String>();
        dubai.add("Singapore");

        List<String> tokyo = new ArrayList<String>();
        tokyo.add("Beijing");

        routes.put("Bangalore", bangalore);
        routes.put("Singapore", singapore);
        routes.put("Seoul", seoul);
        routes.put("Beijing", beijing);
        routes.put("Dubai", dubai);
        routes.put("Tokyo", tokyo);
    }

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

    public boolean hasPath(String source, String destination){
        path.add(source);
        return (getFullPath(source,destination) == 1) ? true : false;
    }

    public int getFullPath(String source, String destination){
        if(routes.get(source) == null) return 0;
        if(routes.get(source).contains(destination)){
            path.add(destination);
            return 1;
        }
        if(!routes.get(source).contains(destination)){
            int size = routes.get(source).size();
            for(int i = 0; i < size; i++){
                if(!path.contains(routes.get(source).get(i))){
                    path.add(routes.get(source).get(i));
                    return getFullPath(routes.get(source).get(i),destination);
                }
            }
        }
        return 0;
    }

    public String printPath(String source, String destination){
        boolean hasPath = hasPath(source, destination);
        int size = path.size();
        String fullRoute = "";
        for(int i = 0; i < size; i++){
            String place = (String) path.poll();
            if(i>0)
                fullRoute += "->"+place+"["+cityCountryMap.get(place)+"]";
            else
                fullRoute += ""+place+"["+cityCountryMap.get(place)+"]";
        }
        return fullRoute;
    }
}