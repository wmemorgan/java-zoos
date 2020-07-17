package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {

    @Autowired
    ZooRepository zooRepository;

    @Override
    public List<Zoo> findAll() {
        List<Zoo> myList = new ArrayList<>();

        zooRepository.findAll().iterator()
                .forEachRemaining(myList::add);

        return myList;
    }

    @Override
    public Optional<Zoo> findZooById(long id) {
        Optional<Zoo> z = zooRepository.findById(id);

        if (z == null) {
            throw new EntityNotFoundException("Zoo " + id + " not found");
        }

        return z;
    }
}
