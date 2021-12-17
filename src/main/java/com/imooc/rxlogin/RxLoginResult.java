package com.imooc.rxlogin;

import java.util.Map;

/**
 * 登录信息
 */
public class RxLoginResult {
    private boolean isSucceed;
    private String msg;
    private Map<String,String> userInfoMaps;
    private RxLoginPlatform platform;

    public boolean isSucceed() {
        return isSucceed;
    }

    public void setSucceed(boolean succeed) {
        isSucceed = succeed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, String> getUserInfoMaps() {
        return userInfoMaps;
    }

    public void setUserInfoMaps(Map<String, String> userInfoMaps) {
        this.userInfoMaps = userInfoMaps;
    }

    public RxLoginPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(RxLoginPlatform platform) {
        this.platform = platform;
    }
}
