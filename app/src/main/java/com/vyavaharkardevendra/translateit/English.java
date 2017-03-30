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

        TextView txt = (TextView)findViewById(R.id.textViewEnglish);
        //String str=txtvw.getText().toString();

        //SQLiteDatabase sqlDB = openOrCreateDatabase("db123", MODE_PRIVATE, null);
        //Cursor findTimes = sqlDB.rawQuery("SELECT meaning FROM GERMAN WHERE word LIKE '" + eng + "';", null);
        SQLiteOpenHelper translatedbhelper =new TranslateDatabaseHelper(this);
        SQLiteDatabase db= translatedbhelper.getReadableDatabase();

        Cursor cursor=db.query("GERMAN",
                new String[] {"MEANING"},
                "WORD=?",
                eng,
                null,null,null);

        String translation=new String();
        if(cursor.moveToFirst())
                translation=cursor.getString(0);
        else
        {
            Toast toast = Toast.makeText(this,"No Records Found!!",Toast.LENGTH_SHORT);
            toast.show();
        }
        txt.setText(translation);
        cursor.close();
        db.close();
     /*   try
        {
               // String meaning = findTimes.getString(findTimes.getColumnIndex("meaning"));
                Toast toast = Toast.makeText(this, "reached here", Toast.LENGTH_SHORT);
                toast.show();
                //txtvw.setText(meaning);
            }
            catch(Exception e)
            {
                Toast toast = Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }

            //findTimes.close();
            //sqlDB.close();

      */
    }
}