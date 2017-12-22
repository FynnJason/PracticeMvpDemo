package app.fynnjason.practicemvpdemo.ui;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;

import app.fynnjason.practicemvpdemo.R;
import app.fynnjason.practicemvpdemo.base.BaseActivity;
import app.fynnjason.practicemvpdemo.mvp.contract.LoginContract;
import app.fynnjason.practicemvpdemo.mvp.presenter.LoginPresenter;
import app.fynnjason.practicemvpdemo.utils.LoadingUtils;
import app.fynnjason.practicemvpdemo.utils.ToastUtils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {

    @Override
    public void showLoading() {
        LoadingUtils.show(this);
    }

    @Override
    public void dismissLoading() {
        LoadingUtils.dismiss();
    }


    @Override
    public void loginSuccess() {
        //登录成功后操作(比如界面跳转)
    }

    @Override
    public void loginFail() {
        //登录失败后操作
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.show(msg);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    private TextInputLayout mEtAccount, mEtPassword;
    private Button mBtnLogin;

    @Override
    protected void initView() {
        mEtAccount = findViewById(R.id.et_account);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin = findViewById(R.id.btn_login);
    }

    @Override
    protected void onPrepare() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accout = mEtAccount.getEditText().getText().toString();
                String password = mEtPassword.getEditText().getText().toString();

                mEtAccount.setErrorEnabled(false);
                mEtPassword.setErrorEnabled(false);

                if (validateAccount(accout) && validatePassword(password)) {
                    aPresenter.requestLogin(accout,password);
                }
            }
        });
    }

    /*显示错误提示，并获取焦点*/
    private void showError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    /*验证账号是否为空*/
    private boolean validateAccount(String account) {
        if (account.isEmpty()) {
            showError(mEtAccount, "用户名不能为空");
            return false;
        }
        return true;
    }

    /*验证密码是否为空*/
    private boolean validatePassword(String password) {
        if (password.isEmpty()) {
            showError(mEtPassword,"密码不能为空");
            return false;
        }
        return true;
    }

}
