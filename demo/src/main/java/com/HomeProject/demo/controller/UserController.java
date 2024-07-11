package com.HomeProject.demo.controller;
import com.HomeProject.demo.dto.ProfileDto;
import com.HomeProject.demo.dto.requestdto.LoginDto;
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
    public ProfileDto login(@RequestBody LoginDto loginDto){
        String userId = loginDto.getUserid();
        boolean shouldLogin =  loginSerice.authorize( userId, loginDto.getPassword());
        if(shouldLogin){
            Profile profile = signup.getProfile(userId);

            ProfileDto dto = new ProfileDto();
            String fname = profile.getName().split(" ")[0];
            String lname = profile.getName().split(" ").length>0 ? profile.getName().split(" ")[1] : "";
            dto.age = profile.getAge();
            dto.userId = userId;
            dto.fname = fname;
            dto.lname = lname;

            return dto;
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
