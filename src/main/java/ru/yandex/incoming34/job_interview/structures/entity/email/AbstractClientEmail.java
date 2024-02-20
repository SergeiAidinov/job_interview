package ru.yandex.incoming34.job_interview.structures.entity.email;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.incoming34.job_interview.structures.AbstractContact;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class AbstractClientEmail extends AbstractContact {

    @Id
    private String email;

    public AbstractClientEmail(String email) {
        this.email = email;
    }
}
