
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.UserHelper;
import java.util.List;
import pojos.User;

/**
 *
 * @author danielbram
 */
public class testcheckuser {

    public static void main(String[] args) {

        UserHelper test = new UserHelper();
        User user = test.getUser("puspa@usd.ac.id", "123456789");
        if (user != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user);
            System.out.println(json);
        }
        User user1 = test.getUser("puspa@usd.ac.id", "12345");
        if (user1 != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user1);
            System.out.println(json);
        }
        User user2 = test.getUser("puspa@usd.ac", "123456789");
        if (user2 != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user2);
            System.out.println(json);
        }

    }
}
