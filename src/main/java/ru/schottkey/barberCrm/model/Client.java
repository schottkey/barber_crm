package ru.schottkey.barberCrm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Contact> contacts;
}


