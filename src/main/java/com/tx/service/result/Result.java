package com.tx.service;

/**
 * Created by Administrator on 2018/5/5.
 */
public class Result<T> {
    static int SUCCESS = 0;
    static int FAILD = -1;

    private int code;
    private T date;

    public static Result success(Object date){
        return new Result(SUCCESS, date);
    }
    public static Result faild(Object date){
        return new Result(FAILD, date);
    }

    public Result(int code, T date) {
        this.code = code;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}

