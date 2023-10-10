package com.example.application_1;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startScan(View view){
        //스캔을 시작하기 위한 코드 추가
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("바코드를 스캔해주세요"); // 스캔 화면에 표시되는 메시지
        integrator.setOrientationLocked(false); // 가로 및 세로 모드 지원
        integrator.setBeepEnabled(true); // 스캔 성공 시 소리 재생
        integrator.initiateScan(); // 스캔 시작
    }
}

