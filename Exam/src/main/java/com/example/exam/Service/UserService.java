package com.example.exam.Service;

import com.example.exam.Model.User;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class UserService {
    ArrayList<User> users = new ArrayList<>();

    public ResponseEntity getAll(){
        return users;

    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(String id ,User user ){
        for (int i =0 ; i<users.size() ; i++){
            if (users.get(i).equals(id)){
                users.set(i , user);
                return true;
            }
        }
        return false ;

    }

    public boolean deleteUser(String id){

        for(User u : users){
            if (u.getId().equals(id)){
                users.remove(u);
                return true;
            }

        }
        return false;
    }

    public ArrayList<User> getBalance(double balance){
        ArrayList<User> allBalance = new ArrayList<>();

        for (User u : users){
            if (u.getBalance() >= balance){
                allBalance.add(u);
            }
        }
        return allBalance;
    }

    public ArrayList<User> getAge(int age){
        ArrayList<User> allAge =new ArrayList<>();

        for (User u : users){
            if (u.getAge() == age){
                allAge.add(u);
            }
        }
        return allAge ;
    }












}
