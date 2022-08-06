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

public class zorbitis extends AppCompatActivity {
    int skorVerisi;
    int uskorVerisi;
    TextView utv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_zorbitis);
        Typeface yazistilim = Typeface.createFromAsset(getAssets(), "show.ttf");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.utv = (TextView) findViewById(R.id.uskorgoster);
        this.uskorVerisi = preferences.getInt("uskor_anahtari", -1);
        this.skorVerisi = preferences.getInt("skor_anahtari", -1);
        this.utv.setText("High Score \t\t\t\t\t\t\t\t\tYour Score \n \t\t\t\t\t" + Integer.toString(this.uskorVerisi) + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Integer.toString(this.skorVerisi));
        this.utv.setTypeface(yazistilim);
        final Intent start = new Intent(this, zorluk.class);
        ((ImageButton) findViewById(R.id.zorbasla)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                zorbitis.this.startActivity(start);
            }
        });
    }
}
