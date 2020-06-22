package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable long zooid) {
        Zoo z = zooService.findZooById(zooid);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}
