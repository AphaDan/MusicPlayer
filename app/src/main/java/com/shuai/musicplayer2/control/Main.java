package com.shuai.musicplayer2.control;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.shuai.musicplayer2.R;
import com.shuai.musicplayer2.service.utils.GetMenuList;
import com.shuai.musicplayer2.service.utils.LikeCRUD;


public class Main extends AppCompatActivity {

    private EditText mEditText;
    private static final String TAG = "Main";
    //private TopListAdapter mAdapter;
    public static Handler mHandler;
    private String mKeyWord;
    private RecyclerView mTopList;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //new GetTopList();
    }


    private void initView() {
        mEditText = findViewById(R.id.keywords);
    }

    public void like(View view){
        if(new LikeCRUD().likeSelete(getApplicationContext(),10)){
            Intent intent = new Intent(Main.this,Result.class);
            intent.putExtra("Tag","我喜欢的音乐");
            intent.putExtra("keyword","");
            startActivity(intent);
        }else {
            Toast.makeText(this, "喜欢的音乐为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void dlList(View view){
        startActivity(new Intent(Main.this,Download.class));
    }

    public void search(View view) {
        mKeyWord = mEditText.getText().toString();

        if(mKeyWord ==null|| mKeyWord.equals("")){
            Toast.makeText(this, "请输入搜索关键词", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                new GetMenuList(30).getMusicList(mKeyWord);
                Intent intent = new Intent(Main.this, Result.class);
                intent.putExtra("Tag", "搜索：");
                intent.putExtra("keyword", mKeyWord);
                startActivity(intent);
            }catch (Exception o){
                Toast.makeText(this,"输入",Toast.LENGTH_LONG);
            }
        }

    }

}
