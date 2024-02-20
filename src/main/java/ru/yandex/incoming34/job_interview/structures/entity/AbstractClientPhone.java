package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@Getter
public class AbstractClientPhone {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    public AbstractClientPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
