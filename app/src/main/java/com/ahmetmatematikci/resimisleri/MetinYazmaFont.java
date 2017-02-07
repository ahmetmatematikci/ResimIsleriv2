package com.ahmetmatematikci.resimisleri;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MetinYazmaFont extends AppCompatActivity {


    class RendereView extends View{
        Paint paint;
        Typeface fonttipi;
        Rect bounds = new Rect();

        public RendereView(Context context) {
            super(context);
            paint = new Paint();
            fonttipi = Typeface.createFromAsset(context.getAssets(), "Pacifico.ttf");
        }

        protected void onDraw(Canvas canvas) {
            paint.setColor(Color.RED);
            paint.setTypeface(fonttipi);
            paint.setTextSize(120);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Ahmet KILIÇ", canvas.getWidth()/2,250,paint);

            String text = "ADANA";
            paint.setColor(Color.GREEN);
            paint.setTextSize(50);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(text, 0,text.length(), bounds);
            canvas.drawText(text, canvas.getWidth()-bounds.width(),640, paint);
            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RendereView(this));
    }
}
