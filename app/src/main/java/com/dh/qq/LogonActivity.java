package com.dh.qq;

/**
 * 这是注册页面的实现代码
 * 需要实例化的控件：
 * 输入框：logon_input_phonenum,logon_input_nickname,logon_inptu_pwd,logon_input_pwd_again
 * 按钮：logon_button,logon_cancel,logon_phonenum_clear,logon_nickname_clear,logon_password_clear,logon_ensure_password_clear
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LogonActivity extends Activity implements View.OnClickListener{

    private EditText logonInputPhoneNum;
    private EditText logonInputNickname;
    private EditText logonInputPassword;
    private EditText logonInputPasswordAgain;

    private TextView logonButton;
    private TextView logonCancel;

    private ImageView logonPhoneNumClear;
    private ImageView logonNicknameClear;
    private ImageView logonPasswordClear;
    private ImageView logonEnsurePasswordClear;

    private Intent intent;
    private Bundle bundle;

    private int number=123;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        initView();
        initListener();
    }

    /**
     * 控件初始化
     */
    private void initView(){
        logonInputPhoneNum=findViewById(R.id.logon_input_phonenum);
        logonInputNickname=findViewById(R.id.logon_input_nickname);
        logonInputPassword=findViewById(R.id.logon_input_pwd);
        logonInputPasswordAgain=findViewById(R.id.logon_input_pwd_again);

        logonButton=findViewById(R.id.logon_button);
        logonCancel=findViewById(R.id.logon_cancel);

        logonPhoneNumClear=findViewById(R.id.logon_phonenum_clear);
        logonNicknameClear=findViewById(R.id.logon_nickname_clear);
        logonPasswordClear=findViewById(R.id.logon_password_clear);
        logonEnsurePasswordClear=findViewById(R.id.logon_ensure_password_clear);

        logonPhoneNumClear.setVisibility(View.GONE);
        logonNicknameClear.setVisibility(View.GONE);
        logonPasswordClear.setVisibility(View.GONE);
        logonEnsurePasswordClear.setVisibility(View.GONE);

        logonButton.setEnabled(false);
        logonButton.setBackgroundResource(R.drawable.shape_button_unusable);
    }

    private void initListener(){
        logonPhoneNumClear.setOnClickListener(this);
        logonNicknameClear.setOnClickListener(this);
        logonPasswordClear.setOnClickListener(this);
        logonEnsurePasswordClear.setOnClickListener(this);

        logonButton.setOnClickListener(this);
        logonCancel.setOnClickListener(this);

        logonInputPhoneNum.addTextChangedListener(textWatcher);
        logonInputNickname.addTextChangedListener(textWatcher);
        logonInputPassword.addTextChangedListener(textWatcher);
        logonInputPasswordAgain.addTextChangedListener(textWatcher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logon_button:
                intent=new Intent();
                intent.setClass(this,LoginActivity.class);
                bundle=new Bundle();
                bundle.putString("number",number+"");
                bundle.putString("password",logonInputPassword.getEditableText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                break;
            case R.id.logon_cancel:
                intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logon_phonenum_clear:
                logonInputPhoneNum.setText("");
                break;
            case R.id.logon_nickname_clear:
                logonInputNickname.setText("");
                break;
            case R.id.logon_password_clear:
                logonInputPassword.setText("");
                break;
            case R.id.logon_ensure_password_clear:
                logonInputPasswordAgain.setText("");
                break;
        }
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
            if (logonInputPhoneNum.getEditableText().length()>0){
                logonPhoneNumClear.setVisibility(View.VISIBLE);
            }else logonPhoneNumClear.setVisibility(View.GONE);

            if (logonInputNickname.getEditableText().length()>0){
                logonNicknameClear.setVisibility(View.VISIBLE);
            }else logonNicknameClear.setVisibility(View.GONE);

            if (logonInputPassword.getEditableText().length()>0){
                logonPasswordClear.setVisibility(View.VISIBLE);
            }else logonPasswordClear.setVisibility(View.GONE);

            if (logonInputPasswordAgain.getEditableText().length()>0){
                logonEnsurePasswordClear.setVisibility(View.VISIBLE);
            }else logonEnsurePasswordClear.setVisibility(View.GONE);

            if (logonInputPhoneNum.getEditableText().length()==11 && logonInputNickname.getEditableText().length()>0 && logonInputPassword.getEditableText().length()>=8
                    && logonInputPassword.getEditableText().toString().equals(logonInputPasswordAgain.getEditableText().toString())){
                logonButton.setEnabled(true);
                logonButton.setBackgroundResource(R.drawable.selector_text_to_button_alter_theme);
            }else {
                logonButton.setEnabled(false);
                logonButton.setBackgroundResource(R.drawable.shape_button_unusable);
            }
        }
    };
}
