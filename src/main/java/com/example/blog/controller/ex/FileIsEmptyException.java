package com.example.blog.controller.ex;

/**
 * @author chang
 * @create 2024-05-2024/5/1 上午 04:57
 */
public class FileIsEmptyException extends ControllerException{
    public FileIsEmptyException() {
        super();
    }

    public FileIsEmptyException(String message) {
        super(message);
    }

    public FileIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIsEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
