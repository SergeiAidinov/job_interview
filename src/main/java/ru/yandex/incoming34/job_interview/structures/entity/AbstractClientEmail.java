package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class AbstractClientEmail {

    @Id
    private String email;

    public AbstractClientEmail(String email) {
        this.email = email;
    }
}
