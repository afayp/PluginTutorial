package com.pfh.plugin.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;


public class ActivityHookInstrumentation extends Instrumentation implements Handler.Callback {

    public static final String TAG = "ActivityInstrumentation";
    public static final int LAUNCH_ACTIVITY = 100;


    private Instrumentation mBase;

    public ActivityHookInstrumentation(Instrumentation mBase) {
        this.mBase = mBase;
    }


    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {

        // 隐氏intent暂不支持
        if (intent.getComponent() != null) {
            Log.i(TAG, String.format("execStartActivity[%s : %s]", intent.getComponent().getPackageName(),
                    intent.getComponent().getClassName()));
            // resolve intent with Stub Activity if needed
            ComponentsHandler.markIntentIfNeeded(intent);
        }


        return result;

    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
}
