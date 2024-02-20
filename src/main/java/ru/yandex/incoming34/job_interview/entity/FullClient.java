package ru.yandex.incoming34.job_interview.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FullClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientPhone> clientPhoneList;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<ClientEmail> clientEmailList;
}
