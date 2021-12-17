package com.imooc.rxlogin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class Test extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RxLogin.create(this)
                .doOauthVerify(RxLoginPlatform.Platform_QQ)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RxLoginResult>() {
                    @Override
                    public void accept(@NonNull RxLoginResult rxLoginResult) throws Exception {
                        if (rxLoginResult.isSucceed()){
                            Toast.makeText(Test.this,rxLoginResult.getMsg(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
