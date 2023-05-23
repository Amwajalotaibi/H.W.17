package com.example.homwork17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "id can't be null")
    private Integer id;

    @NotEmpty(message = "name can't be null")
    @Column(columnDefinition = "varchar(5) not null")
    @Size(min = 4 ,max = 10 ,message = " name must be Length more than 4 ")
    private String name;

    @NotEmpty(message = "user name can't be null ")
    @Column(columnDefinition = "varchar(4) unique not null")
    @Size(min = 4 ,max = 10 ,message = " User name must be Length more than 4 ")
    private String username;

    @NotEmpty(message = " password can't be null ")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @Email
    @NotEmpty(message = "email can't be null")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = " role can't be null")
    @Column(columnDefinition =" varchar(10) not null check( role='user' or role = 'admin' )")
    private String role;

    @NotNull(message =" age can't be null")
    @Column(columnDefinition =" Int not null ")
    private Integer age;

}
