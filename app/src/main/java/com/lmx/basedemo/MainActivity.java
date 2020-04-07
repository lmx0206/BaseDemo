package com.lmx.basedemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * @author Leung
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitle() {
        return "我是MainActivity的标题";
    }

    @Override
    protected void init() {
        setBackOnClickListener(() ->
                Toast.makeText(this, "点击了一下返回按钮", Toast.LENGTH_SHORT).show()
        );
    }
}
