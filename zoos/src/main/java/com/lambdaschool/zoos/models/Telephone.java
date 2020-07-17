package com.lambdaschool.zoos.models;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    private String phonetype;

    @Column(nullable = false)
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid")
    private Zoo zoo;
}
