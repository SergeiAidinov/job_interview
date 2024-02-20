package ru.yandex.incoming34.job_interview.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.job_interview.repo.ClientRepo;
import ru.yandex.incoming34.job_interview.repo.ClientWithEmailsRepo;
import ru.yandex.incoming34.job_interview.repo.ClientWithPhoneNumbersRepo;
import ru.yandex.incoming34.job_interview.repo.FullClientRepo;
import ru.yandex.incoming34.job_interview.structures.ContactType;
import ru.yandex.incoming34.job_interview.structures.entity.AbstractClient;
import ru.yandex.incoming34.job_interview.structures.entity.Client;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class Controller {

    private final ClientRepo clientRepo;
    private final FullClientRepo fullClientRepo;
    private final ClientWithPhoneNumbersRepo clientWithPhoneNumbersRepo;
    private final ClientWithEmailsRepo clientWithEmailsRepo;

    @PostMapping(value = "/new_client")
    public void addClient(String clientName){
        clientRepo.save(new Client(clientName));
    }

    @GetMapping(value = "/all_clients")
    public Iterable<Client> allClients() {
        return clientRepo.findAll();
    }

    @GetMapping(value = "/detailed_clients")
    public Optional<? extends AbstractClient> detailedClient(Long id, ContactType contactType) {
        return switch (contactType) {
            case PHONE -> clientWithPhoneNumbersRepo.findById(id);
            case EMAIL -> clientWithEmailsRepo.findById(id);
            case PHONE_AND_EMAIL -> fullClientRepo.findById(id);
        };
    }
}
