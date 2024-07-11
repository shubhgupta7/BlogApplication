package com.HomeProject.demo.service;

import com.HomeProject.demo.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login {

    @Autowired
    private Users userRepository;

    @Autowired
    private Crypt cryptionEngine;

    public boolean authorize(String userid, String pwd){
        String encryptedPwd = cryptionEngine.encrypt(pwd);
        return userRepository.checkUser(userid, encryptedPwd);
    }
}
