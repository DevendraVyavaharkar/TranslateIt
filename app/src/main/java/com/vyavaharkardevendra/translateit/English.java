package com.vyavaharkardevendra.translateit;

/**
 * Created by ABC on 26-Mar-17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class English extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.german_to_english);
    }

    public void addWords(View view){
        Intent intent3=new Intent(this,Add.class);
        startActivity(intent3);
    }
}
