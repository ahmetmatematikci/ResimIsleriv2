package com.ahmetmatematikci.resimisleri;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DilTanimla extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dil_tanimla);

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> aktiviteler = packageManager.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);

        if (aktiviteler.size() == 0) {
            View bilgi = findViewById(R.id.dilyok);
            bilgi.setVisibility(View.VISIBLE);
            View view = findViewById(R.id.ll_diltanima);
            view.setVisibility(View.GONE);


        }

    }
        public void onButtonClick(View view) {

            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Dili Tanımla");
            startActivityForResult(intent,R.id.ll_diltanima);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> liste;
        if (1==1){
            liste = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        } else {
            liste = new ArrayList<String>();
        }
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste));
    }
}

