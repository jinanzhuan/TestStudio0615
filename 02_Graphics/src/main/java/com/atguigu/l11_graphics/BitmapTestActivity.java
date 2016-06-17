package com.atguigu.l11_graphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

/*
 Bitmap: 加载一张图片数据到内存中, 都可以封装成一个Bitmap对象
	 需求1: 加载资源文件中的图片资源并显示
	 需求2: 加载存储空间中的图片资源并显示
	 需求3: 将一个bitmap对象保存到存储空间中
 */
public class BitmapTestActivity extends Activity {

	private ImageView iv_bitmap1;
	private ImageView iv_bitmap2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitmap);

		iv_bitmap1 = (ImageView) findViewById(R.id.iv_bitmap1);
		iv_bitmap2 = (ImageView) findViewById(R.id.iv_bitmap2);
		
		//需求1: 加载资源文件中的图片资源并显示

		iv_bitmap1.setImageResource(R.drawable.cy15);

		//需求2: 加载存储空间中的图片资源并显示

		Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/cy1.jpg");
		iv_bitmap2.setImageBitmap(bitmap);


	}

	public void saveImage(View v) throws FileNotFoundException {
		//需求3: 将一个bitmap对象保存到存储空间中
		Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/cy1.jpg");
		bitmap.compress(Bitmap.CompressFormat.PNG,100,openFileOutput("abc.jpg", Context.MODE_PRIVATE));
		Toast.makeText(BitmapTestActivity.this, "保存图片成功", Toast.LENGTH_SHORT).show();
		
	}
}
