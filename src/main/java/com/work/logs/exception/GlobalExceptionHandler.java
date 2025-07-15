package com.work.logs.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("内部服务器错误: " + e.getMessage());
    }

    @ExceptionHandler(LtlJsonToEntityException.class)
    public ResponseEntity<JSONObject> ltlJsonToEntityException(LtlJsonToEntityException e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", e.getCode());
        jsonObject.put("message", e.getMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject);
    }
}
