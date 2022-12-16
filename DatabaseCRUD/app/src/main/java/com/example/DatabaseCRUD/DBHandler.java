package com.example.DatabaseCRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    public final static String dbName="Sample";
    public final static String tableName="sample";
    public final static String ID_COL="id";
    public final static String NAME_COL="name";
    public final static String NUM_COL="phone";

    public DBHandler(Context context)
    {
        super(context,dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+tableName+"("
                +ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NAME_COL+" TEXT UNIQUE,"+
                NUM_COL+" TEXT )";
        sqLiteDatabase.execSQL(query);
    }

    public void addEntry(String name,String num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put(NAME_COL,name);
        val.put(NUM_COL,num);
        db.insert(tableName,null,val);
        db.close();
    }

    public void delete(String name)
    {
       SQLiteDatabase db=this.getWritableDatabase();
       db.delete(tableName,"name=?",new String[]{name});
       db.close();
    }

    public void update(String name,String num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put(NUM_COL,num);
        db.update(tableName,val,"name=?",new String[]{name});
        db.close();
    }

    public String getInfo()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String info="-----------------\n";
        Cursor cur=db.rawQuery("SELECT * FROM "+tableName,null);
        if(cur.moveToFirst())
        {
            do{
                info+=cur.getInt(0)+"\n"+cur.getString(1)+"\n"+cur.getString(2)+"\n";
                info+="-----------------\n";
            }while (cur.moveToNext());
        }

        db.close();
        return info;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(sqLiteDatabase);
    }
}
