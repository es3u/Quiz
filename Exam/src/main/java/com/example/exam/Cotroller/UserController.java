package com.example.exam.Cotroller;

import com.example.exam.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService users;


    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid com.example.exam.Model.User user , Errors errors){

        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        users.addUser(user);
        return ResponseEntity.status(200).body("added user");

    }

    @GetMapping("getAll")
    public ResponseEntity getAll(){
        return users.getAll();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id  , @RequestBody @Valid com.example.exam.Model.User user , Errors errors){

        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        boolean b =  users.updateUser(id , user);
        if (b){
            return ResponseEntity.ok().body("Updated user");
        }
        else
            return ResponseEntity.badRequest().body("not found");



    }

    @DeleteMapping("/deelet/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){

        if (users.deleteUser(id) == true){
            return ResponseEntity.ok().body("deleeted is ok");
        }

        return ResponseEntity.badRequest().body("is not found");

    }

    @GetMapping("/getBalance/{balance}")
    public ResponseEntity getBalance(double balance){


         return ResponseEntity.ok().body(users.getBalance(balance));
    }

    @GetMapping("/getAge/{age}}")
    public ResponseEntity getAge(int age){

        return ResponseEntity.ok().body(users.getAge(age));
    }






}
