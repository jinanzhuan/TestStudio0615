package com.atguigu.l11_graphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;

/**
 * Drawable 就是一个可画的对象，
	 * 其可能是一张位图（BitmapDrawable），
	 * 也可能是一个图形（ShapeDrawable），
	 * 还有可能是一个图层（LayerDrawable），
	 * 我们根据画图的需求，创建相应的可画对象
 */
public class DrawTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		MyView view=new MyView(this);

		setContentView(view);

	}

	class MyView extends View{
		private ShapeDrawable shapeDrawable;
		private Paint paint;
		public MyView(Context context) {
			super(context);

			shapeDrawable=new ShapeDrawable(new OvalShape());//默认为矩形
			shapeDrawable.getPaint().setColor(Color.LTGRAY);
			shapeDrawable.setBounds(20, 20, 300, 300);

			paint=new Paint();
			paint.setColor(Color.RED);
			paint.setTextSize(25);
			paint.setAntiAlias(true);
			paint.setTypeface(Typeface.DEFAULT_BOLD);

		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.YELLOW);//设置画布的颜色
			shapeDrawable.draw(canvas);//将图形绘制在画布上

			float x=20;
			float y=350;
			canvas.drawText("窈窕淑女，君子好逑",x,y,paint);


		}
	}
}
