package app.fynnjason.practicemvpdemo.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import app.fynnjason.practicemvpdemo.base.BasePresenter;
import app.fynnjason.practicemvpdemo.callback.ResultCallback;
import app.fynnjason.practicemvpdemo.mvp.contract.ListContract;
import app.fynnjason.practicemvpdemo.mvp.model.ListModel;

/**
 * Created by FynnJason on 2017/12/25.
 * 列表数据的Presenter
 */

public class ListPresener extends BasePresenter implements ListContract.IListPresenter {
    private ListModel mModel;
    private ListContract.IListView mView;


    public ListPresener(ListContract.IListView mView) {
        this.mView = mView;
        mModel = new ListModel();
    }

    @Override
    public void requestData(int page) {
        mModel.requestListData(page, new ResultCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> list) {
                mView.finishRefresh();
                mView.finishLoadMore();
                mView.dismissLoading();
                mView.requestSuccess(list);
                mView.showToast("刷新成功");
            }

            @Override
            public void onFail(String msg) {
                mView.finishRefresh();
                mView.finishLoadMore();
                mView.dismissLoading();
                mView.requestFail();
                mView.showToast(msg);
            }
        });
    }

    @Override
    public List<String> getData() {
        return mModel.getData();
    }

    @Override
    public void start() {
        mView.showLoading();
    }
}
