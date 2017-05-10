package com.hongbaogou.request;

import android.util.Log;

import com.hongbaogou.YYJXApplication;
import com.hongbaogou.utils.MD5;
import com.hongbaogou.utils.Pref_Utils;

/**
 * Created by Administrator on 2015/12/5.
 */
public class BaseRequest2 {

    protected String urlBase = "http://192.168.1.93/phpbao/api/";
    private String partner = "ZL888ANDROID";
    private String key = "3860DD4B6E04448D3666B3F94CFA3DD7";
    private  String channel = "1004" ;
    public String getParams() {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        Log.e("timestamp", timestamp);
        String sign = MD5.getStringMD5(partner + timestamp + key);
        Log.d("sign", sign);
        return "partner=" + partner + "&timestamp=" + timestamp + "&sign=" + sign +"&channel=" +channel+"&authkey="+getAuthkey();
    }
    private String getAuthkey(){
        return Pref_Utils.getString(YYJXApplication.applicationContext, "USER_AUTHKEY","");
    }
}
