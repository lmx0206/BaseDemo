package com.lmx.basedemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * @author Leung
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
    }

    private void initView() {
        // 绑定控件
        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout container = findViewById(R.id.container);
        // 初始化设置Toolbar
        toolbar.setTitle(setTitle());
        setSupportActionBar(toolbar);
        // 将继承了BaseActivity的布局文件解析到 container 中，这样 BaseActivity 就能显示 MainActivity 的布局文件了
        LayoutInflater.from(this).inflate(getContentView(), container);
        // 显示返回按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        init();
    }

    /**
     * 获取要显示内容的布局文件的资源id
     *
     * @return 显示的内容界面的资源id
     */
    protected abstract int getContentView();

    /**
     * 设置标题
     *
     * @return 要显示的标题名称
     */
    protected abstract String setTitle();

    /**
     * 返回按钮的单击监听事件
     */
    public interface BackOnClickListener {
        /**
         * 点击事件
         */
        void onClick();
    }

    /**
     * 子类可以调用这个方法进行初始化
     */
    protected abstract void init();

    /**
     * 声明一个返回按钮的单击监听事件
     */
    BackOnClickListener backOnClickListener;

    /**
     * 给这个监听事件赋值
     *
     * @param backOnClickListener 子类重写的监听事件
     */
    public void setBackOnClickListener(BackOnClickListener backOnClickListener) {
        this.backOnClickListener = backOnClickListener;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            backOnClickListener.onClick();
        }
        return true;
    }
}
