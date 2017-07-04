package com.shukla.umang.dto.error;

public class ValidationError implements Error {

    /** The code is the short code to signify an error */
    private String code;
    /** More deeper description about the error */
    private String message;

    /**
     * Getters for ValidationError class.
     */
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Setters for ValidationError class.
     */
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
