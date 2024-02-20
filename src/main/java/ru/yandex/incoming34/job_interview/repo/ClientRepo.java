package ru.yandex.incoming34.job_interview.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.job_interview.structures.entity.client.Client;
@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
}
