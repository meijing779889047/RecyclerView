package com.bestom.mj.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bestom.mj.recyclerview.R;

import java.util.List;

/**
 * Created by mj on 2016/6/22.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {


    private Context      context;
    private List<String> list;
    public MyRecyclerAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
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
    public void onBindViewHolder(final MyRecyclerViewHolder holder, final int position) {
        holder.bindItem(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnClickListener!=null){
                    mOnClickListener.onItemClicklistener(holder.itemView,position);
                }

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnClickListener!=null){
                    mOnClickListener.onItemLongClicklistener(holder.itemView,position);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * 事件接口回调
     */
    public  OnClickListener mOnClickListener;
    public  interface  OnClickListener{
        void onItemClicklistener(View view,int position);
        void onItemLongClicklistener(View view,int position);
    }

    public void setOnItemClickListener(OnClickListener mOnClickListener){
        this.mOnClickListener=mOnClickListener;
    }
}
