package ru.yandex.incoming34.job_interview.structures.entity.phone;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phone_numbers")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class ClientPhoneBrief extends AbstractClientPhone{


}
