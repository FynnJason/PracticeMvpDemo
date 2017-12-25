package app.fynnjason.practicemvpdemo.mvp.presenter;

import app.fynnjason.practicemvpdemo.base.BasePresenter;
import app.fynnjason.practicemvpdemo.callback.ResultCallback;
import app.fynnjason.practicemvpdemo.mvp.contract.LoginContract;
import app.fynnjason.practicemvpdemo.mvp.model.LoginModel;

/**
 * Created by FynnJason on 2017/12/22.
 * 登录的Presenter
 */

public class LoginPresenter extends BasePresenter implements LoginContract.ILoginPresenter {

    private LoginModel mModel;
    private LoginContract.ILoginView mView;

    public LoginPresenter(LoginContract.ILoginView mView) {
        this.mView = mView;
        mModel = new LoginModel();
    }

    @Override
    public void requestLogin(String act, String psw) {
        mView.showLoading();
        mModel.requestLogin(act, psw, new ResultCallback<String>() {
            @Override
            public void onSuccess(String s) {
                mView.dismissLoading();
                mView.showToast(s);
                mView.loginSuccess();
            }

            @Override
            public void onFail(String msg) {
                mView.dismissLoading();
                mView.showToast(msg);
                mView.loginFail();
            }
        });
    }

    @Override
    public void start() {

    }
}
