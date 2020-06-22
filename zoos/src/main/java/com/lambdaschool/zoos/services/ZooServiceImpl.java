package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    @Autowired
    ZooRepository zooRepository;

    @Override
    public List<Zoo> findAll() {

        List<Zoo> rtnList = new ArrayList<>();

        zooRepository.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);

        return rtnList;
    }

    @Override
    public Zoo findZooById(long id) {
        return zooRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " not found"));
    }
}
