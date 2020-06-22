package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCountZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    /**
     * List all animals and a count of how many zoos where they can be found
     * @return List of animals and the number of zoos where they can be found
     */
    @Query(value = "SELECT a.ANIMALTYPE, a.ANIMALID, COUNT(z.ANIMALID) as countzoos FROM ANIMAL a LEFT JOIN ZOOANIMALS z on a.ANIMALID = z.ANIMALID GROUP BY a.ANIMALTYPE, a.ANIMALID",
    nativeQuery = true)
    List<AnimalCountZoos> getCountAnimalZoos();

}
