package com.plugxr.plugxrvuforia;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.company.product.OverrideUnityActivity;
import com.unity3d.player.Api;

import org.json.JSONException;
import org.json.JSONObject;

public class PlugxrARScene extends OverrideUnityActivity {
    private static boolean isVerified;


    private String android_id;
    private JSONObject jsonObject;
    private String AccessKeyToUnity;
    private String SecretKeyToUnity;
    private String LicenceKeyToUnity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Intent intent = getIntent();
        LicenceKeyToUnity = intent.getStringExtra("LicenceKeyToUnity");
        AccessKeyToUnity = intent.getStringExtra("AccessKeyToUnity");
        SecretKeyToUnity = intent.getStringExtra("SecretKeyToUnity");


            jsonObject = new JSONObject();

            try {
                jsonObject.put("license_key",LicenceKeyToUnity);
                jsonObject.put("client_access",AccessKeyToUnity);
                jsonObject.put("client_secret",SecretKeyToUnity);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            UnitySendMessage("LoadSceneFromAndriod","DeviceID",android_id);

            UnitySendMessage("LoadSceneFromAndriod","BaseUrl", Api.BASE_URL_UNITY);

            UnitySendMessage("LoadSceneFromAndriod","KeysToAccess", String.valueOf(jsonObject));

            float yInches= metrics.heightPixels/metrics.ydpi;
            float xInches= metrics.widthPixels/metrics.xdpi;
            double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
            if (diagonalInches>=6.5){
                // 6.5inch device or bigger
                UnitySendMessage("LoadSceneFromAndriod","DeviceMode","Tab");
            }else{
                // smaller device
                UnitySendMessage("LoadSceneFromAndriod","DeviceMode","Phone");
            }


            //addControllertoFrame();


    }



    @Override
    protected void showMainActivity(String aSetToColor) {


    }

/*
    private void addControllertoFrame() {


        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(400, 400, Gravity.CENTER);
        final ImageView imageView = new ImageView(this);
        getUnityFrameLayout().addView(imageView);
        Glide.with(getApplicationContext()).load(R.drawable.source_one).asGif().into(imageView);
        imageView.setLayoutParams(params1);
        params1.setMargins(0,0,0,50);



        final TypeWritter myTextView = new TypeWritter(this);
        myTextView.setGravity(Gravity.CENTER);
        myTextView.setLayoutParams(params);
        getUnityFrameLayout().addView(myTextView);
        myTextView.animateText("Initializing AR Scene...");
        myTextView.setTextColor(getResources().getColor(R.color.colorAccent));
        myTextView.setCharacterDelay(100);
        myTextView.setTextSize(26.0f);
        params.setMargins(0,300,0,0);




        final TypeWritter myTextView1 = new TypeWritter(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                myTextView.setVisibility(View.GONE);


                myTextView1.setGravity(Gravity.CENTER);
                myTextView1.setLayoutParams(params);
                getUnityFrameLayout().addView(myTextView1);
                myTextView1.animateText("Initializing AR Scene...");
                myTextView1.setTextColor(getResources().getColor(R.color.colorAccent));
                myTextView1.setCharacterDelay(100);
                myTextView1.setTextSize(26.0f);
                params.setMargins(0,300,0,0);


            }
        },4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                imageView.setVisibility(View.GONE);
                myTextView.setVisibility(View.GONE);
                myTextView1.setVisibility(View.GONE);


            }
        },7000);


    }
*/


    @Override
    protected void UnitySendMessage(String gameObj, String method, String arg) {
        super.UnitySendMessage(gameObj, method, arg);
    }



}
