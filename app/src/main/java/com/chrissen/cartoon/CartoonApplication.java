package com.chrissen.cartoon;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import com.avos.avoscloud.AVOSCloud;
import com.chrissen.cartoon.dao.GreendaoManager;

import es.dmoral.toasty.Toasty;

/**
 * Created by chris on 2017/11/15.
 */

public class CartoonApplication extends Application {

    private static Context sContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initDB();
        initAVS();
        initToasty();
    }

    private void initAVS() {
        AVOSCloud.initialize(this,"CerxnIvmC3ETvKnKnyhtBJUn-gzGzoHsz","3DuTawa4tHmnxE14uAolpWJO");
    }

    private void initToasty() {
        Toasty.Config.getInstance()
                .setErrorColor(getResources().getColor(R.color.toast_error))
                .setSuccessColor(getResources().getColor(R.color.toast_success))
                .setTextColor(Color.WHITE)
                .apply();
    }

    private void initDB() {
        GreendaoManager.getInstance(sContext);
    }

    public static Context getContext(){
        return sContext;
    }

}
