package com.atguigu.l9_provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.atguigu.l9_provider.db.DBHelper;

/**
 * Created by shuwei on 2016/6/16.
 */
public class PersonProvider extends ContentProvider{
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);

    static {
        matcher.addURI("com.atguigu.l9_provider.personprovider","person/",1);
        matcher.addURI("com.atguigu.l9_provider.personprovider","person/#",2);
    }

    @Override
    public boolean onCreate() {
        dbHelper=new DBHelper(getContext(),1);
        database = dbHelper.getReadableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        int code = matcher.match(uri);
        if(code==1){
            Cursor cursor = database.query("person", projection, selection, selectionArgs, null, null, sortOrder);
            return cursor;
        }else if(code==2){
            long id = ContentUris.parseId(uri);
            Cursor cursor = database.query("person", projection, "_id=?", new String[]{id + ""}, null, null, sortOrder);
            return cursor;

        }else{
            throw new RuntimeException("输入的uri不合法");
        }
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
