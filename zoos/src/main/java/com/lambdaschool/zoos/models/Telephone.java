package com.lambdaschool.zoos.models;

import javax.persistence.*;

/**
 * The entity allowing interaction with the telephones table
 */
@Entity
@Table(name = "telephones")
public class Telephone extends Auditable{

    /**
     * The primary key (long) of the telephone table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    /**
     * Short description (String) of location or purpose of the phone number
     */
    private String phonetype;

    /**
     * Creates a join table joining Telephones and Zoos
     * in a Many-To-One relation.
     */
    @ManyToOne
    @JoinColumn(name = "zooid")
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(String phonetype, Zoo zoo) {
        this.phonetype = phonetype;
        this.zoo = zoo;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "phoneid=" + phoneid +
                ", phonetype='" + phonetype + '\'' +
                ", zoo=" + zoo +
                '}';
    }
}
