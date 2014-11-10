package tutBereket.net;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
	LinearLayout layout;
	ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       LinearLayout ln =(LinearLayout)findViewById(R.id.viewDrawing);
       im=(ImageView)findViewById(R.id.im);
       
       ln.addView(new NfcCircle(this));
        
    }

	public void disappear(View view){
    	
    	im.setVisibility(View.GONE);
    	layout.setVisibility(View.GONE);
    }
    
    private class NfcCircle  extends View {
    	Paint paint;
		public NfcCircle(Context context) {
			super(context);
			paint= new Paint();
			paint.setColor(Color.RED);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
		
			canvas.drawCircle(getWidth()/2, getHeight()/5, getWidth()/5, paint);
			
			
		}
    	
    }
    
  
}
