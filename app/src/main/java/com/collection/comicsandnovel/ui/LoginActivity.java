package com.collection.comicsandnovel.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.collection.comicsandnovel.R;
import com.collection.comicsandnovel.base.BaseActivity;
import com.collection.comicsandnovel.contract.LoginContract;
import com.collection.comicsandnovel.presenter.LoginPresenter;

import org.greenrobot.greendao.annotation.Id;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.BuildConfig;


public class LoginActivity
        extends BaseActivity<LoginPresenter> implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_login_phone)
     EditText mTextView;
    @BindView(R.id.et_vertical)
     EditText mTextLoginStutes;
    @BindView(R.id.tv_verification)
     Button verification;

    private boolean isStart = false;

    @Override
    protected void init() {
        initview();
        initlistener();
    }

    private void initview() {
        //verification=findViewById(R.id.tv_verification);
        verification.setText("验证码");
    }
    @OnClick(R.id.tv_verification)
    public void submit(View view) {
        // TODO submit data to server...
        mPresenter.getVertical(mTextView.getText().toString());
    }
    private void initlistener() {
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }


    //------------------以下全是跟界面相关的处理逻辑----------------------------------

    @Override
    public void showToast(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginStatus(String message) {
        mTextLoginStutes.setText(message);
    }

    @Override
    public void showData(String message) {
        mTextView.setText(message);
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(LoginActivity.this, "跳转主界面", Toast.LENGTH_SHORT).show();
    }

    //------------------以上全是跟界面相关的处理逻辑----------------------------------

    CountDownTimer timer = new CountDownTimer(2000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            int remainTime = (int) (millisUntilFinished / 1000L);
            Log.d("LoginActivity", "======remainTime=====" + remainTime);
        }

        @Override
        public void onFinish() {

        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        if (isStart) {
            timer.start();
        }

    }
}
