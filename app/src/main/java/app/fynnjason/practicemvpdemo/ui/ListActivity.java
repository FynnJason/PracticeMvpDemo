package app.fynnjason.practicemvpdemo.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import app.fynnjason.practicemvpdemo.R;
import app.fynnjason.practicemvpdemo.adapter.ListAdapter;
import app.fynnjason.practicemvpdemo.base.BaseActivity;
import app.fynnjason.practicemvpdemo.mvp.contract.ListContract;
import app.fynnjason.practicemvpdemo.mvp.presenter.ListPresener;
import app.fynnjason.practicemvpdemo.utils.LoadingUtils;
import app.fynnjason.practicemvpdemo.utils.ToastUtils;

public class ListActivity extends BaseActivity<ListPresener> implements ListContract.IListView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    protected ListPresener getPresenter() {
        return new ListPresener(this);
    }

    private RecyclerView mRecycler;
    private ListAdapter mAdapter;
    private SmartRefreshLayout mRefresh;

    @Override
    protected void initView() {
        mRecycler = findViewById(R.id.recycler_view);
        mRefresh = findViewById(R.id.smart_refresh);

        mRefresh.setRefreshHeader(new ClassicsHeader(this));
        mRefresh.setRefreshFooter(new ClassicsFooter(this));

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setHasFixedSize(true);
        mAdapter = new ListAdapter(aPresenter.getData());
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    protected void onPrepare() {
        aPresenter.requestData(0);

        mRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                aPresenter.requestData(0);
            }
        });

        mRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                aPresenter.requestData(1);
            }
        });
    }

    @Override
    public void showLoading() {
        LoadingUtils.show(this);
    }

    @Override
    public void dismissLoading() {
        LoadingUtils.dismiss();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.show(msg);
    }

    @Override
    public void requestSuccess(List<String> datas) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void requestFail() {
        //请求失败后的其他逻辑
    }

    @Override
    public void finishRefresh() {
        mRefresh.finishRefresh();
    }

    @Override
    public void finishLoadMore() {
        mRefresh.finishLoadmore();
    }
}
