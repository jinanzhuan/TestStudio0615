package com.atguigu.l11_graphics;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/*
	Matrix ，中文里叫矩阵，高等数学里有介绍，在图像处理方面，主要是用于平面的缩放、平移、旋转等操作
	
 */
public class MatrixTestActivity extends Activity {

	private EditText et_matrix_scale;
	private EditText et_matrix_rotate;
	private EditText et_matrix_translateX;
	private EditText et_matrix_translateY;
	
	private ImageView iv_matrix_icon;
	private Matrix matrix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_matrix);

		et_matrix_scale = (EditText) findViewById(R.id.et_matrix_scale);
		et_matrix_rotate = (EditText) findViewById(R.id.et_matrix_rotate);
		et_matrix_translateX = (EditText) findViewById(R.id.et_matrix_translateX);
		et_matrix_translateY = (EditText) findViewById(R.id.et_matrix_translateY);

		iv_matrix_icon = (ImageView) findViewById(R.id.iv_matrix_icon);
		Matrix matrix=new Matrix();

	}

	public void scaleBitmap(View view) {
		if(matrix==null){
			matrix=new Matrix();
		}
		float scaleFloat = Float.parseFloat(et_matrix_scale.getText().toString());
		matrix.postScale(scaleFloat,scaleFloat);
		iv_matrix_icon.setImageMatrix(matrix);
	}

	public void rotateBitmap(View view) {
		if(matrix==null){
			matrix=new Matrix();
		}
		float rotateFloat = Float.parseFloat(et_matrix_rotate.getText().toString());
/*		float x=iv_matrix_icon.getHeight()/2;
		float y=iv_matrix_icon.getWidth()/2;*/
		matrix.postRotate(rotateFloat);
		iv_matrix_icon.setImageMatrix(matrix);
		
	}

	public void translateBitmap(View view) {
		if(matrix==null){
			matrix=new Matrix();
		}
		float x = Float.parseFloat(et_matrix_translateX.getText().toString());
		float y = Float.parseFloat(et_matrix_translateY.getText().toString());
		matrix.postTranslate(x,y);
		iv_matrix_icon.setImageMatrix(matrix);
	}

	public void clearMatrix(View view) {
		if(matrix!=null){
			matrix.reset();
		}
		iv_matrix_icon.setImageMatrix(matrix);
		
	}
}
