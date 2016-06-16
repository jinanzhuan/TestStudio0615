package com.atguigu.l09_resolver;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * 测试使用ContentResolver调用ContentProvider的主界面
 *
 * @author shkstart
 */
public class MainActivity extends Activity {

	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	/*
	 * 通过ContentResolver调用ContentProvider插入一条记录
	 */
	public void insert(View v) {
		ContentResolver resolver = this.getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name", "HanMeimei");
		Uri uri = Uri.parse("content://com.atguigu.l9_provider.personprovider/person/");
		Uri insert = resolver.insert(uri, values);
		Toast.makeText(MainActivity.this, "insert=" + insert, Toast.LENGTH_SHORT).show();
	}

	/*
	 * 通过ContentResolver调用ContentProvider更新一条记录
	 */
	public void update(View v) {
		ContentResolver resolver = this.getContentResolver();
		//此处路径，注意需要加上前方的"content：//"，是全路径。
		Uri uri = Uri.parse("content://com.atguigu.l9_provider.personprovider/person/");

		ContentValues values = new ContentValues();
		values.put("name", "Jam");
		int updateCode = resolver.update(uri, values, "name=?", new String[]{"Tom"});
		Toast.makeText(MainActivity.this, "修改了第" + updateCode + "条数据", Toast.LENGTH_SHORT).show();
	}

	/*
	 * 通过ContentResolver调用ContentProvider删除一条记录
	 */
	public void delete(View v) {
		ContentResolver resolver = this.getContentResolver();

		Uri uri = Uri.parse("content://com.atguigu.l9_provider.personprovider/person/");
		int deleteCode = resolver.delete(uri, "name=?", new String[]{"LiLei"});
		Toast.makeText(MainActivity.this, "删除了第"+deleteCode+"条", Toast.LENGTH_SHORT).show();
	}

	/*
	 * 通过ContentResolver调用ContentProvider查询所有记录
	 */
	public void query(View v) {
		ContentResolver resolver = this.getContentResolver();
		Uri uri=Uri.parse("content://com.atguigu.l9_provider.personprovider/person/");
		Log.e("TAG", uri + "");
		Cursor cursor = resolver.query(uri, null, null, null, null);
		StringBuffer buffer=new StringBuffer();
		Log.e("TAG", "buffer");
		while(cursor.moveToNext()) {
			Log.e("TAG", "moveToNext");
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			buffer.append("id=" + id + "name=" + name + "\n");

		}
			Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_SHORT).show();
		cursor.close();
	}


}
