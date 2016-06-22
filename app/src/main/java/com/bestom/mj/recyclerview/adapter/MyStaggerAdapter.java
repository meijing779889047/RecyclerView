package com.bestom.mj.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bestom.mj.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 2016/6/22.
 */
public class MyStaggerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {


    private Context      context;
    private List<String> list;
    private List<Integer> height;
    public MyStaggerAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        height=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            height.add((int) (100+Math.random()*300));
        }
    }

    /**
     * 创建Viewholder将之与视图进行绑定
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        return new MyRecyclerViewHolder(view);
    }

    /**
     * 填充数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height=height.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.bindItem(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
