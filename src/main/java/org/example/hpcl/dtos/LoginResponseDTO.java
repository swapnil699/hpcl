package org.example.hpcl.dtos;

import lombok.Data;
import org.example.hpcl.models.User;

import java.util.List;

@Data
public class LoginResponseDTO {
    ResponseStatus responseStatus;
    User user;
    List<User> userList;
}
