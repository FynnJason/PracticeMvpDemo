package app.fynnjason.practicemvpdemo.mvp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.fynnjason.practicemvpdemo.callback.ResultCallback;

/**
 * Created by FynnJason on 2017/12/25.
 */

public class ListModel {

    private String[] mNames = new String[]{"小王", "小红", "小军", "小李", "小赵"};
    private List<String> mData = new ArrayList<>();

    public void requestListData(int page, ResultCallback<List<String>> callback) {
        //模拟请求成功或失败
        int error = new Random().nextInt(10);
        if (error < 4) {
            callback.onFail("请求失败");
            return;
        }

        if (page == 0) {
            mData.clear();
        }
        //随机生成10条数据，模拟网络请求
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(5);
            mData.add(mNames[r]);
        }
        callback.onSuccess(mData);
    }

    public List<String> getData() {
        return mData;
    }
}
