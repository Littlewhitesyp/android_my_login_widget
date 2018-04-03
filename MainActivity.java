package com.example.hasee.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hasee.myview.myView.myLoginWidget;



public class MainActivity extends AppCompatActivity implements com.example.hasee.myview.myView.myLoginWidget.myLoginListener {
    /**
     * 自定义的登陆控件
     */
    private myLoginWidget myLoginWidget;

    String Email,  //账号
           password; //密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        myLoginWidget = (myLoginWidget)findViewById(R.id.login);
        myLoginWidget.setOnMyLoginListener(this);

        /**
         * 设置头像
         */
        myLoginWidget.setAvatar(R.drawable.photo3);
        /**
         * 设置登陆按钮文字
         */
        myLoginWidget.setSign_inButtonText("假装登陆");
        /**
         * 设置注册按钮文字
         */
        myLoginWidget.setSign_upButtonText("假装注册");

    }

    /**
     * 登录按钮处理事件
     */
    @Override
    public void onSign_inClick(View v) {
        Email = myLoginWidget.getEmail();
        Toast.makeText(this, Email+"登陆成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * 注册按钮处理事件
     */
    @Override
    public void onSign_upClick(View v) {
        Email = myLoginWidget.getEmail();
        password = myLoginWidget.getPassword();
        Toast.makeText(this, "账号："+Email+" 密码："+password+" 注册成功", Toast.LENGTH_SHORT).show();
    }
}
