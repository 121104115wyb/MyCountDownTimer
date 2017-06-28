package com.btzh.mycountdowntimer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    Button login_btn;
    Button zc_btn;
    CheckBox checkBox;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("登录注册界面！");
        login_btn = (Button)findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
        zc_btn = (Button)findViewById(R.id.button3);
        zc_btn.setOnClickListener(this);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        username = (EditText)findViewById(R.id.username_text);
        password = (EditText)findViewById(R.id.password_text);
        checkBox.setChecked(getCheckedStatus());
        Log.d("share","...checkBox:..."+getCheckedStatus());
        if (checkBox.isChecked()){
            SharedPreferences preferences = getSharedPreferences("LOGINTEST",MODE_PRIVATE);
            String sharename = preferences.getString("username","");
            String sharepassword = preferences.getString("password","");
            username.setText(sharename);
            password.setText(sharepassword);
            Log.d("share","...user:..."+sharename+"\n"+"...password...:"+sharepassword);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login_btn:
                loginTo(username.getText().toString(),password.getText().toString());
                break;
            case R.id.button3:
                Intent zc = new Intent(Main4Activity.this,Main6Activity.class);
//                username.setText("");
//                password.setText("");
                startActivity(zc);
                break;
            default:
                break;
        }

    }


    private void loginTo(String name,String password){
        SharedPreferences preferences = getSharedPreferences("LOGINTEST",MODE_PRIVATE);
        String sharename = preferences.getString("username","");
        String sharepassword = preferences.getString("password","");
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
            if (name.equals(sharename) && password.equals(sharepassword)){
                //保存按钮状态
                setCheckBoxStatus();
                Intent skip = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(skip);
                finish();
            }else {
                Toast.makeText(Main4Activity.this,"用户名或密码输入错误！",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(Main4Activity.this,"用户名或密码不能为空！",Toast.LENGTH_SHORT).show();
        }
    }


    private Boolean getCheckedStatus(){
        SharedPreferences preferences = getSharedPreferences("LOGINTEST",MODE_PRIVATE);
        return preferences.getBoolean("checked",false);
    }

    private void setCheckBoxStatus(){
        SharedPreferences.Editor preferences = getSharedPreferences("LOGINTEST",MODE_PRIVATE).edit();
        preferences.putBoolean("checked",checkBox.isChecked());
        preferences.apply();
    }
}
