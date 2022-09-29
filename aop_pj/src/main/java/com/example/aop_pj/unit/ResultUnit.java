package com.example.aop_pj.unit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResultUnit {

    private static final Integer SUCCESS = 200;
    private static final Integer ERROR = 400;
    private static final Integer UNAUTHORIZED = 401;
    private static final Integer INTERNAL_SERVER_ERROR = 500;
    private static final Integer BUSINESS_ERROR = 412;

    public ResultUnit() {
    }

    public static ResponseEntity success(Object object) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(object);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(SUCCESS);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg, Object object) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success() {
        Result result = new Result(new HashMap());
        result.setCode(SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity error(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity error(String msg, Object errdata) {
        Result result = new Result();
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        result.setData(errdata);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity unauthorizedError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(UNAUTHORIZED);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity internalServerError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity customError(String msg, int code) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity businessError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(BUSINESS_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity paramError(String msg, Object errdata) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        result.setData(errdata);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
