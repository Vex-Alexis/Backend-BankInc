package com.alexis.nexos.credibanco.bankinc.service;

import com.alexis.nexos.credibanco.bankinc.entity.User;

import java.util.List;

public interface IUserService {

    User getUserById();

    List<User> getAllUsers();



}
