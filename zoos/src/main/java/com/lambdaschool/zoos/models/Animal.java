package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The entity allowing interaction with the animals table
 */
@Entity
@Table(name = "animal")
public class Animal extends Auditable{

    /**
     * The primary key (long) of the animals table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    /**
     * The animal name (String). Cannot be null
     */
    @Column(nullable = false)
    private String animaltype;


    /**
     * Creates a join table joining Animals and Zoos in a Many-To-Many relations.
     * Contains a List of Zoo Objects associated with this animal.
     */
    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal")
    private List<ZooAnimals> zoos = new ArrayList<>();

    public Animal() {
    }

    public Animal(String animaltype) {
        this.animaltype = animaltype;
    }


    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }


    public List<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(List<ZooAnimals> zoos) {
        this.zoos = zoos;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalid=" + animalid +
                ", animaltype='" + animaltype + '\'' +
                ", zoos=" + zoos +
                '}';
    }
}
