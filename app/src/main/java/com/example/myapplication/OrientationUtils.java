package com.example.myapplication;

import android.content.Context;
import android.view.WindowManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.Display;

public class OrientationUtils {

    public static int getScreenOrientation(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;

            return width >= height ? Configuration.ORIENTATION_LANDSCAPE : Configuration.ORIENTATION_PORTRAIT;
        }
        return Configuration.ORIENTATION_UNDEFINED;
    }

}
