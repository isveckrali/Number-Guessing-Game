package com.example.flycodeveloper.sayitahminoyunu;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    TextView textViewKalanHak, textViewYardim;
    EditText editTextGirdi;
    Button buttonTahmin;
    Context context = this;
    int rastgeleSayi;
    int sayac = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewKalanHak = findViewById(R.id.txtViewKalanHak);
        textViewYardim = findViewById(R.id.txtViewYardim);
        editTextGirdi = findViewById(R.id.edtTextSayiGir);
        buttonTahmin = findViewById(R.id.btntahmin);

        Random random = new Random();
        rastgeleSayi = random.nextInt(101);
        Log.i("rastgeleSayi: " , String.valueOf(rastgeleSayi));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            sayac = sayac - 1;
            int tahmin = Integer.parseInt(editTextGirdi.getText().toString().trim());
            if (sayac != 0) {

                if (tahmin == rastgeleSayi) {
                    startActivity((new Intent(context, SonucActivity.class)).putExtra("sonuc",true));
                    finish();
                } else if (tahmin > rastgeleSayi) {
                    textViewYardim.setText("Azalt");
                } else if (tahmin < rastgeleSayi) {
                    textViewYardim.setText("Arttır");
                }
                textViewKalanHak.setText("Kalan Hak : " + sayac);


            } else {

                startActivity((new Intent(context, SonucActivity.class)).putExtra("sonuc",false));
                finish();
            }
            editTextGirdi.setText("");

            }
        });

    }
}
