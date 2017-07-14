package com.company.base;

/**
 * Created by Administrator on 2017/6/28 0028.
 * 基础Json返回码
 */
public class JsonResponse {

    private Integer code; // 状态码
    private String msg; // 消息
    private Object data; // 返回数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

