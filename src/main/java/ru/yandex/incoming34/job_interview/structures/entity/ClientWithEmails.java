package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="clients")
@Getter
public class ClientWithEmails extends AbstractClient {

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientEmail> clientEmailList;

    public ClientWithEmails() {
        super();
    }
}
