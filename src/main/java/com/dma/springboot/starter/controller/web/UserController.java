package com.dma.springboot.starter.controller.web;

import com.dma.springboot.starter.model.User;
import com.dma.springboot.starter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    protected UserService userService;

    @RequestMapping(value="/users")
    public String getUsers(Model model){
        logger.info("in UserController - getUsers");
        List<User> users = userService.getAllusers();
        logger.info("total users: "+users.size());
        model.addAttribute("users",users);
        return "user/listAll";
    }

    @RequestMapping(value="/user/{id}")
    public String getUser(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/view";
    }
}
