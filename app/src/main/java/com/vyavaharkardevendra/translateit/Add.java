package com.vyavaharkardevendra.translateit;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by ABC on 27-Mar-17.
 */

public class Add extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addRecord(View view)
    {
        EditText word=(EditText)findViewById(R.id.addWord);
        String words=word.getText().toString();
        EditText meaning=(EditText)findViewById(R.id.addMeaning);
        String meanings=meaning.getText().toString();
        Spinner addspin=(Spinner)findViewById(R.id.addSpinner);
        String language=addspin.getSelectedItem().toString();

        if(word.getText().toString().trim().length()==0||
                meaning.getText().toString().trim().length()==0||
                language.trim().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Please Enter All Values";
            int duration = Toast.LENGTH_SHORT;

            Toast toast= Toast.makeText(context,text,duration);
            toast.show();
        }

        else if(language.equals("English Word"))
        {
           try
           {
               // TranslateDatabaseHelper translatedbhelper = new TranslateDatabaseHelper(this);
               // SQLiteDatabase db= translatedbhelper.getWritableDatabase();
               // Toast toast=Toast.makeText(this,"Step1",Toast.LENGTH_SHORT);
               // toast.show();
               // translatedbhelper.insertTranslation(db,words,meanings,"ENGLISH");


               SQLiteDatabase sqlDB = openOrCreateDatabase("db123",MODE_PRIVATE,null);
               sqlDB.execSQL("CREATE TABLE IF NOT EXISTS ENGLISH (word varchar(20),meaning varchar(30))");
               Toast toast=Toast.makeText(this,"Record!",Toast.LENGTH_SHORT);
               toast.show();
               sqlDB.execSQL("INSERT INTO ENGLISH(word,meaning) VALUES('"+words+"','"+meanings+"');");
               Toast toast1=Toast.makeText(this,"English Word Successfully Added!!",Toast.LENGTH_SHORT);
               toast1.show();
           }
           catch (Exception e)
           {
               Toast toast=Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT);
               toast.show();
           }
        }

        else
        {
            try
            {
                //TranslateDatabaseHelper translatedbhelper = new TranslateDatabaseHelper(this);
                //SQLiteDatabase db= translatedbhelper.getWritableDatabase();
                //translatedbhelper.insertTranslation(db,words,meanings,"GERMAN");
                Toast toast1=Toast.makeText(this,"Record!",Toast.LENGTH_SHORT);
                toast1.show();
                SQLiteDatabase sqlDB = openOrCreateDatabase("db123",MODE_PRIVATE,null);
                sqlDB.execSQL("CREATE TABLE IF NOT EXISTS GERMAN (word varchar(20),meaning varchar(30))");
                sqlDB.execSQL("INSERT INTO GERMAN(word,meaning) VALUES('"+words+"','"+meanings+"')");
                Toast toast=Toast.makeText(this,"German Word Successfully Added !!",Toast.LENGTH_SHORT);
                toast.show();
            }
            catch (Exception e)
            {
                Toast toast=Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
