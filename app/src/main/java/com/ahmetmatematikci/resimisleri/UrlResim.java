package com.ahmetmatematikci.resimisleri;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class UrlResim extends AppCompatActivity {
    ImageView iv;
    Button bt;
    String url = "http://www.resimyukleyin.net/images/2016/02/13/en-iyi-resim-ve-fotograf-format-donusturme-manset_640x360.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);
        bt =(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(UrlResim.this).load(url).into(iv);
            }
        });
    }
}
