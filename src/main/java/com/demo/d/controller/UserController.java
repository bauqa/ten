package com.demo.d.controller;


import com.demo.d.model.Role;
import com.demo.d.model.User;
import com.demo.d.repositiry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepositry userRepositry;
    @GetMapping("/user")
    public String userList(Model model){
        model.addAttribute("users",userRepositry.findAll());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String EditUser(@PathVariable long id, Model model){
        model.addAttribute("user",userRepositry.findById(id));

        return "EditUser";
    }

    @PostMapping("/user/{id}")
    public String PostUser(@PathVariable long id, @RequestParam String username, @RequestParam String password,@RequestParam String roles){
        System.out.println(username + password + roles);
        User user = userRepositry.findById(id);

        user.setUsername(username);
        user.setPassword(password);
        user.getRoles().clear();
        user.getRoles().add(Role.valueOf(String.valueOf(roles)));


        userRepositry.save(user);
        return "redirect:/user";
    }
}
