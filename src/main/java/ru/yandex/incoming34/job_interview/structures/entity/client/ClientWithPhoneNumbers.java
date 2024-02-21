package ru.yandex.incoming34.job_interview.structures.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.incoming34.job_interview.structures.entity.phone.ClientPhoneBrief;

import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
public class ClientWithPhoneNumbers extends AbstractClient {

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientPhoneBrief> clientPhoneBriefList;
}
