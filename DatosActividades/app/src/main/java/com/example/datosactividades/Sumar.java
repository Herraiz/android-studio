package com.example.datosactividades;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Sumar extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        /* Almacenamos los datos del Bundle */
        Bundle data = getIntent().getExtras(); // esto se ejecuta sobre la activity

        int num1 = data.getInt("numero1");
        int num2 = data.getInt("numero2");
        int result = num1 + num2;

        TextView resultText = findViewById(R.id.textoResultado);
        resultText.setText("El resultado es " + result);
    }
}
