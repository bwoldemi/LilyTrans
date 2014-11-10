package lily.homecare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.ViewGroup;

public class NfCImageView extends ViewGroup {
	Paint paint;

	public NfCImageView(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.RED);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth(), paint);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
	}
}


