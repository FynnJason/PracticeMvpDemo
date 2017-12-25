package app.fynnjason.practicemvpdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import app.fynnjason.practicemvpdemo.R;

/**
 * Created by FynnJason on 2017/12/25.
 * RecyclerView适配器
 */

public class ListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ListAdapter(@Nullable List<String> data) {
        super(R.layout.item_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name, item).setText(R.id.tv_num, String.valueOf(helper.getAdapterPosition()));
    }
}
