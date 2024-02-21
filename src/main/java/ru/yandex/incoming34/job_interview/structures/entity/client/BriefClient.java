package ru.yandex.incoming34.job_interview.structures.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Getter
@NoArgsConstructor
public class BriefClient extends AbstractClient {

    public BriefClient(String clientName) {
        super(clientName);
    }
}
