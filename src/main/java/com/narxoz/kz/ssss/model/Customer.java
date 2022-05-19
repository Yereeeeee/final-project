package com.narxoz.kz.ssss.model;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    private String age;
    @ManyToOne
    private Car owner;
}