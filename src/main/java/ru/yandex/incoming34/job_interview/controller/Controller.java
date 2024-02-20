package ru.yandex.incoming34.job_interview.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.job_interview.entity.Client;
import ru.yandex.incoming34.job_interview.entity.FullClient;
import ru.yandex.incoming34.job_interview.repo.ClientRepo;
import ru.yandex.incoming34.job_interview.repo.FullClientRepo;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class Controller {

    private final ClientRepo clientRepo;
    private final FullClientRepo fullClientRepo;

    @PostMapping(value = "/new_client")
    public void addClient(String clientName){
        clientRepo.save(new Client(clientName));
    }

    @GetMapping(value = "/all_clients")
    public Iterable<Client> allClients() {
        return clientRepo.findAll();
    }

    @GetMapping(value = "/full_clients")
    public Iterable<FullClient> fullClients() {
        return fullClientRepo.findAll();
    }
}
