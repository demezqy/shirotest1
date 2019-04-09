package com.timisakura.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 保证序列化json的时候，如果是null的对象，key也会消失
public class ServerResponse1<T> implements Serializable {
    private int status;
    private T data;
    private String msg;

    @Override
    public String toString() {
        return "ServerResponse1{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static <T> ServerResponse1<T> creatBySussecc(){
        return new ServerResponse1<T>(ResponseCode1.SUCCESS.getCode());
    }
    public static <T> ServerResponse1<T> createBySuccessMessage(String msg, T data) {
        return new ServerResponse1<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }
    public static <T> ServerResponse1<T> createByErrorMessage(String msg){

        return new ServerResponse1<T>(ResponseCode1.ERROR.getCode(),msg);
    }
    public static <T> ServerResponse1<T> createBySuccessMessage(String msg) {
        return new ServerResponse1<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ServerResponse1(int status) {
        this.status = status;
    }

    public ServerResponse1(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse1(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public ServerResponse1(int code, String msg, T data) {
    }
    // 使之不在json序列化结果当中
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode1.SUCCESS.getCode();
    }
}
