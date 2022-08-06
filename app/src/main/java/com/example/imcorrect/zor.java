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
import android.os.Bundle;

public class zor extends AppCompatActivity {
    SharedPreferences preferences;
    double uartis = 1.0d;
    Handler uh = new Handler();
    int uhak = 1;
    TextView uhaktabela;
    ImageView uok;
    int uontrol = 1;
    int upS = 0;
    ProgressBar upb;
    Random ur = new Random();
    int usayac = 1;
    int uskor = 0;
    TextView uskortabela;
    int utip = 0;
    int uzaman = 40;
    ImageButton uzmansag;
    ImageButton uzmansol;
    int yuksekskorVerisi;
    public void onPause() {
        this.yuksekskorVerisi = this.preferences.getInt("uskor_anahtari", -1);
        if (this.yuksekskorVerisi == -1) {
            SharedPreferences.Editor editor = this.preferences.edit();
            editor.putInt("skor_anahtari", this.uskor);
            editor.putInt("uskor_anahtari", this.uskor);
            editor.commit();
        } else if (this.yuksekskorVerisi < this.uskor) {
            SharedPreferences.Editor editor2 = this.preferences.edit();
            editor2.putInt("skor_anahtari", this.uskor);
            editor2.putInt("uskor_anahtari", this.uskor);
            editor2.commit();
        } else {
            SharedPreferences.Editor editor3 = this.preferences.edit();
            editor3.putInt("skor_anahtari", this.uskor);
            editor3.commit();
        }
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.activity_zor);
            this.preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            this.upb = (ProgressBar) findViewById(R.id.zprogressBar);
            this.uok = (ImageView) findViewById(R.id.zok);
            this.uzmansol = (ImageButton) findViewById(R.id.zorsol);
            this.uzmansag = (ImageButton) findViewById(R.id.zorsag);
            this.uskortabela = (TextView) findViewById(R.id.uskortabelasi);
            this.uhaktabela = (TextView) findViewById(R.id.uzmanhak);
            final Typeface uyazistilim = Typeface.createFromAsset(getAssets(), "show.ttf");
            final Intent utest = new Intent(this, zorbitis.class);
            this.upS = 0;
            new Thread(new Runnable() {
                public void run() {
                    zor.this.uoklar();
                    zor.this.uzmansol.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (zor.this.utip == 0 || zor.this.utip == 2 || zor.this.utip == 3 || zor.this.utip == 7) {
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uskor++;
                                zor.this.uskortabela.setText(Integer.toString(zor.this.uskor));
                                zor.this.uskortabela.setTypeface(uyazistilim);
                            } else if (zor.this.utip == 8) {
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uskor++;
                                zor.this.uskortabela.setText(Integer.toString(zor.this.uskor));
                                zor.this.uskortabela.setTypeface(uyazistilim);
                                zor.this.uhak++;
                                zor.this.uhaktabela.setText("Remaining Life :" + Integer.toString(zor.this.uhak));
                                zor.this.uhaktabela.setTypeface(uyazistilim);
                            } else if (zor.this.utip == 8 || zor.this.utip == 9) {
                                zor.this.uoklar();
                                zor.this.uderece();
                            } else if (zor.this.uhak != 0) {
                                zor zor = zor.this;
                                zor.uhak--;
                                zor.this.uoklar();
                                zor.this.uderece();
                            } else if (zor.this.utip == 8 || zor.this.utip == 9) {
                                zor.this.uoklar();
                                zor.this.uderece();
                            } else if (zor.this.uhak != 0) {
                                zor zor2 = zor.this;
                                zor2.uhak--;
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uhaktabela.setText("Remaining Life :" + Integer.toString(zor.this.uhak));
                                zor.this.uhaktabela.setTypeface(uyazistilim);
                            } else {
                                zor.this.upS = 100;
                            }
                        }
                    });
                    zor.this.uzmansag.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (zor.this.utip == 1 || zor.this.utip == 5 || zor.this.utip == 6 || zor.this.utip == 4) {
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uskor++;
                                zor.this.uskortabela.setText(Integer.toString(zor.this.uskor));
                                zor.this.uskortabela.setTypeface(uyazistilim);
                            } else if (zor.this.utip == 9) {
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uskor++;
                                zor.this.uskortabela.setText(Integer.toString(zor.this.uskor));
                                zor.this.uskortabela.setTypeface(uyazistilim);
                                zor.this.uhak++;
                                zor.this.uhaktabela.setText("Remaining Life :" + Integer.toString(zor.this.uhak));
                                zor.this.uhaktabela.setTypeface(uyazistilim);
                            } else if (zor.this.utip == 8 || zor.this.utip == 9) {
                                zor.this.uoklar();
                                zor.this.uderece();
                            } else if (zor.this.uhak != 0) {
                                zor zor = zor.this;
                                zor.uhak--;
                                zor.this.uoklar();
                                zor.this.uderece();
                                zor.this.uhaktabela.setText("Remaining Life :" + Integer.toString(zor.this.uhak));
                                zor.this.uhaktabela.setTypeface(uyazistilim);
                            } else {
                                zor.this.upS = 100;
                            }
                        }
                    });
                    while (zor.this.upS < 100) {
                        zor zor = zor.this;
                        zor.upS = (int) (((double) zor.upS) + zor.this.uartis);
                        zor.this.uh.post(new Runnable() {
                            public void run() {
                                zor.this.upb.setProgress(zor.this.upS);
                            }
                        });
                        try {
                            Thread.sleep((long) zor.this.uzaman);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    zor.this.startActivity(utest);
                }
            }).start();
        }

        public void uoklar() {
            this.utip = this.ur.nextInt(9);
            if (this.utip == 0) {
                this.uok.setImageResource(R.drawable.bosgri);
                this.upS = 0;
            } else if (this.utip == 1) {
                this.uok.setImageResource(R.drawable.siyahbos);
                this.upS = 0;
            } else if (this.utip == 2) {
                this.uok.setImageResource(R.drawable.grisol);
                this.upS = 0;
            } else if (this.utip == 3) {
                this.uok.setImageResource(R.drawable.siyahsol);
                this.upS = 0;
            } else if (this.utip == 4) {
                this.uok.setImageResource(R.drawable.grisagok);
                this.upS = 0;
            } else if (this.utip == 5) {
                this.uok.setImageResource(R.drawable.siyahsag);
                this.upS = 0;
            } else if (this.utip == 6) {
                this.uok.setImageResource(R.drawable.gribasma);
                this.upS = 0;
            } else if (this.utip == 7) {
                this.uok.setImageResource(R.drawable.siyahbasma);
                this.upS = 0;
            } else if (this.utip == 8) {
                this.uok.setImageResource(R.drawable.soru);
                this.upS = 0;
            } else if (this.utip == 9) {
                this.uok.setImageResource(R.drawable.soru);
                this.upS = 0;
            }
        }

        public void onBackPressed() {
        }

        public void uderece() {
            if (this.uskor >= 10) {
                this.uzaman -= 2;
            } else if (this.uskor >= 20) {
                this.uzaman = 16;
            } else if (this.uskor >= 40) {
                this.uzaman = 12;
            } else if (this.uskor >= 50) {
                this.uzaman = 10;
            } else if (this.uskor >= 60) {
                this.uzaman = 8;
            } else if (this.uskor >= 70) {
                this.uzaman = 6;
            } else if (this.uskor >= 100) {
                this.uzaman = 4;
            } else {
                this.uzaman = 40;
            }
        }
    }