package ru.yandex.incoming34.job_interview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="phone_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClientPhone {

    @Column(name = "client_id")
    private Long clientId;
    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

}
