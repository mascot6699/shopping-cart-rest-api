package com.shukla.umang.dto.error;

interface Error {

    String getCode();
    String getMessage();
    void setCode(String code);
    void setMessage(String message);
}
