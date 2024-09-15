package org.example.hpcl.services;

import org.example.hpcl.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User register(String name, String email, String Password);
    public void login(String email, String Password);

}
