package app.fynnjason.practicemvpdemo.mvp.contract;

import app.fynnjason.practicemvpdemo.base.IBaseView;

/**
 * Created by FynnJason on 2017/12/21.
 * 协议类(遵循Google官方的方式)
 */

public interface LoginContract {

    //登录View接口
    interface ILoginView extends IBaseView{
        void loginSuccess();

        void loginFail();

        void showToast(String msg);
    }

    //登录Presenter接口，可以去实现一个基类扩展
    interface ILoginPresenter {
        void requestLogin(String act,String psw);
    }
}
