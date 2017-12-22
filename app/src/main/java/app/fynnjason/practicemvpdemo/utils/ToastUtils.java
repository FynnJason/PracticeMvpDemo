package app.fynnjason.practicemvpdemo.utils;

import android.widget.Toast;

import app.fynnjason.practicemvpdemo.App;

/**
 * Created by FynnJason on 2017/12/22.
 * Toast工具类
 */

public class ToastUtils {
    private static Toast sToast = null;

    public static void show(String msg) {
        if (sToast != null)
            sToast.cancel();
        sToast = Toast.makeText(App.getInstance(),msg,Toast.LENGTH_SHORT);
        sToast.show();
    }
}
