package com.example.student.error_handling;

public class ErrorMessage {


    private boolean success;

    private String message;

    public String getMessage() {
        return message;
    }



    ErrorMessage(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
