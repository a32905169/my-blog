package com.example.blog.controller.ex;

/**
 * @author chang
 * @create 2024-05-2024/5/1 下午 04:30
 */
public class CreateDirectoryException extends ControllerException{
    public CreateDirectoryException() {
        super();
    }

    public CreateDirectoryException(String message) {
        super(message);
    }

    public CreateDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateDirectoryException(Throwable cause) {
        super(cause);
    }

    protected CreateDirectoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
