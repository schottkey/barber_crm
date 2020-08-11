package ru.schottkey.barberCrm.services;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.schottkey.barberCrm.model.Client;
import ru.schottkey.barberCrm.model.Contact;
import ru.schottkey.barberCrm.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    @Transactional
    public Client findById(Integer id) {
        Client client = clientRepository.findById(id).get();
        Hibernate.initialize(client.getContacts());
        return client;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

}
