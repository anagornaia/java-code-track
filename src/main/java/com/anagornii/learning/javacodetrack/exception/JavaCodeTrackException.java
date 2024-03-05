package com.anagornii.learning.javacodetrack.exception;

import lombok.Getter;
import org.slf4j.helpers.MessageFormatter;

@Getter
public class JavaCodeTrackException extends RuntimeException {

    private final ExceptionType errorType;

    private JavaCodeTrackException(ExceptionType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    private JavaCodeTrackException(Throwable cause, ExceptionType type, Object... messageArgs) {
        super(MessageFormatter.arrayFormat(type.getMessage(), messageArgs).getMessage(), cause);
        this.errorType = type;
    }

    private JavaCodeTrackException(ExceptionType type, Object... messageArgs) {
        super(MessageFormatter.arrayFormat(type.getMessage(), messageArgs).getMessage());
        this.errorType = type;
    }

    private JavaCodeTrackException(ExceptionType type, Exception ex) {
        super(type.getMessage(), ex);
        this.errorType = type;
    }

    public static JavaCodeTrackException of(ExceptionType exceptionType) {
        return new JavaCodeTrackException(exceptionType);
    }

    public static JavaCodeTrackException of(ExceptionType exceptionType, Object... messageArgs) {
        return new JavaCodeTrackException(exceptionType, messageArgs);
    }

    public static JavaCodeTrackException of(ExceptionType exceptionType, Exception cause) {
        return new JavaCodeTrackException(exceptionType, cause);
    }

    public static JavaCodeTrackException of(ExceptionType exceptionType, Throwable cause, Object... messageArgs) {
        return new JavaCodeTrackException(cause, exceptionType, messageArgs);
    }

    public static JavaCodeTrackException of(ExceptionType exceptionType, Exception cause, Object... messageArgs) {
        return new JavaCodeTrackException(cause, exceptionType, messageArgs);
    }
}
