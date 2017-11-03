package com.example.administrator.omok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_TEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.btn);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TestActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       //super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_TEST) {
            Toast toast = Toast.makeText(getBaseContext(),
                    "OnActivityResult 메소드 호출됨. 요청 코드 : "+requestCode+", 결과코드 : "+resultCode
                    , Toast.LENGTH_SHORT);
            toast.show();
        }

        if(resultCode ==RESULT_OK) {
            String name = data.getExtras().getString("name");
            Toast.makeText(getBaseContext(), "응답으로 전달된 name : "+ name, Toast.LENGTH_LONG).show();
        }
    }
}
