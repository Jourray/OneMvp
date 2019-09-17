package com.example.mylayout;


import android.database.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MylayUp mMyprogerssBar;
    private Button mBtn;
    private int pageSize;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mMyprogerssBar = findViewById(R.id.myprogerssBar);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            mMyprogerssBar.setProgress(i);
                        }
                    }
                }).start();
                break;
        }
    }
}
