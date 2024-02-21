package ru.yandex.incoming34.job_interview.structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final String message;

    public static ErrorResponse of(RuntimeException exception) {
         return new ErrorResponse(Objects.nonNull(exception.getMessage()) ? exception.getMessage() : "Unknown Error");
    }
}
