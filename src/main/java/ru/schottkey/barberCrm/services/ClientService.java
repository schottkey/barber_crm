package ru.schottkey.barberCrm.services;


import ru.schottkey.barberCrm.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(Integer id);

    Client save(Client client);

    void deleteById(Integer id);

}
