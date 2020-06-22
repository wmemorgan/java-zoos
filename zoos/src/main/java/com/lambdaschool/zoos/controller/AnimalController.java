package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.views.AnimalCountZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The entry point for clients to access animal data
 */

@RestController
@RequestMapping("/animals")
public class AnimalController {

    /**
     * Using the Animal Repository to access Animal data
     */
    @Autowired
    private AnimalRepository animalRepository;

    /**
     * List of all animals and a count of zoos where they can be found
     * <br>Example: <a href="http://localhost:2019/animals/count">http://localhost:2019/animals/count</a>
     *
     * @return JSON List of all the animals and their associated users
     * @see AnimalRepository#getCountAnimalZoos() AnimalRepository.getCountAnimalZoos()
     */
    @GetMapping(value="/count", produces = {"application/json"})
    public ResponseEntity<?> listAnimalsByZooCount() {
        List<AnimalCountZoos> animalsByZoo = animalRepository.getCountAnimalZoos();

        return new ResponseEntity<>(animalsByZoo, HttpStatus.OK);
    }
}
