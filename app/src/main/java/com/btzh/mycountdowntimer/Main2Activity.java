package com.btzh.mycountdowntimer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("File文件的读写!");
        editText = (EditText)findViewById(R.id.file_edittext);
    }

    public void onClicklistenter(View view){
        switch (view.getId()){
            case R.id.file_data_save:
                String text = editText.getText().toString();
                if (!TextUtils.isEmpty(text)){
                    saveData(text);
                }else {
                    Toast.makeText(this, "输入不能为空!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.file_data_clear:
                if (!TextUtils.isEmpty(editText.getText().toString())){
                    editText.setText("");
                }
                break;
            case R.id.file_data_get:
                String getFileData = loadData("com.file.mytest");
                if (!TextUtils.isEmpty(getFileData)){
                    Toast.makeText(this, "获取到的内容为："+getFileData, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "获取失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }


    private void saveData(String String){
//        String data = "德玛西亚，永世长存!";
        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try {
            outputStream = openFileOutput("com.file.mytest", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(String);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String loadData(String filename){
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            inputStream = openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (null!=(line = reader.readLine())){
                content.append(line);
            }
            Log.d("sss","---String---"+content.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null!=inputStream){
                    inputStream.close();
                }
                if (null!=reader){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }
}
