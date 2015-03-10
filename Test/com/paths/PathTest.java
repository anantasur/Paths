package com.paths;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

public class PathTest {
    Map<String, List<String>> routes = new HashMap<String, List<String>>();
    Map<String, String> citiesAndCountry = new HashMap<String, String>();
    Path path = new Path();

    public void set_up() throws IOException {
        File f = new File("./data/Paths.txt");
        PathReader pr = new PathReader();
        routes = pr.readPath(f);

        File c = new File("./data/cities.txt");
        CitiesReader cr = new CitiesReader();
        citiesAndCountry = cr.readCity(c);
        path.insertMap(citiesAndCountry);
        path.insertPath(routes);
    }

    @Test
    public void isPresent_checks_whether_city_is_prsent () throws IOException {
        set_up();
        assertFalse(path.isPresent("Chennai"));
        assertTrue(path.isPresent("Dubai"));
        assertTrue(path.isPresent("Tokyo"));
        assertTrue(path.isPresent("Singapore"));
        assertTrue(path.isPresent("Beijing"));
    }

}
