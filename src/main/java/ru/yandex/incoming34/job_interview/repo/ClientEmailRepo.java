package ru.yandex.incoming34.job_interview.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.job_interview.structures.entity.email.ClientEmailFull;

@Repository
public interface ClientEmailRepo extends CrudRepository<ClientEmailFull, String> {
}
