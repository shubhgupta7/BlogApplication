package com.HomeProject.demo.controller;
import com.HomeProject.demo.model.Profile;
import com.HomeProject.demo.service.Login;
import com.HomeProject.demo.service.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {

    @Autowired
    private Login loginSerice;
    @Autowired
    private Signup signup;

    @PostMapping("/login")
    public Profile login(@RequestParam("userid") String userId, @RequestParam("password") String pwd){
        boolean shouldLogin =  loginSerice.authorize(userId, pwd);
        if(shouldLogin){
            return signup.getProfile(userId);
        }
        return null;

    }

    @PostMapping("/signup")
    public String signup (@RequestParam("userid") String userId, @RequestParam("password") String pwd ,@RequestParam("Name") String name, @RequestParam("Age") int age, @RequestParam("EmailId") String mail)
    {
        signup.addProfile(userId,name,age,mail,pwd);
        signup.addUser(userId,pwd);
        return "User "+ userId +" Added to the DataBase";
    }
    @RequestMapping("/")
    public String hw(){
        return "hello world";
    }


}
