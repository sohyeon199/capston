package com.example.application01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {

    //UI 요소들을 위한 참조 변수
    private Button btnScan;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //UI 요소와 변수를 연결
            btnScan = findViewById(R.id.btnScan);
            tvResult = findViewById(R.id.tvResult);


        // 스캔 버튼 클릭 시 스캔 시작 메소드 호출
        btnScan.setOnClickListener(v -> initiateScan());
    }
        
        private void initiateScan () { // 코드 스캔을 시작 하기 위한 메소드
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setPrompt("Scan a barcode or QR code"); //스캔 중 화면에 표시될 메시지
            integrator.setOrientationLocked(true); //화면 방향 고정 설정
            integrator.setCaptureActivity(CaptureActivityPortrait.class); //세로 방향 고정을 위한 사용자 정의 CaptureActivity 설정
            integrator.initiateScan(); //스캔 시작
        }

        //스캔 결과 처리
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                if (result.getContents() == null) {
                    tvResult.setText(R.string.cancelled_text); // 스캔이 취소 되었을 경우
                } else {
                    tvResult.setText(result.getContents()); // 스캔 결과 출력
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
}