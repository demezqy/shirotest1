package com.timisakura.exception;

/**
 * @ClassNAME CustomException
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/10 14:52
 * @Version
 */
public class CustomException extends Exception {
    //异常信息
    private String message;

    public CustomException(String message){
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
