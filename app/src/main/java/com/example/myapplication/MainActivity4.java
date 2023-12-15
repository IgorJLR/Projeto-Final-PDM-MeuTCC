package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.hardware.SensorManager;



public class MainActivity4 extends AppCompatActivity {

    private SharedPreferences mySavedData;
    private SharedPreferences.Editor mySavedDataEditor;

    private Button btnSobre;

    private TextView headerText;

    private ImageView gifImageView;

    private OrientationEventListener orientationEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        gifImageView = findViewById(R.id.gifImageView);

        btnSobre = findViewById(R.id.buttonSobre);

        headerText = findViewById(R.id.text1);

        mySavedData = getSharedPreferences("mySavedDataFile", Context.MODE_PRIVATE);
        mySavedDataEditor = mySavedData.edit();

        if (mySavedData.getBoolean("remUser", false) && !mySavedData.getString("user", "nil").equals("")) {

            headerText.setText(mySavedData.getString("user", "nil")+", na hora de pesquisar");

        }

        int screenOrientation = OrientationUtils.getScreenOrientation(this);
        adjustGifScale(screenOrientation);

    }



    public  void abreSobre(View view){

        Intent i = new Intent(MainActivity4.this, SobreActivity.class);
        startActivity(i);

    }

    private void adjustGifScale(int orientation) {
        float scale = (orientation == Configuration.ORIENTATION_LANDSCAPE) ? 2.3f : 2.0f;

        // Set the scale to the GifImageView
        gifImageView.setScaleX(scale);
        gifImageView.setScaleY(scale);
    }

    public void nextText(View view) {

        Intent i = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the orientation event listener when the activity is destroyed
    }



}