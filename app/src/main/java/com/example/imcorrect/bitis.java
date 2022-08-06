package com.example.imcorrect;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;

public class bitis extends AppCompatActivity {
    SharedPreferences preferences;
    int skorVerisi;
    TextView tv;
    int yskorVerisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_bitis);
        Typeface yazistilim = Typeface.createFromAsset(getAssets(), "show.ttf");
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.tv = (TextView) findViewById(R.id.skorgoster);
        this.yskorVerisi = preferences2.getInt("yskor_anahtari", -1);
        this.skorVerisi = preferences2.getInt("skor_anahtari", -1);
        this.tv.setText("High Score \t\t\t\t\t\t\t\t\tYour Score \n \t\t\t\t\t" + Integer.toString(this.yskorVerisi) + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Integer.toString(this.skorVerisi));
        this.tv.setTypeface(yazistilim);
        final Intent start = new Intent(this, zorluk.class);
        ((ImageButton) findViewById(R.id.imageButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bitis.this.startActivity(start);
            }
        });
    }

    public void onBackPressed() {
    }
}
