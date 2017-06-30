package com.btzh.mycountdowntimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.btzh.mycountdowntimer.litepal.LitepalActivity;
import com.btzh.mycountdowntimer.sqlite.MySQLiteActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button btn;
    TimeCount  timeCount;
    TextView textView;
    Button sqliteBtn;
    Button litepal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String ssss = "qwer";
//        ssss = "ddddd"+ssss+"-----";
//        System.out.println("---->"+ssss);
        button = (Button)findViewById(R.id.buttonPanel_tes);
        button.setOnClickListener(this);
        btn = (Button)findViewById(R.id.buttonPanel_tesw);
        btn.setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        textView = (TextView)findViewById(R.id.textView);
        timeCount = new TimeCount(20000, 1000,button,textView);
        sqliteBtn = (Button)findViewById(R.id.button_sqlite);
        sqliteBtn.setOnClickListener(this);
        litepal = (Button)findViewById(R.id.button_litepal);
        litepal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPanel_tes:
                timeCount.start();
                break;
            case R.id.buttonPanel_tesw:
//                timeCount.cancel();
                Intent intentShare = new Intent("android.SharePreferences.study");
                startActivity(intentShare);
                break;
            case R.id.button:
                Intent intent = new Intent();
                intent.setAction("android.Main2activity");
                startActivity(intent);
//                timeCount.start();
                break;
            case R.id.button_sqlite:
                Intent intent2 = new Intent(this, MySQLiteActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_litepal:
                Intent intent3 = new Intent(this, LitepalActivity.class);
                startActivity(intent3);
                break;
            default:
                break;

        }
    }
}
