package com.btzh.mycountdowntimer.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.btzh.mycountdowntimer.R;

/**
 * Created by wyb on 2017/6/28.
 */

public class MySQLiteActivity extends AppCompatActivity {
    private static final String SQLITE_FOR_DATABASE_NAME = "BookStore.db";
    private Button createDataBase;
    private MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_layout);
        setTitle("Android for SQLite!");
        myDatabaseHelper = new MyDatabaseHelper(this,SQLITE_FOR_DATABASE_NAME,null,1);
        createDataBase = (Button)findViewById(R.id.create_database);
        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });
    }
}
