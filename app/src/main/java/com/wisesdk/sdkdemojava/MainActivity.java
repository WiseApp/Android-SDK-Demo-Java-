package com.wisesdk.sdkdemojava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wise.sdk.core.WiseSDK;

public class MainActivity extends AppCompatActivity implements WiseSDK.WiseSDKMeetingListener {
    private String tag = MainActivity.class.getSimpleName();

    private String classPublicID = "649a8a5cbc098a31f0808bfc35114999";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Joining a live meeting
         * */
        findViewById(R.id.btn_join_meeting).setOnClickListener(view -> {
            // goto meeting if it's in progress
            if (WiseSDK.Companion.getInstance(MainActivity.this).isMeetingInProgress()) {
                WiseSDK.Companion.getInstance(MainActivity.this).returnToMeeting();
            } else {
                // join meeting
                WiseSDK.Companion.getInstance(MainActivity.this)
                        .joinMeeting(
                                classPublicID,
                                "3343222",
                                "Mr John",
                                MainActivity.this
                        );
            }
        });
    }

    @Override
    public void onMeetingConnecting() {
        Log.d(tag, "onMeetingConnecting");
    }

    @Override
    public void onMeetingEndedByHost() {
        Log.d(tag, "onMeetingEndedByHost");
    }

    @Override
    public void onMeetingNeedPasswordOrDisplayName() {
        Log.d(tag, "onMeetingNeedPasswordOrDisplayName");
    }

    @Override
    public void onMeetingNotStartedByHostError() {
        Log.d(tag, "onMeetingNotStartedByHostError");
    }

    @Override
    public void onMeetingStarted(boolean b) {
        Log.d(tag, "onMeetingStarted");
    }

    @Override
    public void onInitialised() {

    }

    @Override
    public void onMeetingEnded(@Nullable String s) {

    }

    @Override
    public void onMeetingEndedWithError(@NonNull String s, int i, int i1) {

    }

    @Override
    public void onSDKError(int i, int i1, int i2) {

    }

    @Override
    public void onVendorIdError() {

    }
}