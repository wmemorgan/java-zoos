package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD repository connecting Zoo model to the rest of the application
 */
public interface ZooRepository extends CrudRepository<Zoo, Long> {

}
