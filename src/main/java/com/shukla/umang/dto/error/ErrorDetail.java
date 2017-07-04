package com.shukla.umang.dto.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ErrorDetail class's object will be serialized when exceptions are thrown across the project
 */
public class ErrorDetail {

    /** The title field provides a brief title for the error condition. */
    private String title;
    /** The status field contains the HTTP status code for the current request. */
    private int status;
    /** The detail field contains a short description(human-readable) of the error. */
    private String detail;
    /** The title field provides a brief title for the error condition */
    private long timeStamp;
    /** The developerMessage contains information such as exception
     * class name or stack trace that is relevant to developers.
     */
    private String developerMessage;
    /** The errors field is used to report field validation errors. */
    private Map<String, List<Error>> errors = new HashMap<String, List<Error>>();

    public Map<String, List<Error>> getErrors() {
        return errors;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setErrors(Map<String, List<Error>> errors) {
        this.errors = errors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
