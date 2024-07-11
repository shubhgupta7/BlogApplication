package com.HomeProject.demo.service;

import org.springframework.stereotype.Service;

@Service
public class Crypt {

    public String encrypt(String pwd){
        return pwd+"123";
    }
}
