package com.timisakura.common;

public enum ResponseCode1 {
    SUCCESS(1, "操作成功"), // 对像
    ERROR(0, "fail");   // 对像



    private final int code;
    private final String desc;

    ResponseCode1(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
