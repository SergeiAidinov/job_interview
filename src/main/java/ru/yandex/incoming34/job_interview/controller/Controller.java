package ru.yandex.incoming34.job_interview.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.job_interview.repo.*;
import ru.yandex.incoming34.job_interview.structures.ContactType;
import ru.yandex.incoming34.job_interview.structures.NewContactType;
import ru.yandex.incoming34.job_interview.structures.entity.AbstractClient;
import ru.yandex.incoming34.job_interview.structures.entity.Client;
import ru.yandex.incoming34.job_interview.structures.entity.ClientEmailFull;
import ru.yandex.incoming34.job_interview.structures.entity.ClientPhoneFull;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class Controller {

    private final ClientRepo clientRepo;
    private final FullClientRepo fullClientRepo;
    private final ClientWithPhoneNumbersRepo clientWithPhoneNumbersRepo;
    private final ClientWithEmailsRepo clientWithEmailsRepo;
    private final ClientEmailRepo clientEmailRepo;
    private final ClientPhoneRepo clientPhoneRepo;

    @PostMapping(value = "/new_client")
    @Operation(description = "Добавление нового клиента.")
    public void addClient(String clientName){
        clientRepo.save(new Client(clientName));
    }

    @PostMapping(value = "/new_contact")
    @Operation(description = "Добавление нового контакта.")
    public void addContact(Long clientId, String value, NewContactType contactType){
        switch (contactType) {
            case EMAIL -> clientEmailRepo.save(new ClientEmailFull(clientId, value));
            case PHONE -> clientPhoneRepo.save(new ClientPhoneFull(clientId, value));
        };
    }

    @GetMapping(value = "/all_clients")
    @Operation(description = "Получение списка клиентов.")
    public Iterable<Client> allClients() {
        return clientRepo.findAll();
    }

    @GetMapping(value = "/detailed_clients")
    @Operation(description = "Получение списка контактов заданного типа заданного клиента.")
    public Optional<? extends AbstractClient> detailedClient(Long id, ContactType contactType) {
        return switch (contactType) {
            case PHONE -> clientWithPhoneNumbersRepo.findById(id);
            case EMAIL -> clientWithEmailsRepo.findById(id);
            case PHONE_AND_EMAIL -> fullClientRepo.findById(id);
        };
    }
}
