package com.example.michellewong.freebiefinder_attempt4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michellewong on 2017-03-19.
 */

public class JSONParser_User {

    public static void parseJSONUser(String string) throws JSONException {
        JSONArray myArray = new JSONArray(string);
        for (int i=0; i<myArray.length(); i++) {
            JSONObject curObj = myArray.getJSONObject(i);
            storeToManager(curObj);
        }
    }

    // parses and stores data to UserManager
    public static void storeToManager(JSONObject curObj) throws JSONException {
        String id = curObj.getString("email");
        String name = curObj.getString("name");
        String[] type = curObj.getString("preferences").split(",");
        User user = new User(id);
        user.setName(name);
        for (String i : type) {
            if (i.equals("ART")) {
                user.addCategory(Attraction.Type.ARTS);
            } else if (i.equals("BUSINESS")) {
                user.addCategory(Attraction.Type.BUSINESS);
            } else if (i.equals("FOOD")) {
                user.addCategory(Attraction.Type.FOOD);
            } else if (i.equals("GAME")) {
                user.addCategory(Attraction.Type.GAME);
            } else if (i.equals("HEALTH")) {
                user.addCategory(Attraction.Type.HEALTH);
            } else if (i.equals("OTHER")) {
                user.addCategory(Attraction.Type.OTHER);
            } else if (i.equals("SOCIAL")) {
                user.addCategory(Attraction.Type.SOCIAL);
            } else if (i.equals("SPORTS")) {
                user.addCategory(Attraction.Type.SPORTS);
            } else if (i.equals("TECH")) {
                user.addCategory(Attraction.Type.TECH);
            } else {
                throw new RuntimeException("Nonexistent category");
            }
        }
        UserManager.getOurInstance().addUser(user);
    }

}