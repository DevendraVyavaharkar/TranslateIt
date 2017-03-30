package com.vyavaharkardevendra.translateit;

/**
 * Created by ABC on 26-Mar-17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class English extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.german_to_english);
    }

    public void addWords(View view){
        Intent intent3=new Intent(this,Add.class);
        startActivity(intent3);
    }

    public void toEnglish(View view)
    {
        EditText edit=(EditText)findViewById(R.id.translateWordEng);
        String[] eng=edit.getText().toString().split("\n");

        if(eng[0].trim().length()==0)
        {
            Toast toast=Toast.makeText(this,"Please Enter Word",Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            //eng.replace("\\s+$","");                         // To remove unwanted whitespaces at the end of the input
            //eng.toLowerCase(Locale.ENGLISH);
            TextView txt = (TextView)findViewById(R.id.textViewEnglish);

            SQLiteOpenHelper translatedbhelper =new TranslateDatabaseHelper(this);
            SQLiteDatabase db= translatedbhelper.getReadableDatabase();

            Cursor cursor=db.query("GERMAN",
                    new String[] {"MEANING"},
                    "WORD=?",
                    eng,
                    null,null,null);

            String translation=new String();
            if(cursor!=null && cursor.moveToFirst())
            {
                while(cursor.moveToNext()) {
                    translation = cursor.getString(0);
                    txt.setText(translation);
                }
                Toast toast = Toast.makeText(this,"Record Found",Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(this,"No Record Found",Toast.LENGTH_SHORT);
                toast.show();
            }

            cursor.close();
            db.close();
        }

    }
}