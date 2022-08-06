package com.example.imcorrect;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

import java.util.Random;

public class kolay extends AppCompatActivity {
    private Bundle extras = null;
    double kartis = 1.0d;
    Handler kh = new Handler();
    int khak = 1;
    TextView khaktabela;
    ImageView kok;
    ImageButton kolaysag;
    ImageButton kolaysol;
    int kontrol = 1;
    int kpS = 0;
    ProgressBar kpb;
    Random kr = new Random();
    int ksayac = 1;
    int kskor = 0;
    TextView kskortabela;
    int ktip = 0;
    int kzaman = 40;
    SharedPreferences preferences;
    int tmp;
    int yuksekskorVerisi;
    public void onPause() {
        this.yuksekskorVerisi = this.preferences.getInt("yskor_anahtari", -1);
        if (this.yuksekskorVerisi == -1) {
            SharedPreferences.Editor editor = this.preferences.edit();
            editor.putInt("skor_anahtari", this.kskor);
            editor.putInt("yskor_anahtari", this.kskor);
            editor.commit();
        } else if (this.yuksekskorVerisi < this.kskor) {
            SharedPreferences.Editor editor2 = this.preferences.edit();
            editor2.putInt("skor_anahtari", this.kskor);
            editor2.putInt("yskor_anahtari", this.kskor);
            editor2.commit();
        } else {
            SharedPreferences.Editor editor3 = this.preferences.edit();
            editor3.putInt("skor_anahtari", this.kskor);
            editor3.commit();
        }
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_kolay);
        this.preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final Typeface kyazistilim = Typeface.createFromAsset(getAssets(), "show.ttf");
        this.kpb = (ProgressBar) findViewById(R.id.progressBar);
        this.kok = (ImageView) findViewById(R.id.ok);
        this.kolaysol = (ImageButton) findViewById(R.id.kolaysol);
        this.kolaysag = (ImageButton) findViewById(R.id.kolaysag);
        this.kskortabela = (TextView) findViewById(R.id.skortabelasi);
        this.khaktabela = (TextView) findViewById(R.id.kolayhak);
        final Intent test = new Intent(this, bitis.class);
        this.kpS = 0;
        new Thread(new Runnable() {
            public void run() {
                kolay.this.oklar();
                kolay.this.kolaysol.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (kolay.this.ktip == 0 || kolay.this.ktip == 2 || kolay.this.ktip == 3 || kolay.this.ktip == 7) {
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.kskor++;
                            kolay.this.kskortabela.setText(Integer.toString(kolay.this.kskor));
                            kolay.this.kskortabela.setTypeface(kyazistilim);
                        } else if (kolay.this.ktip == 8) {
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.kskor++;
                            kolay.this.kskortabela.setText(Integer.toString(kolay.this.kskor));
                            kolay.this.kskortabela.setTypeface(kyazistilim);
                            kolay.this.khak++;
                            kolay.this.khaktabela.setText("Remaining Life :" + Integer.toString(kolay.this.khak));
                            kolay.this.khaktabela.setTypeface(kyazistilim);
                        } else if (kolay.this.ktip == 8 || kolay.this.ktip == 9) {
                            kolay.this.oklar();
                            kolay.this.derece();
                        } else if (kolay.this.khak != 0) {
                            kolay kolay = kolay.this;
                            kolay.khak--;
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.khaktabela.setText("Remaining Life :" + Integer.toString(kolay.this.khak));
                            kolay.this.khaktabela.setTypeface(kyazistilim);
                        } else {
                            kolay.this.kpS = 100;
                        }
                    }
                });
                kolay.this.kolaysag.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (kolay.this.ktip == 1 || kolay.this.ktip == 5 || kolay.this.ktip == 6 || kolay.this.ktip == 4) {
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.kskor++;
                            kolay.this.kskortabela.setText(Integer.toString(kolay.this.kskor));
                            kolay.this.kskortabela.setTypeface(kyazistilim);
                        } else if (kolay.this.ktip == 9) {
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.kskor++;
                            kolay.this.kskortabela.setText(Integer.toString(kolay.this.kskor));
                            kolay.this.kskortabela.setTypeface(kyazistilim);
                            kolay.this.khak++;
                            kolay.this.khaktabela.setText("Remaining Life :" + Integer.toString(kolay.this.khak));
                            kolay.this.khaktabela.setTypeface(kyazistilim);
                        } else if (kolay.this.ktip == 8 || kolay.this.ktip == 9) {
                            kolay.this.oklar();
                            kolay.this.derece();
                        } else if (kolay.this.khak != 0) {
                            kolay kolay = kolay.this;
                            kolay.khak--;
                            kolay.this.oklar();
                            kolay.this.derece();
                            kolay.this.khaktabela.setText("Remaining Life :" + Integer.toString(kolay.this.khak));
                            kolay.this.khaktabela.setTypeface(kyazistilim);
                        } else {
                            kolay.this.kpS = 100;
                        }
                    }
                });
                while (kolay.this.kpS < 100) {
                    kolay kolay = kolay.this;
                    kolay.kpS = (int) (((double) kolay.kpS) + kolay.this.kartis);
                    kolay.this.kh.post(new Runnable() {
                        public void run() {
                            kolay.this.kpb.setProgress(kolay.this.kpS);
                        }
                    });
                    try {
                        Thread.sleep((long) kolay.this.kzaman);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                kolay.this.startActivity(test);
            }
        }).start();
    }
    public void oklar() {
        this.ktip = this.kr.nextInt(10);
        if (this.ktip == 0) {
            this.kok.setImageResource(R.drawable.yesilbos);
            this.kpS = 0;
        } else if (this.ktip == 1) {
            this.kok.setImageResource(R.drawable.siyahbos);
            this.kpS = 0;
        } else if (this.ktip == 2) {
            this.kok.setImageResource(R.drawable.yesilsol);
            this.kpS = 0;
        } else if (this.ktip == 3) {
            this.kok.setImageResource(R.drawable.siyahsol);
            this.kpS = 0;
        } else if (this.ktip == 4) {
            this.kok.setImageResource(R.drawable.yesilsag);
            this.kpS = 0;
        } else if (this.ktip == 5) {
            this.kok.setImageResource(R.drawable.siyahsag);
            this.kpS = 0;
        } else if (this.ktip == 6) {
            this.kok.setImageResource(R.drawable.yesilbasma);
            this.kpS = 0;
        } else if (this.ktip == 7) {
            this.kok.setImageResource(R.drawable.siyahbasma);
            this.kpS = 0;
        } else if (this.ktip == 8) {
            this.kok.setImageResource(R.drawable.siyahsoru);
            this.kpS = 0;
        } else if (this.ktip == 9) {
            this.kok.setImageResource(R.drawable.yesilsoru);
            this.kpS = 0;
        }
    }

    public void onBackPressed() {
    }

    public void derece() {
        if (this.kskor >= 20) {
            this.kzaman--;
        } else if (this.kskor >= 30) {
            this.kzaman = 16;
        } else if (this.kskor >= 40) {
            this.kzaman = 12;
        } else if (this.kskor >= 50) {
            this.kzaman = 10;
        } else if (this.kskor >= 60) {
            this.kzaman = 8;
        } else if (this.kskor >= 70) {
            this.kzaman = 6;
        } else if (this.kskor >= 100) {
            this.kzaman = 4;
        } else {
            this.kzaman = 40;
        }
    }
}
