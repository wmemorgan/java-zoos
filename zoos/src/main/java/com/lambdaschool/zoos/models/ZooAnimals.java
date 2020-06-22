package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The entity joining Zoos and Animals tables
 */

@Entity
@Table(name = "zooanimals", uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "animalid"})})
public class ZooAnimals extends Auditable implements Serializable {

    /**
     * The foreign key (Zoo) of the zoos table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals")
    private Zoo zoo;

    /**
     * The foreign key (Animal) of the animals table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos")
    private Animal animal;

    /**
     * The name (String) of the zoo where the animal
     * was previously located
     */
    private String incomingzoo;

    public ZooAnimals() {
    }

    public ZooAnimals(Zoo zoo, Animal animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    public ZooAnimals(Zoo zoo, Animal animal, String incomingzoo) {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = incomingzoo;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimals that = (ZooAnimals) o;
        return zoo.equals(that.zoo) &&
                animal.equals(that.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoo, animal);
    }
}
