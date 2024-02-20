package ru.yandex.incoming34.job_interview.structures.entity.email;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.incoming34.job_interview.structures.entity.AbstractContact;

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
