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
     * @param id The primary key (long) of the Zoo you seek
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
     * Updates the provided fields in the zoo record referenced by the primary key.
     * <p>
     * Regarding Telephone and Animal items, this process only allows adding those. Deleting and editing those lists
     * is done through a separate endpoint.
     *
     * @param zoo just the zoo fields to be updated.
     * @param id   The primary key (long) of the zoo to update
     * @return the complete zoo object that got updated
     */
    Zoo update(Zoo zoo, long id);

    /**
     * Deletes the zoo record and its telephone and animal items from the database based off of the provided primary key
     *
     * @param id id The primary key (long) of the zoo you seek.
     */
    void delete(long id);
}
