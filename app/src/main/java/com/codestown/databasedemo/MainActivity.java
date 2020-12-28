package com.codestown.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
//        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//        myDatabase.execSQL("INSERT INTO users (name, age) VALUES('AHSAN',19)");
//        myDatabase.execSQL("INSERT INTO users (name, age) VALUES('kashif',23)");
//
//        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
//        int nameIndex = c.getColumnIndex("name");
//        int ageIndex = c.getColumnIndex("age");
//        c.moveToFirst();
//        while (c != null){
//            Log.i("name", c.getString(nameIndex));
//            Log.i("age", c.getString(ageIndex));
//            c.moveToNext();
//        }
//        try {
//            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Events",MODE_PRIVATE,null);
//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");
//
//            myDatabase.execSQL("INSERT INTO events(name, year) VALUES ('Milenium',2000)");
//            myDatabase.execSQL("INSERT INTO events(name, year) VALUES ('Job Started',2017)");
//
//            Cursor c = myDatabase.rawQuery("SELECT * FROM events", null);
//            int nameIndex = c.getColumnIndex("name");
//            int yearIndex = c.getColumnIndex("year");
//            c.moveToFirst();
//            while (c != null){
//                Log.i("name",c.getString(nameIndex));
//                Log.i("year", Integer.toString(c.getInt(yearIndex)));
//                c.moveToNext();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES('AHSAN',19)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES('ALI',30)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES('AHMED',25)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES('kashif',23)");

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name = 'AHSAN' AND age < 26", null);
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'k%'", null);
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%'", null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1", null);
            //myDatabase.execSQL("DELETE FROM users WHERE name = 'kashif'");
            myDatabase.execSQL("DELETE FROM newUsers WHERE id = 4");
            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers",null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();
            while (c != null) {
                Log.i("id", Integer.toString(c.getInt(idIndex)));
                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}