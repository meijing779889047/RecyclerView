package com.bestom.mj.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bestom.mj.recyclerview.R;

/**
 * Created by mj on 2016/6/22.
 */
public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView  textView;

    public MyRecyclerViewHolder(View itemView) {
        super(itemView);
        textView= (TextView) itemView.findViewById(R.id.text);
    }
    public void bindItem(String data){
        textView.setText(data);
    }
}
