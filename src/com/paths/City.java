package com.paths;

/**
 * Created by ananthur on 3/9/2015.
 */
class City {
    private String city;
    private String country;

    public City (String city, String country){
        this.city = city;
        this.country = country;
    }

    public String toString(){
        return "City "+city+" country "+country;
    }
}
