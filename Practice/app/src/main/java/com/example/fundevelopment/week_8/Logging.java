package com.example.fundevelopment.week_8;

import android.util.Log;

import com.example.fundevelopment.BuildConfig;

public class Logging {
  public static void show(Object obj, String message) {
      if (BuildConfig.DEBUG) {
          Log.e(obj.getClass().getName(), message);
      }
  }
}