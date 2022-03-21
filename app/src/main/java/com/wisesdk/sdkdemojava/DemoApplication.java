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
        WiseSDK.Companion.getInstance(this).initialize(new WiseSDK.WiseSDKInitListener() {
            @Override
            public void onVendorIdError() {

            }

            @Override
            public void onInitialised() {

            }
        });
    }
}
