package org.example.hpcl.dtos;

import lombok.Data;
import org.example.hpcl.models.User;

@Data
public class SignUpResponseDto {
    User user;
    ResponseStatus responseStatus;
}
