package com.btzh.mycountdowntimer.litepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.btzh.mycountdowntimer.R;

import org.litepal.LitePal;

public class LitepalActivity extends AppCompatActivity {
    private Button creat_litepal;
    private Button add_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.litepal_layout);
        creat_litepal = (Button)findViewById(R.id.creat_litepal);
        creat_litepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                Toast.makeText(LitepalActivity.this, "litepal创建成功！", Toast.LENGTH_SHORT).show();
            }
        });
        add_data = (Button)findViewById(R.id.add_data_litepal);
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setAuthor("wyb");
                book.setId(12345);
                book.setName("测试");
                book.setPage(100);
                book.setPress("社会出版社");
                book.setPrice(10005.123);
                book.save();
            }
        });

    }
}
