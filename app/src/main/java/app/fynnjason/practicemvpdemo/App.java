package app.fynnjason.practicemvpdemo;

import android.app.Application;

/**
 * Created by FynnJason on 2017/12/22.
 * Application
 */

public class App extends Application {

    private static App mApp = null;

    public static App getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}
