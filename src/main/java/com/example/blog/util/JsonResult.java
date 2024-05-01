package com.example.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {
    private Integer status;
    private String message;
    private T result;

}
