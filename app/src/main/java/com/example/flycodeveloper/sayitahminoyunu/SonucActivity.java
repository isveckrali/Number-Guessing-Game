package com.example.flycodeveloper.sayitahminoyunu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

     ImageView imageViewSonuc;
    TextView textViewSonuc;
    Button buttonTekrar;
    Context context = this;
    boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        imageViewSonuc  = findViewById(R.id.imgViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.btnTekrar);

        sonuc = getIntent().getBooleanExtra("sonuc",false);
        if (sonuc) {
            imageViewSonuc.setImageResource(R.drawable.mood_resim);
            textViewSonuc.setText("Kazandınız");
        } else {
            imageViewSonuc.setImageResource(R.drawable.dissatisfield_resim);
            textViewSonuc.setText("Kaybettiniz");
            textViewSonuc.setTextColor(Color.BLACK);
        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(context,TahminActivity.class));
            finish();
            }
        });
    }
}
