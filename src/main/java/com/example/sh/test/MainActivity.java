package com.example.sh.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View view) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    // Button2를 클릭했을 때 호출되는 메서드
    public void onButton2Clicked(View view) {
        // Intent를 사용하여 새로운 화면으로 이동
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }

    public void onButton3Clicked(View view) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void onButton4Clicked(View view) {
        // 이 곳에 버튼 클릭 시 실행할 코드를 작성하세요.
    }

}
