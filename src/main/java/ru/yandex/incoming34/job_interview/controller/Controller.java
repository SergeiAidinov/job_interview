package ru.yandex.incoming34.job_interview.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.job_interview.entity.Client;
import ru.yandex.incoming34.job_interview.repo.ClientRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class Controller {

    private final ClientRepo clientRepo;

    @PostMapping(value = "/new_client")
    public void addClient(String clientName){
        clientRepo.save(new Client(clientName));
    }

    @GetMapping(value = "/all_clients")
    public Iterable<Client> allClients() {
        return clientRepo.findAll();
    }
}
