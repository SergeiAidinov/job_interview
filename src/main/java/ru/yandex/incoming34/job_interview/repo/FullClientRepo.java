package ru.yandex.incoming34.job_interview.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.job_interview.entity.FullClient;

@Repository
public interface FullClientRepo extends CrudRepository<FullClient, Long> {
}
