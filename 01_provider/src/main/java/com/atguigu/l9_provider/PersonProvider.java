package com.atguigu.l9_provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.atguigu.l9_provider.db.DBHelper;

/**
 * Created by shuwei on 2016/6/16.
 */
public class PersonProvider extends ContentProvider{
    private DBHelper dbHelper;
//    private SQLiteDatabase database;
    private static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);

    static {//初始化matcher
        matcher.addURI("com.atguigu.l9_provider.personprovider","person/",1);
        matcher.addURI("com.atguigu.l9_provider.personprovider","person/#",2);
    }

    @Override
    public boolean onCreate() {
        dbHelper=new DBHelper(getContext(),1);
//        database = dbHelper.getReadableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //通过UriMatcher对象的match方法，获得uri的code
        int code = matcher.match(uri);
        Log.e("TAG", code+"");
        if(code==1){//采用方式一
            Cursor cursor = database.query("person", projection, selection, selectionArgs, null, null, sortOrder);
            return cursor;
        }else if(code==2){//采用方式二
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

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        try {
            //通过UriMatcher对象的match方法，获得uri的code
            int code = matcher.match(uri);

            if(code==1){
                //调用SQLiteDatabase中的插入方法。
                long insert = database.insert("person", null, values);
                return ContentUris.withAppendedId(uri,insert);//调用ContentUris.withAppendId（）方法返回一个uri。
            }
        } finally {
            database.close();

        }

        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //通过UriMatcher对象的match方法，获得uri的code
        try {
            int code = matcher.match(uri);

            //采用方式一
            if(code==1){
                int deleteCode = database.delete("person", selection, selectionArgs);
                return deleteCode;
            }else if(code==2){//采用方式二
                long id = ContentUris.parseId(uri);
                int deleteCode = database.delete("person", "_id=?", new String[]{id + ""});
                return deleteCode;
            }else{
                throw new RuntimeException("输入的uri不合法");
            }
        } finally {
            database.close();
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        try {
            //通过UriMatcher对象的match方法，获得uri的code
            int code = matcher.match(uri);
            if(code==1){//采用方式一
                int updateCode = database.update("person", values, selection, selectionArgs);
                return updateCode;
            }else if(code==2){//采用方式二
                long id = ContentUris.parseId(uri);
                int updateCode = database.update("person", values, "_id=?", new String[]{id + ""});
                return updateCode;
            }else{//不合前两种路径方式，则抛出异常
                throw new RuntimeException("输入的uri不合法");
            }
        } finally {
            database.close();

        }

    }
}
