package com.sumutella.reststudy.entities;

/**
 * @author sumutella
 * @time 6:49 PM
 * @since 11/22/2019, Fri
 */
public class ErrorResponseEntity {
    private int status;
    private String message;

    public ErrorResponseEntity() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
