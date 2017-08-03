package com.example.administrator.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_username)
    EditText txtUsername;
    @BindView(R.id.txt_password)
    EditText txtPassword;

    String getUsrName;
    Double password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void validateValue() {
        getUsrName = txtUsername.getText().toString();
        String getPassword = txtPassword.getText().toString();
        password = getPassword.equals('.') || getPassword.equals("") ? 0 : Double.valueOf(getPassword);
    }

    private void checkValue() {
        if(getUsrName.equals("Admin") && password == 1234){
            showToast("คุณ" + getUsrName + "ล็อคอินสำเร็จ");
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }else if (TextUtils.isEmpty(getUsrName) || TextUtils.isEmpty(String.valueOf(password))){
            showToast("ล็อคอินไม่สำเร็จ");
        }else {
            showToast("ล็อคอินไม่สำเร็จ");
        }
    }


    private void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_log_in)
    void onLogInButtonClick() {
        validateValue();
        checkValue();
    }

    @OnClick(R.id.btn_sign_up)
    void onSignUpButtonClick() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
