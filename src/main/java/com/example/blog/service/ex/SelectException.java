package com.example.blog.service.ex;

/**
 * @author chang
 * @create 2024-04-2024/4/30 上午 09:49
 */
public class SelectException extends ServiceException{
    public SelectException() {
        super();
    }

    public SelectException(String message) {
        super(message);
    }

    public SelectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectException(Throwable cause) {
        super(cause);
    }

    protected SelectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
