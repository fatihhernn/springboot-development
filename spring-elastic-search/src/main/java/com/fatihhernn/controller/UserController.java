package com.fatihhernn.controller;


import com.fatihhernn.entity.User;
import com.fatihhernn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor // dependency injection sağlaması için gerekli olan parametreyi ctor'a ekler
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    /*
    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search){
        List<User> users=userRepository.getByCustomQuery(search);
        return ResponseEntity.ok(users);
    }

     */


    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search){
        List<User> users=userRepository.findByNameLikeOrSurnameLike(search,search);
        return ResponseEntity.ok(users);
    }


    @PostConstruct
    void init(){
        User user=new User();
        user.setName("Fatih");
        user.setSurname("Eren");
        user.setId("k0011");
        user.setAddress("İstanbul");
        user.setBirthdate(Calendar.getInstance().getTime());
        userRepository.save(user);
    }

}
