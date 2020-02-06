package com.d3sd1.appmaster.model;

public class CommandOutput {
    private String message;
    private boolean error;

    public CommandOutput() {
    }

    public CommandOutput(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CommandOutput{" +
                "message='" + message + '\'' +
                ", error=" + error +
                '}';
    }
}
