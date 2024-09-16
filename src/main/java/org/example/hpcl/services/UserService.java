package org.example.hpcl.services;

import org.example.hpcl.exceptions.AuthorizedException;
import org.example.hpcl.exceptions.InvalidUserException;
import org.example.hpcl.models.Roles;
import org.example.hpcl.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User register(String name, String email, String Password, Roles roles);
    public User Employeelogin(String email, String Password) throws InvalidUserException;
    public List<User> AdminLogin(String email, String password) throws InvalidUserException, AuthorizedException;


}
