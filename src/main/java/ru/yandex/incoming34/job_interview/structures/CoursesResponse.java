package ru.yandex.incoming34.job_interview.structures;

import lombok.Getter;
import ru.yandex.incoming34.job_interview.controller.Controller;

@Getter
public class CoursesResponse {

    private final int errorCode;
    private final String detailedMessage;

    public CoursesResponse(String detailedMessage) {
        this.detailedMessage = detailedMessage;
        errorCode = detailedMessage.equals(Controller.SUCCESS_MESSAGE) ? 0 : 1;
    }
}