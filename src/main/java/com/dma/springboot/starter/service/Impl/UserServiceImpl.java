package com.dma.springboot.starter.service.Impl;

import com.dma.springboot.starter.model.User;
import com.dma.springboot.starter.repository.UserRepository;
import com.dma.springboot.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllusers(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public User findById(Long id){
        User user = null;
        Optional<User> result = userRepository.findById(id);
        user = result.get();
        return user;
    }
}
