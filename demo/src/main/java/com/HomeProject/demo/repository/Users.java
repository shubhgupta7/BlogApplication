package com.HomeProject.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Users {

    private static Map<String,String> usersTable = new HashMap<>();
    static {
        usersTable.put("abc", "xyz");
        usersTable.put("shubh", "shubh");
    }

    public boolean checkUser(String userid, String encryptedPwd){
        return usersTable.containsKey(userid) && (usersTable.get(userid)+"123").equals(encryptedPwd);
    }
    public boolean addUser(String userid, String pwd){
        usersTable.put(userid,pwd);
        return true;
    }
    public Map<String,String> getUsers(){

    }

}
