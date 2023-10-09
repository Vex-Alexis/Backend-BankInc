package com.alexis.nexos.credibanco.bankinc.service.impl;

import com.alexis.nexos.credibanco.bankinc.entity.User;
import com.alexis.nexos.credibanco.bankinc.repository.UserRepository;
import com.alexis.nexos.credibanco.bankinc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
