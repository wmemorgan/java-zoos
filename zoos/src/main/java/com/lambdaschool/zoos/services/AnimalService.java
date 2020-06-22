package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;

/**
 * The service that works with the Animal model.
 */
public interface AnimalService {

    /**
     * Return the first Animal matching the given primary key
     *
     * @param id The primary key (long) of the Role you seek
     * @return The Animal object you seek
     */
    Animal findAnimalById(long id);
}
