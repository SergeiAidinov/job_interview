package ru.yandex.incoming34.job_interview.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="emails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClientEmail {

    @Column(name = "client_id")
    private Long clientId;
    @Id
    private String email;
}
