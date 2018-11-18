package com.example.kenny.kdg_aquarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class FoodActivity extends AppCompatActivity {

    public static android.widget.EditText quantidade_refeicao;
    public static android.widget.Button botao_confirmar_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        quantidade_refeicao = findViewById(R.id.quantidade_refeicao);
        botao_confirmar_food = findViewById(R.id.botao_confirmar_food);

        botao_confirmar_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto_quantidade_refeicao = quantidade_refeicao.getText().toString();



                Double valor_quantidade = Double.parseDouble(texto_quantidade_refeicao);

                if (valor_quantidade==1){
                    startActivity(new Intent(FoodActivity.this, RefeicaoUmActivity.class));
                }
                if (valor_quantidade==2){
                    startActivity(new Intent(FoodActivity.this, RefeicaoDoisActivity.class));
                }
                if (valor_quantidade==3){
                    startActivity(new Intent(FoodActivity.this, RefeicaoTresActivity.class));
                }


            }
        });
    }
}
