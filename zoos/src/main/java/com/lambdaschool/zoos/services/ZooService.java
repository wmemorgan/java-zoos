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
}
