package org.example.hpcl.contorllers;

import org.example.hpcl.dtos.ResponseStatus;
import org.example.hpcl.dtos.SignRequestDto;
import org.example.hpcl.dtos.SignUpReponseDto;
import org.example.hpcl.models.User;
import org.example.hpcl.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")  // Define the base path for this controller
public class UserController {

    private final UserService userService;

    // Constructor injection of UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Define the POST mapping for user registration
    @PostMapping("/register")
    public SignUpReponseDto register( SignRequestDto requestDto) {
        SignUpReponseDto responseDto = new SignUpReponseDto();
        try {
            User user = userService.register(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

