package com.collection.comicsandnovel.contract;

import com.collection.comicsandnovel.bean.Login;

public interface LoginContract {
    interface Model {
        /**
         * login的网络请求
         */
        void login(String number, String password);

        //获取验证码
        void getVertical(String moildle);

        interface Callback {

            /**
             * 登陆成功
             */
            void onLoginSuccess(Login login);

            /**
             * 获取验证码成功
             */
            void getVerticalSuccess(String msg);

            /**
             * 登陆失败
             */
            void onLoginFailed(String msg);


            /**
             * 获取验证码成功
             */




            /**
             * 获取验证码失败
             */



        }

    }

    interface View {
        //跟界面展示相关，比如弹出土司，显示dialog等等
        void showToast(String msg);
        //展示登陆状态
        void showLoginStatus(String message);

        //展示登陆数据
        void showData(String message);


        //显示dialog
        void showDialog();

        //隐藏dialog
        void dismissDialog();

        //跳转mainactivity
        void toMainActivity();
    }

    interface Presenter {
        void login(String number, String password);
        void getVertical(String moildle);
    }
}
