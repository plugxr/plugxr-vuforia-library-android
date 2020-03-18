package com.plugxr.plugxrvuforia;

import android.content.Context;
import android.content.Intent;


public class Plugxr  {

    private final Context mainActivity;
    private String LicenceKeyToUnity,AccessKeyToUnity,SecretKeyToUnity;

    public Plugxr(Context mainActivity) {

        this.mainActivity = mainActivity;
    }


    public void setVuforiaKeys(String LicenceKeyToUnity, String AccessKeyToUnity, String SecretKeyToUnity) {

        this.LicenceKeyToUnity = LicenceKeyToUnity;
        this.AccessKeyToUnity =AccessKeyToUnity;
        this.SecretKeyToUnity = SecretKeyToUnity;

    }

    public void start() {

        Intent intent = new Intent(mainActivity,PlugxrARScene.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("LicenceKeyToUnity",LicenceKeyToUnity);
        intent.putExtra("AccessKeyToUnity",AccessKeyToUnity);
        intent.putExtra("SecretKeyToUnity",SecretKeyToUnity);
        mainActivity.startActivity(intent);

    }

}
