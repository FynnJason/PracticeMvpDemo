package app.fynnjason.practicemvpdemo.mvp.model;


import android.os.Handler;

import app.fynnjason.practicemvpdemo.callback.ResultCallback;

/**
 * Created by FynnJason on 2017/12/21.
 * 登录Model层
 */

public class LoginModel {

    /**
     * 模拟网络请求登录接口
     * @param act 账号
     * @param psw 密码
     * @param callback 网络请求回调
     */
    public void requestLogin(final String act, final String psw, final ResultCallback<String> callback) {
        //用handler模拟网络请求登录
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (act.equals("123456") && psw.equals("123456")) {
                    callback.onSuccess("登录成功");
                }else
                    callback.onFail("账号或密码错误");
            }
        }, 1000);
    }

}
