package com.lambdaschool.zoos.models;

import javax.persistence.*;

/**
 * The entity allowing interaction with the telephones table
 */
@Entity
@Table(name = "telephone")
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
     * Phone number (String)
     */
    private String phonenumber;

    /**
     * Creates a join table joining Telephones and Zoos
     * in a Many-To-One relation.
     */
    @ManyToOne
    @JoinColumn(name = "zooid")
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(String phonetype, String phonenumber, Zoo zoo) {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    @Override
    public String toString() {
        return "Telephone{" +
                "phoneid=" + phoneid +
                ", phonetype='" + phonetype + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", zoo=" + zoo +
                '}';
    }
}
