package org.example.hpcl.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "User")
@Data
public class User extends BaseModel{
    private String name;
    private String password;
    private String email;
    private Roles roles;
}
