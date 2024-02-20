package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phone_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClientPhoneFull extends AbstractClientPhone {

    @Column(name = "client_id")
    private Long clientId;

    public ClientPhoneFull(Long clientId, String phoneNumber) {
        super(phoneNumber);
        this.clientId = clientId;
    }
}
