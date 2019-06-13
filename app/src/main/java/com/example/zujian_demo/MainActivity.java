package com.example.zujian_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.componentlib.ServiceFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLogin;
    private Button mGozujian;
    private Button mShowUI;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLogin = (Button) findViewById(R.id.login);
        mGozujian = (Button) findViewById(R.id.gozujian);
        mShowUI = (Button) findViewById(R.id.showUI);
        mContainer = (FrameLayout) findViewById(R.id.container);

        mLogin.setOnClickListener(this);
        mGozujian.setOnClickListener(this);
        mShowUI.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                ServiceFactory.getInstance()
                        .getLoginService()
                        .launch(this, "");
                break;
            case R.id.gozujian:
                ServiceFactory.getInstance()
                        .getMineService()
                        .launch(this, 0);
                break;
            case R.id.showUI:
                ServiceFactory.getInstance()
                        .getLoginService()
                        .newUserInfoFragment(getSupportFragmentManager(),
                        R.id.container,
                        new Bundle());
                break;
        }
    }
}
