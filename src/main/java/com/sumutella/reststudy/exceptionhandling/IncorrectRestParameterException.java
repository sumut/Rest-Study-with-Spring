package com.sumutella.reststudy.exceptionhandling;

/**
 * @author sumutella
 * @time 3:49 PM
 * @since 11/24/2019, Sun
 */
public class IncorrectRestParameterException extends RuntimeException {
    public IncorrectRestParameterException(String message) {
        super(message);
    }

    public IncorrectRestParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRestParameterException(Throwable cause) {
        super(cause);
    }
}
