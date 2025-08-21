package com.work.logs.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LtlJsonToEntityException.class)
    public ResponseEntity<JSONObject> ltlJsonToEntityException(LtlJsonToEntityException e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", e.getCode());
        jsonObject.put("message", e.getMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject);
    }
}
