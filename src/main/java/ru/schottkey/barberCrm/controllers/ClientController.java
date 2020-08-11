package ru.schottkey.barberCrm.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.schottkey.barberCrm.model.Client;
import ru.schottkey.barberCrm.model.InstagramContact;
import ru.schottkey.barberCrm.model.PhoneContact;
import ru.schottkey.barberCrm.model.VkContact;
import ru.schottkey.barberCrm.services.ClientService;

import java.util.Collections;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "/clients/list-clients";
    }

    @GetMapping("/showClientForm")
    public String showFormForUpdate(@RequestParam(value = "id", defaultValue = "-1") int id,
                                    Model model) {
        Client client = id == -1 ?
                new Client() : clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("phones",
                client.getContacts().stream()
                        .filter(c -> c instanceof PhoneContact)
                        .map(c -> (PhoneContact) c)
                        .collect(Collectors.toList()));
        model.addAttribute("instagrams",
                client.getContacts().stream()
                        .filter(c -> c instanceof InstagramContact)
                        .collect(Collectors.toList()));
        model.addAttribute("vks",
                client.getContacts().stream()
                        .filter(c -> c instanceof VkContact)
                        .collect(Collectors.toList()));
        return "/clients/client-form";
    }

    @PostMapping("/save")
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam int id) {
        Client client = clientService.findById(id);
        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
