package com.fatihhernn.api;

import com.fatihhernn.entity.User;
import com.fatihhernn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    UserRepository userRepository;


    @PostConstruct
    void init(){
        User user=new User();
        user.setName("Fatih");
        user.setSurname("Eren");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
