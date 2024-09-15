package org.example.hpcl.services;

import org.example.hpcl.models.User;
import org.example.hpcl.repositories.UserRepositories;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepositories userRepositories;

    // Add public access modifier
    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public User register(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepositories.save(user);
        return user;
    }

    @Override
    public void login(String email, String Password) {
        // Login logic can be implemented here
    }
}

