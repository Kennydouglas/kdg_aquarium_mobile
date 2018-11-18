package com.example.kenny.kdg_aquarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class RefeicaoUmActivity extends AppCompatActivity {

    public  android.widget.EditText ref1;
    public  android.widget.Button botao_confirmar_ref1;

    Firebase objetoref_hora_ref1;
    Firebase objetoref_min_ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao_um);

        ref1 = findViewById(R.id.ref1);
        botao_confirmar_ref1 = findViewById(R.id.botao_confirmar_ref1);
        Firebase.setAndroidContext(this);
        objetoref_hora_ref1 = new Firebase("https://nodemcu-gremio.firebaseio.com/hora_ref1");
        objetoref_min_ref1 = new Firebase("https://nodemcu-gremio.firebaseio.com/min_ref1");

        SimpleMaskFormatter snf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher ntw = new MaskTextWatcher(ref1, snf);
        ref1.addTextChangedListener(ntw);

        botao_confirmar_ref1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RefeicaoUmActivity.this, MainActivity.class));
                String texto_ref1 = ref1.getText().toString();

                String texto_inteiro =texto_ref1.substring(0,2);
                int a= Integer.parseInt(texto_inteiro);
                objetoref_hora_ref1.setValue(a);

                String texto_inteiro_dois =texto_ref1.substring(3,5);
                int b= Integer.parseInt(texto_inteiro_dois);
                objetoref_min_ref1.setValue(b);


            }
        });

    }
}
