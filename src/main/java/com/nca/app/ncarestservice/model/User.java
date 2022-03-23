package com.nca.app.ncarestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 2, max = 45, message = "Name should be between 2 and 45 symbols")
    private String name;

    @Column(name = "surname")
    @Size(min = 2, max = 45, message = "Surname should be between 2 and 45 symbols")
    private String surname;

    @Column(name = "patronymic")
    @Size(max = 45, message = "Patronymic should be between 2 and 45 symbols")
    private String patronymic;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be more than 0")
    private int age;

    @NotNull
    @Column(name = "email", unique = true)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    @NotBlank(message = "Email should not be empty")
    private String email;
}
