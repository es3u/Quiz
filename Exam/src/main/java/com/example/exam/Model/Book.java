package com.example.exam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Book {

    @NotEmpty(message = "id can not be empty")
    @Size(min = 2 , max = 8 , message = "The size can be from 2 to 8")
    private String id;
    @NotNull(message = "number of pages ccan not be empty")
    @Size(min = 0 , message = "number of page can not be less than 0 ")
    private int  number_of_pages;
    @NotNull(message = "price can not be null")
    @Min(value = 0 , message = "can not be less than 0")
    private double price ;
    @NotEmpty(message = "category can not be empty")
    @Pattern(regexp = "^(novel|academic)$" , message = "Enter novel or academic")
    private String category;
    @NotNull(message = "can not be empty ")
    private boolean isAvailable = false  ;
}
