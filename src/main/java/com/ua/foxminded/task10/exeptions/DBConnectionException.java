package com.ua.foxminded.task10.exeptions;

public class DBConnectionException extends RuntimeException {
    public DBConnectionException() {
    }

    public DBConnectionException(String message) {
        super(message);
    }

    public DBConnectionException(String message, Exception cause) {
        super(message, cause);
    }

}

