package com.fatihhernn.rc.api;

import com.fatihhernn.rc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String WEB_URL="http://localhost:8080/user";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        ResponseEntity<List> result= restTemplate.getForEntity(WEB_URL,List.class);
        List<UserDto> responseBody=result.getBody();
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        ResponseEntity<UserDto> result=restTemplate.postForEntity(WEB_URL,userDto,UserDto.class);
        UserDto responseBody=result.getBody();
        return  ResponseEntity.ok(responseBody);
    }
}
