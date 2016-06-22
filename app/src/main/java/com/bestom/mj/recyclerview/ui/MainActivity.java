package com.bestom.mj.recyclerview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bestom.mj.recyclerview.R;
import com.bestom.mj.recyclerview.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements MyRecyclerAdapter.OnClickListener {

    private RecyclerView  mRecyclerView;
    private List<String>  list;
    private MyRecyclerAdapter mAdapter;

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

        mAdapter=new MyRecyclerAdapter(this,list);
        //设置recyclerView显示的方式  listview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  R.id.listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                break;
            case  R.id.hor_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,5,GridLayoutManager.HORIZONTAL,false));
                break;
            case  R.id.ver_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
                break;
            case  R.id.stagger:
                   Intent intent=new Intent(MainActivity.this,StaggerGridLagoutMainActivity.class);
                   startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClicklistener(View view, int position) {
        Toast.makeText(MainActivity.this,"短按："+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClicklistener(View view, int position) {
        Toast.makeText(MainActivity.this,"长按："+position,Toast.LENGTH_SHORT).show();
    }
}
