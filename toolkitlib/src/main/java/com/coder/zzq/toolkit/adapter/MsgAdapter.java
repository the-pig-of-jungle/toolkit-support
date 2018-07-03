package com.coder.zzq.toolkit.adapter;

import com.coder.zzq.toolkit.R;

public class MsgAdapter extends BaseRecyclerViewAdapter<String> {

    @Override
    protected int itemLayoutRes() {
        return R.layout.item_msg;
    }

    @Override
    protected void bindDataToItem(AdapterViewHolder holder, String s, int position) {
        holder.getRootView().toTextView().setText(s);
    }


}
