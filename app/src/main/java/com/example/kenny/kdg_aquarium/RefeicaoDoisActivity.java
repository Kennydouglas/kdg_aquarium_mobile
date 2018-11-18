package com.example.kenny.kdg_aquarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class RefeicaoDoisActivity extends AppCompatActivity {

    public android.widget.EditText ref1;
    public android.widget.EditText ref2;
    public android.widget.Button botao_confirmar_ref2;

    Firebase objetoref_hora_ref1;
    Firebase objetoref_min_ref1;
    Firebase objetoref_hora_ref2;
    Firebase objetoref_min_ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao_dois);

        ref1 = findViewById(R.id.ref1);
        ref2 = findViewById(R.id.ref2);
        botao_confirmar_ref2 = findViewById(R.id.botao_confirmar_ref2);
        objetoref_hora_ref1 = new Firebase("https://nodemcu-gremio.firebaseio.com/hora_ref1");
        objetoref_min_ref1 = new Firebase("https://nodemcu-gremio.firebaseio.com/min_ref1");
        objetoref_hora_ref2 = new Firebase("https://nodemcu-gremio.firebaseio.com/hora_ref2");
        objetoref_min_ref2 = new Firebase("https://nodemcu-gremio.firebaseio.com/min_ref2");


        SimpleMaskFormatter snf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher ntw = new MaskTextWatcher(ref1, snf);
        ref1.addTextChangedListener(ntw);

        SimpleMaskFormatter kkk = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher jjj = new MaskTextWatcher(ref2, kkk);
        ref2.addTextChangedListener(jjj);

        botao_confirmar_ref2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RefeicaoDoisActivity.this, MainActivity.class));
                String texto_setar_ref1 = ref1.getText().toString();

                String texto_inteiro_1 =texto_setar_ref1.substring(0,2);
                int a= Integer.parseInt(texto_inteiro_1);
                objetoref_hora_ref1.setValue(a);

                String texto_inteiro_2 =texto_setar_ref1.substring(3,5);
                int b= Integer.parseInt(texto_inteiro_2);
                objetoref_min_ref1.setValue(b);

                String texto_setar_ref2 = ref2.getText().toString();

                String texto_inteiro_3 =texto_setar_ref2.substring(0,2);
                int c= Integer.parseInt(texto_inteiro_3);
                objetoref_hora_ref2.setValue(c);

                String texto_inteiro_4 =texto_setar_ref2.substring(3,5);
                int d= Integer.parseInt(texto_inteiro_4);
                objetoref_min_ref2.setValue(d);

            }
        });
    }
}
