package com.btzh.mycountdowntimer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("用户注册界面！");
        final EditText user = (EditText)findViewById(R.id.zc_username);
        final EditText word = (EditText)findViewById(R.id.zc_password);
        final EditText ok_word = (EditText)findViewById(R.id.zc_ok_password);



        findViewById(R.id.zc_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(user.getText().toString())){
                    Toast.makeText(Main6Activity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(word.getText().toString())){
                    Toast.makeText(Main6Activity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ok_word.getText().toString())){
                    Toast.makeText(Main6Activity.this, "确认密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!word.getText().toString().equals(ok_word.getText().toString())){
                    Toast.makeText(Main6Activity.this, "密码输入不一致！", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences.Editor editor = getSharedPreferences("LOGINTEST",MODE_PRIVATE).edit();
                editor.putString("username",user.getText().toString());
                editor.putString("password",ok_word.getText().toString());

                if (editor.commit()){
                    Toast.makeText(Main6Activity.this, "注册成功,请重新登录！", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(Main6Activity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
