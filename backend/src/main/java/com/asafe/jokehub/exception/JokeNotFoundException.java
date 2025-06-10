package com.asafe.jokehub.exception;

public class JokeNotFoundException extends RuntimeException{
    public JokeNotFoundException(String msg){
        super(msg);
    }
}
