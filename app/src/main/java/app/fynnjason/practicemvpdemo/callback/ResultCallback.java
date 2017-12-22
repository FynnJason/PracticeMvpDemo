package app.fynnjason.practicemvpdemo.callback;

/**
 * Created by FynnJason on 2017/12/22.
 * 回调（模拟）
 */

public interface ResultCallback<T> {
    void onSuccess(T t);

    void onFail(String msg);
}
