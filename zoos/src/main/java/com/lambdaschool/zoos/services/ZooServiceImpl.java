package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the ZooService interface
 */
@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    /**
     * Connects this service to the Zoo model
     */
    @Autowired
    ZooRepository zooRepository;

    /**
     * Connects this service to the Zoo model
     */
    @Autowired
    AnimalService animalService;

    @Autowired
    private UserAuditing userAuditing;

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

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {

        Zoo newZoo = new Zoo();
        if (zoo.getZooid() != 0) {
            findZooById(zoo.getZooid());

            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname());

        newZoo.getTelephones().clear();
        for (Telephone t : zoo.getTelephones()) {
            Telephone newTelephone = new Telephone(t.getPhonetype(), t.getPhonenumber(), newZoo);
            newZoo.getTelephones().add(newTelephone);
        }

        newZoo.getAnimals().clear();
        for (ZooAnimals a: zoo.getAnimals()) {
            if (zooRepository.checkZooAnimalsCombo(zoo.getZooid(), a.getAnimal().getAnimalid()).getCount() > 0) {
                Animal newAnimal = animalService.findAnimalById(a.getAnimal().getAnimalid());
                newZoo.addAnimal(newAnimal, a.getIncomingzoo());
            }

        }

        return zooRepository.save(newZoo);
    }

}
