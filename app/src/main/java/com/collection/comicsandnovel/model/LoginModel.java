package com.collection.comicsandnovel.model;



import com.collection.comicsandnovel.app.App;
import com.collection.comicsandnovel.base.BaseModel;
import com.collection.comicsandnovel.bean.BaseEntity;
import com.collection.comicsandnovel.bean.Login;
import com.collection.comicsandnovel.contract.LoginContract;
import com.collection.comicsandnovel.net.BaseObserver;
import com.collection.comicsandnovel.net.RetrofitFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class LoginModel extends BaseModel<LoginContract.Model.Callback> implements LoginContract.Model {

    public LoginModel(Callback callback) {
        super(callback);
    }


    @Override
    public void login(String number, String password) {
        RetrofitFactory.getInstence().creatService()
                .login(number, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Login>() {
                    @Override
                    protected void onSuccees(BaseEntity<Login> t) throws Exception {
                        mCallback.onLoginSuccess(t.getData());
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mCallback.onLoginFailed(e.toString());
                    }
                });
    }

    @Override
    public void getVertical(String moildle) {
        RetrofitFactory.getInstence().creatService()
                .getVertical(moildle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    protected void onSuccees(BaseEntity t) throws Exception {
                        mCallback.getVerticalSuccess(t.getMsg());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mCallback.onLoginFailed(e.toString());
                    }
                });
    }
}
