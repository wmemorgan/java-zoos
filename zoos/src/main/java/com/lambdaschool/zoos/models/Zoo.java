package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The entity allowing interaction with the zoos table
 */
@Entity
@Table(name = "zoo")
public class Zoo extends Auditable{
    /**
     * The primary key (long) of the zoos table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    /**
     * The zoo name (String). Cannot be null and must be unique
     */
    @Column(nullable = false, unique = true)
    private String zooname;

    /**
     * Creates a join table joining Zoos and Telephones in a One-To-Many relation.
     * Contains a List of Telephone Objects used by this zoo.
     */
    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    /**
     * Creates a join table joining Zoos and Animals in a Many-To-Many relations.
     * Contains a List of Animal Objects that are in this zoos.
     */
    @OneToMany(mappedBy = "zoo",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo")
    private List<ZooAnimals> animals = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(String zooname) {
        this.zooname = zooname;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ZooAnimals> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(new ZooAnimals(this, animal));
    }

    public void addAnimal(Animal animal, String incomingzoo) {
        animals.add(new ZooAnimals(this, animal, incomingzoo));
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                ", telephones=" + telephones +
                ", animals=" + animals +
                '}';
    }
}
