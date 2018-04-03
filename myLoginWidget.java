package com.example.hasee.myview.myView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.hasee.myview.R;

/**
 * Created by hasee on 2018/4/3.
 */

public class myLoginWidget extends FrameLayout implements View.OnClickListener{
    /**
    组合的控件
     头像
     账号
     密码
     登陆
     注册
     */
    private CircleImageView avatar;
    private AutoCompleteTextView email;
    private EditText password;
    private Button sign_in;
    private Button sign_up;

    private myLoginListener listener;
    public myLoginWidget(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.myloginlayout,this);
        avatar = (CircleImageView)findViewById(R.id.avatar);
        email = (AutoCompleteTextView)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        sign_in = (Button)findViewById(R.id.email_sign_in_button);
        sign_up = (Button)findViewById(R.id.sign_in);

        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);
    }

    /**
     * 设置头像
     * @param DrawableId
     */
    public void setAvatar(int DrawableId){
        avatar.setImageResource(DrawableId);
    }

    /**
     * 得到输入的账号
     * @return
     */
    public String getEmail(){
        return email.getText().toString();
    }

    /**
     * 得到输入的密码
     * @return
     */
    public String getPassword(){
        return password.getText().toString();
    }

    /**
     * 设置登录按钮的文字
     * @param text
     */
    public void setSign_inButtonText(String text){
        sign_in.setText(text);
    }

    /**
     * 设置注册按钮的文字
     * @param text
     */
    public void setSign_upButtonText(String text){
        sign_up.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.email_sign_in_button:
                listener.onSign_inClick(v);
                break;
            case R.id.sign_in:
                listener.onSign_upClick(v);
                break;
        }
    }

    public void setOnMyLoginListener(myLoginListener listener){
        this.listener = listener;
    }
    public interface myLoginListener{
        void onSign_inClick(View v);
        void onSign_upClick(View v);
    }
}
