package com.HomeProject.demo.service;

import com.HomeProject.demo.model.Profile;
import com.HomeProject.demo.repository.Profiles;
import com.HomeProject.demo.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Signup {
    @Autowired
    private Users user;
    @Autowired
    private Profiles pro;
    public boolean addUser(String userId,String pwd){
        return user.addUser(userId, pwd);
    }
    public boolean addProfile(String userId , String name,int age, String mail,String pwd){
        addUser(userId,pwd);
        Profile prof = new Profile();
        prof.setAge(age);
        prof.setMail(mail);
        prof.setName(name);
        return pro.addProfile(userId, prof);
    }
    public Profile getProfile(String userId){
        return pro.getProfile(userId);
    }


}
