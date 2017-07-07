package com.shukla.umang.dto.error;

public interface Error {

    String getCode();
    String getMessage();
    void setCode(String code);
    void setMessage(String message);
}
