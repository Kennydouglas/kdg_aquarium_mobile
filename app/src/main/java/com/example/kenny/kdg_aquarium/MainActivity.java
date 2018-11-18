package com.example.kenny.kdg_aquarium;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.kenny.kdg_aquarium.R.id.temp_Id;

public class MainActivity extends AppCompatActivity {

    public  android.widget.ImageButton temp_botao_id;
    public  android.widget.ImageButton lamp_botao_id;
    public  android.widget.ImageButton grafico_botao_id;
    public  android.widget.ImageButton food_botao_id;
    public  android.widget.TextView temp_id;

    //private DatabaseReference objetoref = FirebaseDatabase.getInstance().getReference();
    Firebase objetoref;
    Firebase novaref;

    View view;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp_botao_id = findViewById(R.id.temp_botao_id);
        lamp_botao_id = findViewById(R.id.lamp_botao_id);
        grafico_botao_id = findViewById(R.id.grafico_botao_id);
        food_botao_id = findViewById(R.id.food_botao_id);
        temp_id = findViewById(temp_Id);
        Firebase.setAndroidContext(this);

        temp_botao_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TempActivity.class));
            }
        });

        lamp_botao_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IluminacaoActivity.class));
            }
        });

        objetoref = new Firebase("https://nodemcu-gremio.firebaseio.com/");
        novaref = objetoref.child("temperatura");

        novaref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensagem = dataSnapshot.getValue(String.class);
                temp_id.setText(mensagem);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        food_botao_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FoodActivity.class));
            }
        });



        //objetoref.child ("pontos").setValue("1000");



    }
}
