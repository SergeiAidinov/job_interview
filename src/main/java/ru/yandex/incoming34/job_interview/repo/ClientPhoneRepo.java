package ru.yandex.incoming34.job_interview.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.job_interview.structures.entity.phone.ClientPhoneFull;

@Repository
public interface ClientPhoneRepo extends CrudRepository<ClientPhoneFull, Long> {
}
