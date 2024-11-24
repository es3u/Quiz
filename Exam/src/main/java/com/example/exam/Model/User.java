package com.example.exam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "id can not be empty ")

    private String id ;
    @NotEmpty(message = "name can not be empty")
    @Size(min = 4 ,max = 30 , message = "enter your name between 4 and 30")
    private String name;
    @NotNull(message = "age can not be null")
    @Min(value = 18 , message = "wrong , age can be > 18")
    @Max(100 )
    private int age ;
    @NotNull(message = "balance can not be empty")
    @Min(value = 0,message = "balance can not be less than 0")
    private double balance ;
    @NotEmpty(message = "role can not be empty")
    @Pattern(regexp = "^(customer|libraian)" , message = "Please chose between customer or libraian")
    private String role ;
}
