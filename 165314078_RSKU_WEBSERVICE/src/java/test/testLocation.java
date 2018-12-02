/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.AntrianHelper;
import helper.LocationHelper;
import java.util.List;
import pojos.Location;


/**
 *
 * @author danielbram
 */
public class testLocation {
    public static void main(String[] args) {
        LocationHelper test = new LocationHelper();
        List<Location> list = test.getAllLocation();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
