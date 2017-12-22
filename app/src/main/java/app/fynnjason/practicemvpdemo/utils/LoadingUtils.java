package app.fynnjason.practicemvpdemo.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

import app.fynnjason.practicemvpdemo.App;

/**
 * Created by FynnJason on 2017/12/22.
 * Loading工具类
 */

public class LoadingUtils {

    private static ProgressDialog sProgressBar = null;

    public static void show(Context context) {
        if (sProgressBar == null) {
            sProgressBar = new ProgressDialog(context);
            sProgressBar.setTitle("正在加载···");
            sProgressBar.setCancelable(false);
        }
        sProgressBar.show();
    }

    public static void dismiss() {
        if (sProgressBar != null) {
            sProgressBar.dismiss();
        }
    }
}
