package ru.yandex.incoming34.job_interview.structures.entity.email;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emails")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class ClientEmailFull extends AbstractClientEmail{

    @Column(name = "client_id")
    private Long clientId;

    public ClientEmailFull(Long clientId, String value) {
        super(value);
        this.clientId = clientId;
    }
}
