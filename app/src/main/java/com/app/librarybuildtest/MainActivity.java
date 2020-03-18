package com.app.librarybuildtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.plugxr.plugxrvuforia.Plugxr;

public class MainActivity extends AppCompatActivity {

    private Plugxr plugxrARScene;
    // Replace with your vuforia database keys
    private String LicenceKeyToUnity = "AcEmsVH/////AAABmTIBcS+Y20+Qjg+Jm6HZKjRCd7QlB0kbg7u51LVFw4IxOdMl1aBxg6nXZe5fCGXJSHqRY71OCtT1J02daVcAC3AW53R5urA8JYMgJ3zLB6mmwZSeOmH1ueNyZrXtW//OHVhgHMElAIA5Ws+KNbWLRhPESzEho2A4laZKPrxfHR21ID3gjxpMsZOv+URu4cp2AAde5LCG165bTXBglhzVuW5YyuXsppFKK0NT3ylM5Yk1qEcOT/oVXFvQFcWTGlapW402WcF7LRHS2Ya3yM0cr6VLMsvNqehArWTdM4Ya9u0YzdHm7uwG4isZ4iThg2+vLitkYxFG0ot+KyIdM/TLXvsGgEgV3bN/ColgsmrR9Z4e";
    private String AccessKeyToUnity = "e18395eb18679b91c83ec494152dcb1ee9355dd1";
    private String SecretKeyToUnity = "651471353c1b59a815f62e450dd3fa2c7bf6d8f0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plugxrARScene = new Plugxr(getApplicationContext());
        plugxrARScene.setVuforiaKeys(LicenceKeyToUnity,AccessKeyToUnity,SecretKeyToUnity);



        Button button = (Button)findViewById(R.id.startAr);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plugxrARScene.start();
            }
        });


    }
}
