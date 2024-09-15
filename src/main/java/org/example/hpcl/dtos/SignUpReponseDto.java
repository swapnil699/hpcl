package org.example.hpcl.dtos;

import lombok.Data;
import org.example.hpcl.models.User;
@Data
public class SignUpReponseDto {
    User user;
    ResponseStatus responseStatus;
}
