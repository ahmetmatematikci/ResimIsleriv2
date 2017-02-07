package com.ahmetmatematikci.resimisleri;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class giris extends ListActivity {

    String[] sayfalar = {"UrlResim","MetinYazmaFont", "DilTanimla"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_giris);

        setListAdapter(new ArrayAdapter<String>(giris.this, android.R.layout.simple_list_item_1, sayfalar));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String sayfa = sayfalar[position];
        Class gis;

        try {
            gis = Class.forName("com.ahmetmatematikci.resimisleri." + sayfa);
            Intent i = new Intent(giris.this, gis);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
