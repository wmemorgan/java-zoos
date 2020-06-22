package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.views.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * The CRUD repository connecting Zoo model to the rest of the application
 */
public interface ZooRepository extends CrudRepository<Zoo, Long> {
    @Query(value = "SELECT COUNT(*) as count FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
    JustTheCount checkZooAnimalsCombo(long zooid, long animalid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO zooanimals(zooid, animalid, createdby, createddate, lastmodified_by, lastmodifieddate) VALUES (:zooid, :animalid, :uname, CURRENT_TIMESTAMP, :uname, CURRENT_TIMESTAMP)",
            nativeQuery = true)
    void insertUserRoles(
            String uname,
            long zooid,
            long animalid);
}
