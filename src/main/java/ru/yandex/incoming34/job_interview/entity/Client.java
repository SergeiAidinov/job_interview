package ru.yandex.incoming34.job_interview.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_name")
    private String name;
}
