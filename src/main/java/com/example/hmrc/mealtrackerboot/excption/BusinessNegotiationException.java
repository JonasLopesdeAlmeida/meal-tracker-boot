package com.example.hmrc.mealtrackerboot.excption;

public class BusinessNegotiationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessNegotiationException(String msg){
        super(msg);

    }

}