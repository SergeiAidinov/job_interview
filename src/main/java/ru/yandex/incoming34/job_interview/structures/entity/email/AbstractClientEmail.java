package ru.yandex.incoming34.job_interview.structures.entity.email;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.incoming34.job_interview.structures.entity.AbstractContact;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class AbstractClientEmail extends AbstractContact {

    @Id
    private String email;
}
