package com.example.kenny.kdg_aquarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class TempActivity extends AppCompatActivity {

    public  android.widget.EditText setar_temperatura;
    public  android.widget.Button botao_confirmar_temp;

    Firebase objetoref_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        setar_temperatura = findViewById(R.id.setar_temperatura);
        botao_confirmar_temp = findViewById(R.id.botao_confirmar_temp);
        Firebase.setAndroidContext(this);
        objetoref_temp = new Firebase("https://nodemcu-gremio.firebaseio.com/temperatura_desejada");





        SimpleMaskFormatter snf = new SimpleMaskFormatter("NN");
        MaskTextWatcher ntw = new MaskTextWatcher(setar_temperatura, snf);
        setar_temperatura.addTextChangedListener(ntw);



        botao_confirmar_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TempActivity.this, MainActivity.class));
               // objetoref_temp.child ("temperatura_desejada").setValue(setar_temperatura);
                String texto_setar_temperatura = setar_temperatura.getText().toString();
                int i = Integer.parseInt(setar_temperatura.getText().toString());
                objetoref_temp.setValue(i);
            }
        });

    }
}
