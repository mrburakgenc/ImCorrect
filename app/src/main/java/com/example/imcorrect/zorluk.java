package com.example.imcorrect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class zorluk extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = (!zorluk.class.desiredAssertionStatus());
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_zorluk);
        final Intent Easy = new Intent(this, kolay.class);
        final Intent Hard = new Intent(this, zor.class);
        ImageButton Kolay = (ImageButton) findViewById(R.id.easy);
        if ($assertionsDisabled || Kolay != null) {
            Kolay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    zorluk.this.startActivity(Easy);
                }
            });
            ImageButton Zor = (ImageButton) findViewById(R.id.hard);
            if ($assertionsDisabled || Zor != null) {
                Zor.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        zorluk.this.startActivity(Hard);
                    }
                });
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
    }
