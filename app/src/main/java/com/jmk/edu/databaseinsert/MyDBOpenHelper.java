package com.jmk.edu.databaseinsert;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "jmk.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;

    public MyDBOpenHelper(Context context) {
        super(context, name, factory, version);
    }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE jmk_country (_id INTEGER PRIMARY KEY AUTOINCREMENT, country TEXT, city TEXT);");

        for(int i=0; i<10; i++){
            db.execSQL("INSERT INTO jmk_country VALUES( null, '" + "Country"+ i + "', '" + "City" + i + "');");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE jmk_country ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String country) {
        mdb.execSQL("DELETE FROM jmk_country WHERE country='" + country + "';");
    }

}
