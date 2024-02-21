package ru.yandex.incoming34.job_interview.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.incoming34.job_interview.JobInterviewApplication;
import ru.yandex.incoming34.job_interview.structures.NewContactType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JobInterviewApplication.class)
@SpringBootTest(classes = {Controller.class})
class ControllerTest {

    private final Controller controller;

    ControllerTest(@Qualifier("controller") Controller controller) {
        this.controller = controller;
    }

    @Test
    void addContact() {
        Assert.assertThrows(RuntimeException.class, () -> controller.addContact(1L, "incoming34yandexru", NewContactType.EMAIL));
    }
}