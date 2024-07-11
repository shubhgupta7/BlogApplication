package com.HomeProject.demo.repository;

import com.HomeProject.demo.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Profiles {

    private final Profile profile = new Profile();

    @Autowired
    private Users user;

    private static Map<String, Profile> profilesTable = new HashMap<>();

    public boolean addProfile(String userId, Profile prof) {
        profilesTable.put(userId, prof);
        return true;
    }

    public boolean checkProfile(String userId){
        if(profilesTable.containsKey(userId)) return true;
        return false;
    }

    public Profile getProfile(String userId) {
        if(checkProfile(userId)){
            Profile profile = profilesTable.get(userId);
            return profile;
        }
        return null;
    }


}
