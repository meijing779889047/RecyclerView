package com.bestom.mj.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.bestom.mj.recyclerview.R;
import com.bestom.mj.recyclerview.adapter.MyRecyclerAdapter;
import com.bestom.mj.recyclerview.adapter.MyStaggerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView 瀑布流
 */
public class StaggerGridLagoutMainActivity extends AppCompatActivity {

    private RecyclerView  mRecyclerView;
    private List<String>  list;
    private MyStaggerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化组件
        initView();
        //初始化数据
        initData();
    }

    //初始化组件
    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.rv);
    }
    //初始化数据
    private void initData() {
        list=new ArrayList<>();
        for (int i = 0; i <40 ; i++) {
            list.add("第"+i+"数据");
        }

        mAdapter=new MyStaggerAdapter(this,list);
        //设置recyclerView显示的方式  瀑布流
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL));
        //设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        mRecyclerView.setAdapter(mAdapter);

    }


}
