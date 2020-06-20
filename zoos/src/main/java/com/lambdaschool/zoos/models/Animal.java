package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The entity allowing interaction with the animals table
 */
//@Entity
@Table(name = "animals")
public class Animal extends Auditable{

    /**
     * The primary key (long) of the animals table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    /**
     * The animal name (String). Cannot be null and must be unique
     */
    @Column(nullable = false, unique = true)
    private String animaltype;


    /**
     * The name (String) of the zoo where the animal
     * was previously located
     */
    private String incomingzoo;

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

    public Animal(String animaltype, String incomingzoo) {
        this.animaltype = animaltype;
        this.incomingzoo = incomingzoo;
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

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
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
                ", incomingzoo='" + incomingzoo + '\'' +
                ", zoos=" + zoos +
                '}';
    }
}
