package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import fragment.SimpleTextInputCellFragment;

public class Login_Activity extends AppCompatActivity {
    //实例化三个SimpleTextInputCellFragment对象
    SimpleTextInputCellFragment fragInputCellUsername;
    SimpleTextInputCellFragment fragInputCellUserPassword;
    SimpleTextInputCellFragment fragInputCellUserPasswordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        fragInputCellUsername=(SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.user_name);
        fragInputCellUserPassword=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.user_password);



        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goRegister();
            }
        });
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });
        findViewById(R.id.btn_forgot_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goRecoverPassword();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragInputCellUsername.setLabelText("用户名");
        fragInputCellUsername.setHintText("请输入用户名");
        fragInputCellUserPassword.setLabelText("密码");
        fragInputCellUserPassword.setHintText("请输入密码");
        fragInputCellUserPassword.setIsPassword(true);
    }

    void goRegister(){
        Intent itnt = new Intent(this,RegisterActivity.class);
        startActivity(itnt);
    }
    void goLogin()
    {
        Intent intent=new Intent(this,HelloActivity.class);
        startActivity(intent);

    }
    void goRecoverPassword(){
        		Intent itnt = new Intent(this, PasswordRecoverActivity.class);
        		startActivity(itnt);
        	}
}

