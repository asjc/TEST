package com.example.vue.pojo;

public class ChatResp {
    private String msg;
    private String from;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public ChatResp(){

    }
    public ChatResp(String msg,String from){
        this.msg=msg;
        this.from=from;
    }
}
