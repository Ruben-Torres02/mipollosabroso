package com.mipollosabroso.web.sprintboot_mipollosabroso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.Role;
import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.User;
import com.mipollosabroso.web.sprintboot_mipollosabroso.repositories.RoleRepository;
import com.mipollosabroso.web.sprintboot_mipollosabroso.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        
        optionalRole.ifPresent(roles::add);
        
        if(user.isAdmin()){

            Optional<Role> optionalRoleAdmin = roleRepository.findByRole("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
