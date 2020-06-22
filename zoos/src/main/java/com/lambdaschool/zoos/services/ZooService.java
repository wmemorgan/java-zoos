package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;

import java.util.List;

/**
 * The service that works with the Zoo model.
 */
public interface ZooService {
    /**
     * Returns a list of all Zoo objects
     *
     * @return list of all Zoo object
     */
    List<Zoo> findAll();

    /**
     * Return the first Zoo matching the given primary key
     *
     * @param id The primary key (long) of the Role you seek
     * @return The Zoo object you seek
     */
    Zoo findZooById(long id);

    /**
     * Given a complete zoo object, saves that zoo object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     *
     * @param zoo the zoo object to be saved
     * @return the saved zoo object including any automatically generated fields
     */
    Zoo save(Zoo zoo);

    /**
     * Adds an entry to the ZooAnimals join table
     * @param zooid
     * @param animalid
     */
    void addZooAnimal(long zooid, long animalid);
}
