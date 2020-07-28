package com.collection.comicsandnovel.presenter;

import android.util.Log;

import com.collection.comicsandnovel.base.BasePresenter;
import com.collection.comicsandnovel.bean.Login;
import com.collection.comicsandnovel.contract.LoginContract;
import com.collection.comicsandnovel.model.LoginModel;

import javax.security.auth.login.LoginException;

public class LoginPresenter extends BasePresenter<LoginContract.View, LoginModel> implements LoginContract.Presenter, LoginContract.Model.Callback {
    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    protected LoginModel createModel() {
        return new LoginModel(this);
    }


    //具体的逻辑，在model中去完成，model中主要是获取数据  ，presenter中主要的逻辑转换，比如出来i请求网络，处理回掉，处理界面显示等等
    @Override
    public void login(String number, String password) {
        mView.showDialog();
        mModel.login(number,password);
    }

    @Override
    public void getVertical(String moildle) {
        mModel.getVertical(moildle);
    }


    //接口数据请求回掉
    @Override
    public void onLoginSuccess(Login login) {
        mView.showToast(login.toString());
        mView.showLoginStatus("login success");
        mView.showData(login.toString());
        mView.dismissDialog();
        mView.toMainActivity();
    }

    @Override
    public void getVerticalSuccess(String msg) {
        mView.showToast(msg);
    }

    @Override
    public void onLoginFailed(String msg) {
        mView.showToast(msg);
        Log.e("QWQ", "onLoginFailed: "+msg);
        mView.showLoginStatus("login failed");
        mView.dismissDialog();
    }

}
