package com.vyavaharkardevendra.translateit;

/**
 * Created by ABC on 26-Mar-17.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

public class German extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_to_german);
    }

    public void addWords(View view){
        Intent intent3=new Intent(this,Add.class);
        startActivity(intent3);
    }
}
