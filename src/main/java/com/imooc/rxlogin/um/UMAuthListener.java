package com.imooc.rxlogin.um;

import java.util.Map;

public interface UMAuthListener {
    void onStart(SHARE_MEDIA share_media);
    void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map);
    void onError(SHARE_MEDIA share_media, int i, Throwable throwable);
    void onCancel(SHARE_MEDIA share_media, int i);
}
