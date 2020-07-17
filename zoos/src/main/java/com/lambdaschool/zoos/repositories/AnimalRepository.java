package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT animaltype, a.animalid, COUNT(zooid) as countzoos " +
            "FROM animals a JOIN zooanimals za " +
            "ON a.animalid = za.animalid " +
            "GROUP BY a.animalid, animaltype " +
            "ORDER BY animaltype", nativeQuery = true)
    List<AnimalCount> getAnimalCount();
}
