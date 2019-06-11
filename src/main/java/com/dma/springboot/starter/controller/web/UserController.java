package com.dma.springboot.starter.controller.web;

import com.dma.springboot.starter.model.User;
import com.dma.springboot.starter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
        logger.info("in UserController - getUser");
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/view";
    }

    @GetMapping(value="/user/{id}/edit")
    public String prepareEditUser(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping(value="/user/{id}/edit")
    public String editUser(@PathVariable("id") Long id, @Valid User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            user.setId(id);
            return "user/edit";
        }
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllusers());
        return "user/listAll";
    }

    @GetMapping(value="/user/add")
    public String prepareAddUser( Model model){
        logger.info("in UserController - prepareAddUser");
        User user = new User();
        model.addAttribute("user", user);
        return "user/add";
    }

    @PostMapping(value="/user/add")
    public String addUser(@Valid User user, BindingResult result, Model model){
        logger.info("in UserController - addUser");
        if (result.hasErrors()) {
            return "user/add";
        }
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllusers());
        return "user/listAll";
    }

    
}
