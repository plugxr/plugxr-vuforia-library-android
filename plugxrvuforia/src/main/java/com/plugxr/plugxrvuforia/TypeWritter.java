package com.plugxr.plugxrvuforia;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;

import com.unity3d.player.customfonts.MyTextView;

/**
 * Created by one on 3/12/15.
 */
public class TypeWritter extends MyTextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500; //Default 500ms delay

    public TypeWritter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TypeWritter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TypeWritter(Context context) {
        super(context);
    }





    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }

}