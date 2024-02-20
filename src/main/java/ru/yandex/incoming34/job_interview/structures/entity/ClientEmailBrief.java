package ru.yandex.incoming34.job_interview.structures.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emails")
@NoArgsConstructor
@Getter
public class ClientEmailBrief extends AbstractClientEmail{
}
