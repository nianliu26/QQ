package com.dh.qq;

/**
 * 登录界面主类
 * 需要实例化的控件：
 * 输入框：login_input_number,login_input_password
 * 可点击的控件：login_number_clear,login_password_clear,login_password_eye,login_button,login_forgot_password,login_goto_logon
 *
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    private EditText loginInputNumber;
    private EditText loginInputPassword;

    private ImageView loginNumberClear;
    private ImageView loginPasswordClear;
    private ImageView loginPasswordEye;
    private ImageView loginButton;

    private TextView loginForgotPassword;
    private TextView loginGotoLogon;

    private boolean isViewable=false;//密码是否可见
    private int a=0;//光标位置

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bundle=getIntent().getExtras();
        if (bundle==null) {
            loginInputNumber.setText(bundle.getString("number"));
            loginInputPassword.setText(bundle.getString("password"));
        }

    }

    /**
     * 初始化控件
     */
    private void initView(){
        loginInputNumber=findViewById(R.id.login_input_number);
        loginInputPassword=findViewById(R.id.login_input_password);

        loginNumberClear=findViewById(R.id.login_number_clear);
        loginPasswordClear=findViewById(R.id.login_password_clear);
        loginPasswordEye=findViewById(R.id.login_password_eye);
        loginButton=findViewById(R.id.login_button);

        loginForgotPassword=findViewById(R.id.login_forgot_password);
        loginGotoLogon=findViewById(R.id.login_goto_logon);

        loginPasswordEye.setImageResource(R.mipmap.eye_close);

        //将登录按钮设置为不可用
        loginButton.setEnabled(false);
        loginButton.setBackgroundResource(R.drawable.shape_button_unusable);

        //将以下按钮默认设置为不可见
        loginNumberClear.setVisibility(View.GONE);
        loginPasswordClear.setVisibility(View.GONE);
        loginPasswordEye.setVisibility(View.GONE);

        //监听
        loginInputNumber.addTextChangedListener(textWatcher);
        loginInputPassword.addTextChangedListener(textWatcher);
    }

    /**
     * 点击事件
     */
    public void login(View v){
        //此方法实现跳转到主页面的功能，即登录功能
        intent=new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

    public void findPassword(View v){
        //此方法实现跳转到找回密码页面的功能

    }

    public void toLogon(View v){
        //此方法实现跳转到注册页面的功能
        intent=new Intent(this,LogonActivity.class);
        startActivity(intent);
    }

    public void showPWD(View v){
        //此方法实现显示/隐藏密码的功能
        a=loginInputPassword.getSelectionStart();//获取光标当前位置
        if(isViewable){
            loginPasswordEye.setImageResource(R.mipmap.eye_close);
            loginInputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        }else {
            loginPasswordEye.setImageResource(R.mipmap.eye_open);
            loginInputPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        isViewable=!isViewable;
        loginInputPassword.setSelection(a);//设置光标位置
    }

    public void clearNUM(View v){
        //此方法实现清除账号输入框内容的作用
        loginInputNumber.setText("");
    }

    public void clearPWD(View v){
        //此方法实现清除密码输入框内容的作用
        loginInputPassword.setText("");
    }

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean login1=false,login2=false;
            if(loginInputNumber.getEditableText().length()>0){
                loginNumberClear.setVisibility(View.VISIBLE);
                login1=true;
            }else {
                loginNumberClear.setVisibility(View.GONE);
                login1=false;
            }
            if (loginInputPassword.getEditableText().length()>0){
                loginPasswordClear.setVisibility(View.VISIBLE);
                loginPasswordEye.setVisibility(View.VISIBLE);
            }else {
                loginPasswordClear.setVisibility(View.GONE);
                loginPasswordEye.setVisibility(View.GONE);
            }
            if (loginInputPassword.getEditableText().length()>=8){
                login2=true;
            }else login2=false;

            if (login1 && login2){
                loginButton.setEnabled(true);
                loginButton.setBackgroundResource(R.drawable.selector_text_to_button_alter_theme);
            }else{
                loginButton.setEnabled(false);
                loginButton.setBackgroundResource(R.drawable.shape_button_unusable);
            }

        }
    };
}
