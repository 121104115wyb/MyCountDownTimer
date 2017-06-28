package com.btzh.mycountdowntimer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    List<String>getSharepreList;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("SharePreferences的读写！");
        inputText = (EditText)findViewById(R.id.editText_input);
        button1 = (Button)findViewById(R.id.share_save);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.share_clear);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.share_get);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.share_demo);
        button4.setOnClickListener(this);

    }

    private void shareSaveData(String input){
        SharedPreferences.Editor preferences = getSharedPreferences("mySharePreferences",MODE_PRIVATE).edit();
        preferences.putString("name",input);
        preferences.putString("age","23");
        preferences.putString("work","android");
        //带有返回值的提交方法，如果提交后有后续操作使用commit方法
//        preferences.commit();
        //对提交是否成功不关心，只是简单的提交方法
        preferences.apply();
        Toast.makeText(Main3Activity.this,"我保存了："+input+"其中固定写死的为："+"23"+"android",Toast.LENGTH_LONG).show();
    }
    private List<String>getShareDatatoList(String shareFileName){
        List<String>list = new ArrayList<>();
        SharedPreferences preferences = getSharedPreferences(shareFileName,MODE_PRIVATE);
        list.add(preferences.getString("name",""));
        list.add(preferences.getString("age",""));
        list.add(preferences.getString("work",""));
        return list;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.share_save)
            if (!TextUtils.isEmpty(inputText.getText().toString())){
                shareSaveData(inputText.getText().toString());
            }else {
                Toast.makeText(Main3Activity.this,"输入不能为空！",Toast.LENGTH_SHORT).show();
            }

        else if (id == R.id.share_get){
            getSharepreList = getShareDatatoList("mySharePreferences");
            Toast.makeText(Main3Activity.this,"share存储:"+getSharepreList.toString(),Toast.LENGTH_LONG).show();
            Log.d("sss","getSharepreList---"+getSharepreList.toString());
        }else if (id == R.id.share_clear){
            SharedPreferences.Editor preferences = getSharedPreferences("mySharePreferences",MODE_PRIVATE).edit();
            preferences.clear();
            Boolean s = preferences.commit()==true?true:false;
            if (s){
                Toast.makeText(this, "清除成功!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "清除失败!", Toast.LENGTH_SHORT).show();
            }
        }else if (id == R.id.share_demo){
            Intent intent = new Intent("android.SharePreferences.demo");
            startActivity(intent);
        }
    }
}
