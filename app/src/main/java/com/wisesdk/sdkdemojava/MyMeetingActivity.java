package com.wisesdk.sdkdemojava;

import us.zoom.sdk.MeetingActivity;

public class MyMeetingActivity extends MeetingActivity {
    @Override
    public void onBackPressed() {
        finish();
    }
}
