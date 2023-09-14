package com.example.sh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


//public class ScanActivity {
//}

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);

        // 바코드 스캐너 시작
        startBarcodeScanner();
    }

    private void startBarcodeScanner() {
        // IntentIntegrator를 사용하여 바코드 스캐너 활성화
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("바코드를 스캔하세요"); // 스캔할 때 나타날 메시지 설정
        integrator.setBeepEnabled(false); // 스캔 시 소리 설정 (true 또는 false)
        integrator.initiateScan(); // 스캐너 시작
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // IntentIntegrator에서 결과 처리
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String scannedData = result.getContents(); // 스캔된 바코드 데이터
                // 스캔된 데이터를 처리하거나 다른 동작을 수행할 수 있습니다.
            } else {
                // 스캔이 취소되었거나 유효한 바코드를 찾지 못한 경우 처리할 코드
            }
        }
    }
}