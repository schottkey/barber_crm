package ru.schottkey.barberCrm;

/**
 * Hello world!
 *
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.schottkey.barberCrm.model.*;
import ru.schottkey.barberCrm.services.ClientService;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootApplication
public class App {

    private static ClientService clientService;
    private static App app;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        clientService = (ClientService) context.getBean("clientServiceImpl");
        app = (App) context.getBean("app");

//        Client client = clientService.findById(1);
//        System.out.println(client);
//        ((PhoneContact) client.getContacts().get(1)).setPhoneNumber("+79000000000");
//        clientService.save(client);
//        System.out.println(clientService.findById(1));
//        app.addContacts(client);
//        app.getClient(1);
//        app.deleteContact(client);
//        app.getClient(1);
    }

    /*@Transactional
    public void addContacts(Client client) {
        client.setContacts(new ArrayList<Contact>() {{

            PhoneContact phone1 = new PhoneContact();
            phone1.setComment("my phone1");
            phone1.setPhoneNumber("+71234567890");
            phone1.setCanCall(true);
            add(phone1);

            PhoneContact phone = new PhoneContact();
            phone.setComment("my phone");
            phone.setPhoneNumber("+79999567899");
            add(phone);

            InstagramContact instagram = new InstagramContact();
            instagram.setComment("my insta");
            instagram.setNick("@krasav4ik");
            add(instagram);

            VkContact vk = new VkContact();
            vk.setAddress("vk.com/krasav4ik");
            add(vk);
        }});
        clientService.save(client);

    }*/
}
