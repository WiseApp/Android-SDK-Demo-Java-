package com.wisesdk.sdkdemojava;

import android.app.Application;

import com.wise.sdk.core.WiseSDK;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initWiseSdk();
    }

    /**
     * Initialise should be called as soon as app starts
     */
    private void initWiseSdk() {
        // set vendor Id and namespace
        // Send an email to info@wiseapp.live to get your VENDOR_ID and NAMESPACE
        // to be used in the Android Integration steps below
        WiseSDK.Companion.getInstance(this).init("5f72e04f121699872486dc80", "wise");

        // custom lens icon
        WiseSDK.Companion.getInstance(this).setLensIcon(R.mipmap.ic_launcher);
    }
}
