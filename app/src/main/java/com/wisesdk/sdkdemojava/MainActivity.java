package com.wisesdk.sdkdemojava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wise.sdk.core.WiseSDK;

public class MainActivity extends AppCompatActivity implements WiseSDK.WiseSDKMeetingListener {
    private String tag = MainActivity.class.getSimpleName();

    /**
     * Sample teacher and student tokens.
     * Follow the wise API docs to fetch the required values
     * https://www.notion.so/wiseapp/Wise-API-Documentation-a38e78c9a79d439ca7d13bae9d2d5582
     */
    private String teacherToken = "5f72e04f121699872486dc8012345678";
    private String studentToken = "5fb8ab8cc91e3444349dc78165404171";

    // classroom ID
    private String classId = "5fb8ab8cc91e3444349dc781";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Starting a new meeting
         * Check for any existing zoom meeting before starting a new one
         * */
        findViewById(R.id.btn_start_meeting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goto meeting if it's in progress
                if (WiseSDK.Companion.getInstance(MainActivity.this).isMeetingInProgress()) {
                    WiseSDK.Companion.getInstance(MainActivity.this).returnToMeeting();
                } else {
                    // start meeting
                    WiseSDK.Companion.getInstance(MainActivity.this).startMeeting(teacherToken, classId, MainActivity.this);
                }
            }
        });

        /**
         * Starting a new meeting with meeting params
         * Check for any existing zoom meeting before starting a new one
         * */
        findViewById(R.id.btn_start_meeting_with_params).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goto meeting if it's in progress
                if (WiseSDK.Companion.getInstance(MainActivity.this).isMeetingInProgress()) {
                    WiseSDK.Companion.getInstance(MainActivity.this).returnToMeeting();
                } else {
                    // start meeting
                    // Replace the below values you get from wise API
                    // https://www.notion.so/wiseapp/Wise-API-Documentation-a38e78c9a79d439ca7d13bae9d2d5582
                    WiseSDK.Companion.getInstance(MainActivity.this).startMeetingWithParams(
                            classId,
                            "https://wise-live.zoom.us/s/96979300288?zak=eyJ0eXAiOiJKV1QiLCJzdiI6IjAwMDAwMSIsInptX3NrbSI6InptX28ybSIsImFsZyI6IkhTMjU2In0.eyJhdWQiOiJjbGllbnRzbSIsInVpZCI6IlZsakdmNnpOU2FPRzR2d1p3M0ZhWnciLCJpc3MiOiJ3ZWIiLCJzayI6IjAiLCJzdHkiOjk5LCJ3Y2QiOiJhdzEiLCJjbHQiOjAsIm1udW0iOiI5Njk3OTMwMDI4OCIsImV4cCI6MTY1NDQ5MjMzMiwiaWF0IjoxNjQ2NzE2MzMyLCJhaWQiOiJtZV9CVjB3d1RkLWZmZ3ctakZGZml3IiwiY2lkIjoiIn0.It_dUDsnSI_zHkWuYIGNE_nP0XMtWY09It63p9DQPp4",
                            "96979300288",
                            "666080",
                            "eyJ0eXAiOiJKV1QiLCJzdiI6IjAwMDAwMSIsInptX3NrbSI6InptX28ybSIsImFsZyI6IkhTMjU2In0.eyJhdWQiOiJjbGllbnRzbSIsInVpZCI6IlZsakdmNnpOU2FPRzR2d1p3M0ZhWnciLCJpc3MiOiJ3ZWIiLCJzayI6IjAiLCJzdHkiOjk5LCJ3Y2QiOiJhdzEiLCJjbHQiOjAsIm1udW0iOiI5Njk3OTMwMDI4OCIsImV4cCI6MTY1NDQ5MjMzMiwiaWF0IjoxNjQ2NzE2MzMyLCJhaWQiOiJtZV9CVjB3d1RkLWZmZ3ctakZGZml3IiwiY2lkIjoiIn0.It_dUDsnSI_zHkWuYIGNE_nP0XMtWY09It63p9DQPp4",
                            "VljGf6zNSaOG4vwZw3FaZw",
                            "169316985",
                            "",
                            true,
                            MainActivity.this
                    );
                }
            }
        });

        /**
         * Joining a live meeting
         * */
        findViewById(R.id.btn_join_meeting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goto meeting if it's in progress
                if (WiseSDK.Companion.getInstance(MainActivity.this).isMeetingInProgress()) {
                    WiseSDK.Companion.getInstance(MainActivity.this).returnToMeeting();
                } else {
                    // join meeting
                    WiseSDK.Companion.getInstance(MainActivity.this)
                            .joinMeeting(
                                    studentToken,
                                    "",
                                    "",
                                    "Student Name",
                                    MainActivity.this
                            );
                }
            }
        });
    }

    @Override
    public void onMeetingConnecting() {
        Log.d(tag, "onMeetingConnecting");
    }

    @Override
    public void onMeetingEnded() {
        Log.d(tag, "onMeetingEnded");
    }

    @Override
    public void onMeetingEndedByHost() {
        Log.d(tag, "onMeetingEndedByHost");
    }

    @Override
    public void onMeetingEndedWithError(@NonNull String s) {
        Log.d(tag, "onMeetingEndedWithError");
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
    public void onSDKError(int i) {
        Log.d(tag, "onSDKError");
    }
}