package ru.yandex.incoming34.job_interview.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.incoming34.job_interview.repo.*;
import ru.yandex.incoming34.job_interview.structures.ErrorResponse;
import ru.yandex.incoming34.job_interview.structures.ContactType;
import ru.yandex.incoming34.job_interview.structures.NewContactType;
import ru.yandex.incoming34.job_interview.structures.entity.AbstractContact;
import ru.yandex.incoming34.job_interview.structures.entity.client.AbstractClient;
import ru.yandex.incoming34.job_interview.structures.entity.client.BriefClient;
import ru.yandex.incoming34.job_interview.structures.entity.email.ClientEmailFull;
import ru.yandex.incoming34.job_interview.structures.entity.phone.ClientPhoneFull;

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
    public BriefClient addClient(String clientName){
       return clientRepo.save(new BriefClient(clientName));
    }

    @PostMapping(value = "/new_contact")
    @Operation(description = "Добавление нового контакта.")
    public AbstractContact addContact(Long clientId, String value, NewContactType newContactType){
        return switch (newContactType) {
            case EMAIL -> clientEmailRepo.save(new ClientEmailFull(clientId, value));
            case PHONE -> clientPhoneRepo.save(new ClientPhoneFull(clientId, value));
        };
    }

    @GetMapping(value = "/all_clients")
    @Operation(description = "Получение списка клиентов.")
    public Iterable<BriefClient> allClients() {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {RuntimeException.class})
    private ErrorResponse handleException(RuntimeException exception) {
        return ErrorResponse.of(exception);
    }
}
