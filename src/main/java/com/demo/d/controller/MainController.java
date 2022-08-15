package com.demo.d.controller;


import com.demo.d.model.Role;
import com.demo.d.model.User;
import com.demo.d.repositiry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class MainController

{



    @Autowired
    UserRepositry userRepositry;





    @GetMapping("/registration")
    public String registration(){
        return "registration";


    }


    @PostMapping("/registration")
    public String registrationPost(User user, Model model
                                    ){

        User user1 = userRepositry.findByUsername(user.getUsername());

        if(user1!=null){
            model.addAttribute("message","User exists");
            return "registration";

        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepositry.save(user);
        return "redirect:/login";
    }
}
