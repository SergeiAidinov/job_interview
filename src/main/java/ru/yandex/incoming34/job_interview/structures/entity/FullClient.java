package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
public class FullClient extends AbstractClient {

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientPhone> clientPhoneList;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientEmailBrief> clientEmailList;
}
