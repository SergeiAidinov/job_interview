package ru.yandex.incoming34.job_interview.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.incoming34.job_interview.repo.*;
import ru.yandex.incoming34.job_interview.structures.AbstractContact;
import ru.yandex.incoming34.job_interview.structures.ContactType;
import ru.yandex.incoming34.job_interview.structures.CoursesResponse;
import ru.yandex.incoming34.job_interview.structures.NewContactType;
import ru.yandex.incoming34.job_interview.structures.entity.client.AbstractClient;
import ru.yandex.incoming34.job_interview.structures.entity.client.Client;
import ru.yandex.incoming34.job_interview.structures.entity.email.ClientEmailFull;
import ru.yandex.incoming34.job_interview.structures.entity.phone.ClientPhoneFull;

import java.util.Objects;
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
    public static final String SUCCESS_MESSAGE = "SUCCESS";

    @PostMapping(value = "/new_client")
    @Operation(description = "Добавление нового клиента.")
    public Client addClient(String clientName){
       return clientRepo.save(new Client(clientName));
    }

    @PostMapping(value = "/new_contact")
    @Operation(description = "Добавление нового контакта.")
    public Optional<? extends AbstractContact> addContact(Long clientId, String value, NewContactType contactType){
        return switch (contactType) {
            case EMAIL -> Optional.of(clientEmailRepo.save(new ClientEmailFull(clientId, value)));
            case PHONE -> Optional.of(clientPhoneRepo.save(new ClientPhoneFull(clientId, value)));
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {RuntimeException.class})
    private CoursesResponse handleException(RuntimeException exception) {
        return new CoursesResponse(Objects.nonNull(exception.getMessage()) ? exception.getMessage() : "Unknown Error");
    }
}
