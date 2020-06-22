package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Implements the AnimalService interface
 */
@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {

    /**
     * Connects this service to the Animal model
     */
    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public Animal findAnimalById(long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal ID " + id + " not found"));
    }
}
