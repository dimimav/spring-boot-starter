package com.dma.springboot.starter.service;

import com.dma.springboot.starter.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAllusers();

    User findById(Long id);
    
    User saveUser(User user);
}
