package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;

import java.util.List;
import java.util.Optional;

public interface ZooService {

    /**
     * Returns a list of all zoos
     *
     * @return - List of Zoos. If no zoos, empty list.
     */
    List<Zoo> findAll();


    /**
     * Returns a zoo with the given primary key
     *
     * @param id
     * @return - The given Zoo or throws an exception if not found.
     */
    Optional<Zoo> findZooById(long id);
}
