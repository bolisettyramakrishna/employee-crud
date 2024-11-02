package example_temp.springboot_temp.controller;


import example_temp.springboot_temp.entity.Product;
import example_temp.springboot_temp.entity.User;
import example_temp.springboot_temp.repo.ProductRepo;
import example_temp.springboot_temp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){

       return userRepo.save(user);
    }

    @GetMapping("/get-users")
    public List<User> getUsers(){

        return userRepo.findAll();
    }

}