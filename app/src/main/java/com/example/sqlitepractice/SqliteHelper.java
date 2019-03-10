package com.example.sqlitepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";


    public SqliteHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String string  = " create table if not exists " + TABLE_NAME  + " ( " + COL_1 + " integer primary key autoincrement ,  " +
                COL_2 + " text, " + COL_3 + " text, " + COL_4 + " integer)";
        db.execSQL(string);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String surname,int marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        long flag = db.insert(TABLE_NAME,null,contentValues);

        if(flag<0){
            return false;
        }
        else{
            return true;
        }

    }



    public boolean updatetData(String id , String name,String surname,int marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        long flag = db.update(TABLE_NAME,contentValues," ID = ?",new String []{id});

        return true;

    }


    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(" select * from " + TABLE_NAME,null);
    }

}
