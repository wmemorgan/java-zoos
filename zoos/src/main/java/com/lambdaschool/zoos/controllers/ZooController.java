package com.lambdaschool.zoos.controllers;

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
import java.util.Optional;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    ZooService zooService;

    // http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos() {
        List<Zoo> zoos = zooService.findAll();

        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    // http://localhost:2019/zoos/zoo/{id}
    @GetMapping(value = "/zoo/{id}", produces = {"application/json"})
    public ResponseEntity<?> getZooById(@PathVariable long id) {
        Optional<Zoo> z = zooService.findZooById(id);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}
