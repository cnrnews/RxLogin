package com.imooc.rxlogin.um;

import android.app.Activity;
import android.content.Intent;

import com.imooc.rxlogin.RxLoginActivity;

public class UMShareAPI {

    public UMShareAPI(Activity activity) {
    }

    public static UMShareAPI get(Activity activity) {
        return new UMShareAPI(activity);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA qq, UMAuthListener listener) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
