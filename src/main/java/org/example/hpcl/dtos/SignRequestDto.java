package org.example.hpcl.dtos;

import lombok.Data;
import org.example.hpcl.models.Roles;

@Data
public class SignRequestDto {
    String name;
    String email;
    String password;
    Roles roles;
}
