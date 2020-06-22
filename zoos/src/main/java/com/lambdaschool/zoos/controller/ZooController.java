package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    /**
     * Using the Zoo service to process zoo data
     */
    @Autowired
    private ZooService zooService;

    /**
     * List of all zoos
     * <br>Example: <a href="http://localhost:2019/zoos/zoos">http://localhost:2019/zoos/zoos</a>
     *
     * @return JSON List of all the roles and their associated users
     * @see ZooService#findAll() ZooService.findAll()
     */
    @GetMapping(value="/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos() {
        List<Zoo> zooList = zooService.findAll();

        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    /**
     * Returns a single user based off a user id number
     * <br>Example: http://localhost:2019/zoos/zoo/{zooid}
     *
     * @param zooid The primary key of the user you seek
     * @return JSON object of the user you seek
     * @see ZooService#findZooById(long) (long) ZooService.findZooById(long)
     */
    @GetMapping(value = "/zoo/{zooid}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable long zooid) {
        Zoo z = zooService.findZooById(zooid);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    /**
     * Given a complete Zoo Object, create a new User record and accompanying useremail records
     * and user role records.
     * <br> Example: <a href="http://localhost:2019/users/user">http://localhost:2019/users/user</a>
     *
     * @param newZoo A complete new user to add including emails and roles.
     *                roles must already exist.
     * @return A location header with the URI to the newly created user and a status of CREATED
     * @throws URISyntaxException Exception if something does not work in creating the location header
     * @see ZooService#save(Zoo) ZooService.save(Zoo)
     */
    @PostMapping(value = "/zoo", consumes = {"application/json"})
    public ResponseEntity<?> addZoo(@Valid @RequestBody Zoo newZoo) {
        newZoo.setZooid(0);
        newZoo = zooService.save(newZoo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{newzooid}")
                .buildAndExpand(newZoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

    }
}
