package com.pxutils.pxutils;

/*
 * Created by qianli.ma on 2019/1/11 0011.
 */
public class LoginParam {
    /**
     * username : user001
     * password : 12345678
     * devicename : Android 6.0
     * devicetime : 1491234567
     * devicetimes : 2017.01.01 12:30
     */

    private String username;
    private String password;
    private String devicename;
    private int devicetime;
    private String devicetimes;

    public LoginParam() {
    }

    public LoginParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public int getDevicetime() {
        return devicetime;
    }

    public void setDevicetime(int devicetime) {
        this.devicetime = devicetime;
    }

    public String getDevicetimes() {
        return devicetimes;
    }

    public void setDevicetimes(String devicetimes) {
        this.devicetimes = devicetimes;
    }
}
