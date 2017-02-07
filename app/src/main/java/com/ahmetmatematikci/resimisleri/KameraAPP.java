package com.ahmetmatematikci.resimisleri;

import android.app.Activity;
import android.app.ListActivity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by a on 1/18/17.
 */

public class KameraAPP  extends Activity implements View.OnClickListener{
    Button bt1, bt2;
    ImageView iv;
     int gondermeKodu;
    Bitmap bmp;

    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_kamera_app);

        tanimlar();

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    private void tanimlar() {

        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);
        iv = (ImageView)findViewById(R.id.imageView);



    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.button:

                Intent inte = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(inte, gondermeKodu);
                break;

            case R.id.button2:

                WallpaperManager wallpaper = WallpaperManager.getInstance(this);
                try {
                    wallpaper.setBitmap(bmp);
                    Toast.makeText(this,"Duvar kağıdı değiştirildi",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK) {
            Bundle abc = data.getExtras();
            bmp = (Bitmap) abc.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}