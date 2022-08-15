package com.demo.d.controller;

import com.demo.d.model.Message;
import com.demo.d.model.User;
import com.demo.d.repositiry.MessageRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestAvito {



    @Autowired
    MessageRepository messageRepository;

    @CrossOrigin
    @RequestMapping(value = "/message/send",method = POST)
    public void pos(@RequestBody String json, @AuthenticationPrincipal User user){
        JSONObject jsonObject = new JSONObject(json);



        messageRepository.save(new Message(jsonObject.getString("text"), jsonObject.getString("tag"),user));
    }

    @RequestMapping(value = "/list/message",method = GET)
    public List post(){
        
        List<Message> messages = messageRepository.findAll();

        return messages;
    }
}
