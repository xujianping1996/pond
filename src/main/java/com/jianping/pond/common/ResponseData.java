package com.jianping.pond.common;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {
    private String message;
    private int code;
    private T data;

    public ResponseData() {
    }

    public ResponseData(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseData createErrorMessage(String message ){
        return new ResponseData(message,0,null);
    }
    public static ResponseData createSuccessMessage(String message ,Object object){
        return new ResponseData<>(message,0,object);
    }
}
