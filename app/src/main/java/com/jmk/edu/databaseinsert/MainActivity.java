package com.jmk.edu.databaseinsert;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new MyDBOpenHelper(this, "jmk.db", null, 1);
            mdb = dbHelper.getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.buttonInsert)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonRead)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonUpdate)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonDelete)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextCity = (EditText) findViewById(R.id.editTextCity);
        String city=editTextCity.getText().toString();
        EditText editTextCountry = (EditText) findViewById(R.id.editTextCountry);
        String country=editTextCity.getText().toString();

        TextView textView=(TextView) findViewById(R.id.textView);
        switch(v.getId()){
            case R.id.buttonInsert :

                mdb.execSQL("INSERT INTO jmk_country VALUES( null, '" + country + "', '" + city + " ');");
                editTextCity.setText("");
                editTextCountry.setText("");

                break;
            case R.id.buttonRead :
              //  textView.setText();
                break;
            case R.id.buttonUpdate :
                break;
            case R.id.buttonDelete :
                break;
            default:
                break;
        }
    }
}
