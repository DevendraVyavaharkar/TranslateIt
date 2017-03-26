package com.vyavaharkardevendra.translateit;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the UK Flag ImageButton is clicked....German To English Translation
    public void translateToEnglish(View view){
        Intent intent1=new Intent(this,English.class);
        startActivity(intent1);
    }

    // This method is called when the German Flag ImageButton is clicked....English To German Translation
    public void translateToGerman(View view){
        Intent intent2=new Intent(this,German.class);
        startActivity(intent2);
    }

}
