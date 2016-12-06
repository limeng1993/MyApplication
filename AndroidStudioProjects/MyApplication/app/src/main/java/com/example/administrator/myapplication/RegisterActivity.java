package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragment.SimpleTextInputCellFragment;

public class RegisterActivity extends AppCompatActivity {
    SimpleTextInputCellFragment fragInputCellAccount;
    SimpleTextInputCellFragment fragInputCellPassword;
    SimpleTextInputCellFragment fragInputCellPasswordRepeat;
    SimpleTextInputCellFragment fragInputEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fragInputCellAccount=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.name);
        fragInputCellPassword=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.password);
        fragInputCellPasswordRepeat=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.surepassord);
        fragInputEmail=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_email);


    }

    @Override
    protected void onResume() {
        super.onResume();
        fragInputCellAccount.setLabelText("账户名");
        fragInputCellAccount.setHintText("请输入用户名");
        fragInputCellPassword.setLabelText("密码");
        fragInputCellPassword.setHintText("请输入密码");
        fragInputCellPassword.setIsPassword(true);
        fragInputCellPasswordRepeat.setLabelText("重复密码");
        fragInputCellPasswordRepeat.setHintText("请重复输入密码");
        fragInputEmail.setHintText("请输入邮箱");
        fragInputEmail.setLabelText("邮箱");
        fragInputCellPasswordRepeat.setIsPassword(true);

    }
}
