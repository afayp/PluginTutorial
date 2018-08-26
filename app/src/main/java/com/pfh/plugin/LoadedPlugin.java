package com.pfh.plugin;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.util.ArrayList;

public class LoadedPlugin {

    public static final String TAG = "LoadedPlugin";

    public final static int PARSE_MUST_BE_APK = 1<<2;

    private ArrayList<Activity> activities;

    public static LoadedPlugin create(Context host, File apk) throws Exception {
        return new LoadedPlugin(host, apk);
    }



    public LoadedPlugin(Context host, File apk) {



    }


}
