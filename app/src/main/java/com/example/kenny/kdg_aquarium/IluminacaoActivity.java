package com.example.kenny.kdg_aquarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class IluminacaoActivity extends AppCompatActivity {

    public  android.widget.EditText acionamento_luz;
    public  android.widget.EditText inativacao_luz;
    public  android.widget.Button botao_confirmar_luz;

    Firebase objetoref_hora_light_on;
    Firebase objetoref_min_light_on;
    Firebase objetoref_hora_light_off;
    Firebase objetoref_min_light_off;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao);

        acionamento_luz = findViewById(R.id.acionamento_luz);
        inativacao_luz = findViewById(R.id.inativacao_luz);
        botao_confirmar_luz = findViewById(R.id.botao_confirmar_luz);
        Firebase.setAndroidContext(this);
        objetoref_hora_light_on = new Firebase("https://nodemcu-gremio.firebaseio.com/hora_light_on");
        objetoref_min_light_on = new Firebase("https://nodemcu-gremio.firebaseio.com/min_light_on");
        objetoref_hora_light_off = new Firebase("https://nodemcu-gremio.firebaseio.com/hora_light_off");
        objetoref_min_light_off = new Firebase("https://nodemcu-gremio.firebaseio.com/min_light_off");

        SimpleMaskFormatter snf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher ntw = new MaskTextWatcher(acionamento_luz, snf);
        acionamento_luz.addTextChangedListener(ntw);

        SimpleMaskFormatter kty = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher jjj = new MaskTextWatcher(inativacao_luz, kty);
        inativacao_luz.addTextChangedListener(jjj);

        botao_confirmar_luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IluminacaoActivity.this, MainActivity.class));
                String texto_setar_light_on = acionamento_luz.getText().toString();

                String texto_inteiro_1 =texto_setar_light_on.substring(0,2);
                int a= Integer.parseInt(texto_inteiro_1);
                objetoref_hora_light_on.setValue(a);

                String texto_inteiro_2 =texto_setar_light_on.substring(3,5);
                int b= Integer.parseInt(texto_inteiro_2);
                objetoref_min_light_on.setValue(b);


                String texto_setar_light_off = inativacao_luz.getText().toString();

                String texto_inteiro_3 =texto_setar_light_off.substring(0,2);
                int c= Integer.parseInt(texto_inteiro_3);
                objetoref_hora_light_off.setValue(c);

                String texto_inteiro_4 =texto_setar_light_off.substring(3,5);
                int d= Integer.parseInt(texto_inteiro_4);
                objetoref_hora_light_off.setValue(d);

            }
        });

    }
}
