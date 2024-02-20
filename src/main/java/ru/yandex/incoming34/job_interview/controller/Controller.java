package ru.yandex.incoming34.job_interview.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.job_interview.entity.Client;
import ru.yandex.incoming34.job_interview.repo.ClientRepo;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class Controller {

    private final ClientRepo clientRepo;

    @PostMapping(value = "/new_client")
    public void addClient(String clientName){
        clientRepo.save(new Client(clientName));
    }
}
