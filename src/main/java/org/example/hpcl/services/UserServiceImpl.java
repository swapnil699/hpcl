package org.example.hpcl.services;

import org.example.hpcl.exceptions.AuthorizedException;
import org.example.hpcl.exceptions.InvalidUserException;
import org.example.hpcl.models.Roles;
import org.example.hpcl.models.User;
import org.example.hpcl.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public User register(String name, String email, String password, Roles roles) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roles);
        return userRepositories.save(user);
    }

    @Override
    public User Employeelogin(String email, String password) throws InvalidUserException {
        Optional<User> userOptional = userRepositories.findUserByEmail(email);  // Updated method name
        if (!userOptional.isPresent()) {
            throw new InvalidUserException("Invalid user: " + email);
        }

        User user = userOptional.get();
        if (!password.equals(user.getPassword())) {
            throw new InvalidUserException("Invalid password");
        }
        return user;
    }

    @Override
    public List<User> AdminLogin(String email, String password) throws InvalidUserException, AuthorizedException {
        Optional<User> userOptional = userRepositories.findUserByEmail(email);  // Updated method name
        if (!userOptional.isPresent()) {
            throw new InvalidUserException("Invalid user: " + email);
        }

        User user = userOptional.get();
        if (!user.getRoles().equals(Roles.Admin)) {
            throw new AuthorizedException("Only Admin has access");
        }

        if (!password.equals(user.getPassword())) {
            throw new InvalidUserException("Invalid password");
        }

        return userRepositories.findAll();
    }
}
