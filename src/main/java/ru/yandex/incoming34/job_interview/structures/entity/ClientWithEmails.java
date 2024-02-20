package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name ="clients")
@Getter
public class ClientWithEmails extends AbstractClient {

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientEmailBrief> clientEmailList;

    public ClientWithEmails() {
        super();
    }
}
