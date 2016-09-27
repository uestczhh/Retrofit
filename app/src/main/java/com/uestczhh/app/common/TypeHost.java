package com.uestczhh.app.common;

import java.net.FileNameMap;
import java.security.PublicKey;

/**
 * baseUrl的类型，由于接口不共用一个baseUrl，所以需要区分
 * Created by zhanghao on 2016/9/27.
 */
public class TypeHost {
    public static final int TYPE_COUNT = 2;

    /**
     * 网易新闻
     */
    public static final int TYPE_NEWS = 1;
    /**
     * 代码家图片
     */
    public static final int TYPE_PHOTO = 2;
}
