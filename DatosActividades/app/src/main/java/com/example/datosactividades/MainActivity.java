package com.example.datosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aSumar(View view) {

        EditText box1 = findViewById(R.id.num1);
        int num1 = Integer.parseInt(box1.getText().toString());
        EditText box2 = findViewById(R.id.num2);
        int num2 = Integer.parseInt(box2.getText().toString());

        Intent i = new Intent(this, Sumar.class);

        /* Contenido del bundle que enviamos al layout Sumar */
        i.putExtra("numero1", num1);
        i.putExtra("numero2", num2);

        startActivity(i);
    }

}