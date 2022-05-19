package com.narxoz.kz.car.service;

import com.narxoz.kz.car.model.Role;
import com.narxoz.kz.car.model.User;
import com.narxoz.kz.car.repository.RoleRepository;
import com.narxoz.kz.car.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(List.of(roleRepository.getById(1L)))); // USER
        userRepository.save(user);
    }
}