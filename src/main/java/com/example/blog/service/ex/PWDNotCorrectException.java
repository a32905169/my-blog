package com.example.blog.service.ex;

/**
 * @author chang
 * @create 2024-04-2024/4/27 上午 04:37
 */
public class PWDNotCorrectException extends ServiceException{

    public PWDNotCorrectException() {
        super();
    }

    public PWDNotCorrectException(String message) {
        super(message);
    }

    public PWDNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public PWDNotCorrectException(Throwable cause) {
        super(cause);
    }

    protected PWDNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
