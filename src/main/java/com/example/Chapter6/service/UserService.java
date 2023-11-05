package com.example.Chapter6.service;

import com.example.Chapter6.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User addUser(User user);

    public User updateUser(User user) ;

    public void deleteUser(User user) ;
}
