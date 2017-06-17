package com.xuliwen.basecode.androidcode.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xuliwen.basecode.App;

/**
 * Created by xlw on 2017/6/1.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_STUDENT="create table student ("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"height float)";

    private static final String CREATE_FOOD="create table food ("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"price float)";

    public DBHelper() {
        super(App.getContext(), "database_test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL(CREATE_STUDENT);
          db.execSQL(CREATE_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
