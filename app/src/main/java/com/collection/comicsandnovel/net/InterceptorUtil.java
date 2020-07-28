package com.collection.comicsandnovel.net;

import android.content.SharedPreferences;
import android.util.Log;

import com.collection.comicsandnovel.app.App;
import com.collection.comicsandnovel.util.CarOnlyIdUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static android.content.Context.MODE_PRIVATE;

public class InterceptorUtil {
    public static String TAG="InterceptorUtil";
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w(TAG, "log: "+message );
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    public static Interceptor HeaderInterceptor(){
        return   new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mRequest=chain.request();
                Response response = null;
                // 新的请求,添加参数
                Request addParamRequest = addParam(mRequest);
                response = chain.proceed(addParamRequest);
                return response;
            }
        };

    }

    /**
     * 添加公共参数
     *
     * @param oldRequest
     * @return
     */
    private static Request addParam(Request oldRequest) {
        String Diviceid = CarOnlyIdUtils.getOnlyID(App.getAppContext());
        HttpUrl.Builder builder;
        Request newRequest;
            //Log.e("ZZZ", "addParam: "+222);
        newRequest = oldRequest.newBuilder()
                    .addHeader("sign", stringToMD5("af1020a25f48ds4g55r6y."))
                    //.addHeader("token", token)
                    .addHeader("channelCode", "")
                    .addHeader("uuid", Diviceid)
                    .build();
        Headers headers = newRequest.headers();
        return newRequest;
    }

    /**
     * 将字符串转成MD5值
     *
     * @param string
     * @return
     */
    public static String stringToMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

}
