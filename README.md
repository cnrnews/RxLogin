# RxLogin

#### 介绍
使用RxJava封装好的友盟第三方登录框架

#### 软件架构
RxJava + 友盟分享SDK

 

#### 使用说明

```
RxLogin.create(this)
       .doOauthVerify(RxLoginPlatform.Platform_QQ) // 默认分享平台QQ
       .observeOn(AndroidSchedulers.mainThread()) 
       .subscribe(new Consumer<RxLoginResult>() {
            @Override
            public void accept(@NonNull RxLoginResult rxLoginResult) throws Exception {
                 if (rxLoginResult.isSucceed()){
                       Toast.makeText(Test.this,rxLoginResult.getMsg(),Toast.LENGTH_SHORT).show();
                     }
                 }
           });
```

 
 