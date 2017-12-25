package app.fynnjason.practicemvpdemo.mvp.contract;

import java.util.List;

import app.fynnjason.practicemvpdemo.base.IBasePresenter;
import app.fynnjason.practicemvpdemo.base.IBaseView;

/**
 * Created by FynnJason on 2017/12/25.
 * 协议类
 */

public interface ListContract {

    interface IListView extends IBaseView {
        void requestSuccess(List<String> datas);

        void requestFail();

        void finishRefresh();

        void finishLoadMore();
    }

    interface IListPresenter extends IBasePresenter {
        void requestData(int page);

        List<String> getData();
    }

}
