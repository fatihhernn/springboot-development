package com.fatihhernn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim pet API documentation")
public class PetController {

    List<Pet> petList=new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1,"Test pet",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet ekleme metodu",notes = "Bu metodu kullanırken dikkatli kullan")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "Hayvan") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi metodu",notes = "Bu metot tüm petleri getirir")
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
    }

}
