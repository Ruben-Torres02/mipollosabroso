package com.mipollosabroso.web.sprintboot_mipollosabroso.services;

import java.util.List;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);
    

}
