package com.demo.d.controller;

import com.demo.d.model.Message;
import com.demo.d.repositiry.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class Avito {

    @Autowired
    MessageRepository messageRepository;






    @GetMapping("/main")
    public String index(Model model){
        List<Message> messages = messageRepository.findAll();
        Collections.reverse(messages);
        model.addAttribute("messages",messages);
        return "index";
    }
    @GetMapping
    public String mainn(){return "main";}

}
