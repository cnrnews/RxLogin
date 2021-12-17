package com.imooc.rxlogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.imooc.rxlogin.um.SHARE_MEDIA;
import com.imooc.rxlogin.um.UMAuthListener;
import com.imooc.rxlogin.um.UMShareAPI;

import java.util.Map;

import static com.imooc.rxlogin.RxLoginPlatform.Platform_QQ;

public class RxLoginActivity extends AppCompatActivity implements UMAuthListener {

    public static final String PLATFORM_KEY="PLATFORM_KEY";
    private UMShareAPI mUmShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUmShareAPI = UMShareAPI.get(this);
        RxLoginPlatform platform = (RxLoginPlatform) getIntent().getSerializableExtra(PLATFORM_KEY);
        mUmShareAPI.getPlatformInfo(this, platformChange(platform),this);
    }

    private SHARE_MEDIA platformChange(RxLoginPlatform platform) {
        switch (platform){
            case Platform_QQ:
                return SHARE_MEDIA.QQ;
            case Platform_WX:
                return SHARE_MEDIA.WX;
        }
        return SHARE_MEDIA.QQ;
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        RxLogin.UM_AUTH_LISTENER.onStart(share_media);
    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        // 回传数据
        RxLogin.UM_AUTH_LISTENER.onComplete(share_media,i,map);
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        RxLogin.UM_AUTH_LISTENER.onError(share_media,i,throwable);
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        RxLogin.UM_AUTH_LISTENER.onCancel(share_media,i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}