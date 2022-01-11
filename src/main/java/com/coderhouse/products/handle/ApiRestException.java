package com.coderhouse.products.handle;

public class ApiRestException extends Exception{

    private String msg;

    public ApiRestException(String msg){
        super(msg);
    }
}
