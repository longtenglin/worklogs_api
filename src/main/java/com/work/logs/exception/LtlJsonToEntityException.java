package com.work.logs.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LtlJsonToEntityException extends Exception {

    private String code;
    private String msg;

    public LtlJsonToEntityException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }
}
