package com.imooc.rxlogin;

import android.app.Activity;
import android.content.Intent;

import com.imooc.rxlogin.um.SHARE_MEDIA;
import com.imooc.rxlogin.um.UMAuthListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxLogin implements UMAuthListener {

    private RxLoginResult rxLoginResult;
    private Activity activity;
    static UMAuthListener UM_AUTH_LISTENER;
    private PublishSubject<RxLoginResult> mEmitter;

    private RxLogin(Activity activity) {
        this.activity = activity;
        UM_AUTH_LISTENER = this;
        rxLoginResult = new RxLoginResult();
        mEmitter = PublishSubject.create();
    }

    public static RxLogin create(Activity activity){
        return new RxLogin(activity);
    }

    public Observable<RxLoginResult> doOauthVerify(RxLoginPlatform platform){
        // 设置平台
        rxLoginResult.setPlatform(platform);
        // 开启一个透明的Activity
        Intent intent = new Intent(activity,RxLoginActivity.class);
        intent.putExtra(RxLoginActivity.PLATFORM_KEY,platform);
        activity.startActivity(intent);
        activity.overridePendingTransition(0,0);

        List<Observable<RxLoginResult>> list = new ArrayList<>();
        list.add(mEmitter);
        return Observable.concat(Observable.fromIterable(list));
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        rxLoginResult.setSucceed(true);
        rxLoginResult.setUserInfoMaps(map);
        rxLoginResult.setMsg("获取用户信息成功");
        mEmitter.onNext(rxLoginResult);
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        rxLoginResult.setSucceed(false);
        rxLoginResult.setMsg("第三方登陆失败");
        mEmitter.onNext(rxLoginResult);
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        rxLoginResult.setSucceed(false);
        rxLoginResult.setMsg("用户取消第三方登录");
        mEmitter.onNext(rxLoginResult);
    }
}
