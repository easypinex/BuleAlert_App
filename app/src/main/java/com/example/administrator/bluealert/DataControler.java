package com.example.administrator.bluealert;

/**
 * Created by Administrator on 2017/10/26.
 */

public class DataControler {
    private String server = "220.134.230.193";
    private String uid = "";
    private String token = "";
    private String password = "";
    public String getServer(){
        return server;
    }

    public void setUid(String uid){
        this.uid= uid;
    }
    public String getUid(){
        return uid;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

}
