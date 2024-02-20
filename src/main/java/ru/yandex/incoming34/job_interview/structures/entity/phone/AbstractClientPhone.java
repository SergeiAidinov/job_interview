package ru.yandex.incoming34.job_interview.structures.entity.phone;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.incoming34.job_interview.structures.AbstractContact;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class AbstractClientPhone extends AbstractContact {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    public AbstractClientPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
