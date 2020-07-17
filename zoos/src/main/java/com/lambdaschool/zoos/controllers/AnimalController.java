package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.services.AnimalService;
import com.lambdaschool.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    // GET http://localhost:2019/animals/count
    @GetMapping(value = "/count", produces = {"application/json"})
    public ResponseEntity<?> getAnimalCount() {

        List<AnimalCount> animals = animalService.getAnimalCount();

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }
}
