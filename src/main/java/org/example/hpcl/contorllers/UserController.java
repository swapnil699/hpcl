package org.example.hpcl.contorllers;


import org.example.hpcl.dtos.LoginRequestDTO;
import org.example.hpcl.dtos.LoginResponseDTO;
import org.example.hpcl.dtos.SignRequestDto;
import org.example.hpcl.dtos.SignUpResponseDto;
import org.example.hpcl.exceptions.AuthorizedException;
import org.example.hpcl.exceptions.InvalidUserException;
import org.example.hpcl.models.User;
import org.example.hpcl.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SignUpResponseDto register(@RequestBody SignRequestDto requestDto) {
        SignUpResponseDto responseDto = new SignUpResponseDto();
        try {
            User user = userService.register(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword(), requestDto.getRoles());
            responseDto.setUser(user);
            responseDto.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseDto.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    @PostMapping("/user")
    public LoginResponseDTO userLogin(@RequestBody LoginRequestDTO requestDTO) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try {
            User user = userService.Employeelogin(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUser(user);
            responseDTO.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.SUCCESS);
        } catch (InvalidUserException ex) {
            responseDTO.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    @PostMapping("/admin")
    public LoginResponseDTO adminLogin(@RequestBody LoginRequestDTO requestDTO) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try {
            List<User> userList = userService.AdminLogin(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUserList(userList);
            responseDTO.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.SUCCESS);
        } catch (InvalidUserException | AuthorizedException ex) {
            responseDTO.setResponseStatus(org.example.hpcl.dtos.ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}



