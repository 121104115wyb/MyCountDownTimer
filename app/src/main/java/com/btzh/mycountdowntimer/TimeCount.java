package com.btzh.mycountdowntimer;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wyb on 2017/6/26.
 */

public class TimeCount extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    Button mButton;
    TextView textView;
    public TimeCount(long millisInFuture, long countDownInterval, Button button,TextView textView) {
        super(millisInFuture, countDownInterval);
        this.mButton = button;
        this.textView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mButton.setClickable(false);
        mButton.setText("开始倒计时");
        if (textView.getVisibility()==View.GONE){
            textView.setVisibility(View.VISIBLE);
        }
        textView.setText("("+millisUntilFinished/1000+")");

    }

    @Override
    public void onFinish() {
        mButton.setClickable(true);
        mButton.setText("倒计时已完成!");
        if (textView.getVisibility()==View.VISIBLE){
            textView.setVisibility(View.GONE);
        }
    }
}
