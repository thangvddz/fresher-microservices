package com.fresher.msa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TypeRoom {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private boolean status;
    @Column(name = "price")
    private double price;
}
