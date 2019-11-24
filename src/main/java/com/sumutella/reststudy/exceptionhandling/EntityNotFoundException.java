package com.sumutella.reststudy.exceptionhandling;

/**
 * @author sumutella
 * @time 3:34 PM
 * @since 11/24/2019, Sun
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
