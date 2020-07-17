package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public List<AnimalCount> getAnimalCount() {
        return animalRepository.getAnimalCount();
    }
}
