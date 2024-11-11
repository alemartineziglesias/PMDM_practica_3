package com.example.myzodiac;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityZodiaco extends AppCompatActivity
{
    TextView resultadosEdad;
    TextView resultadosZodiaco;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zodiaco);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultadosEdad = findViewById(R.id.textViewEdad);
        resultadosZodiaco = findViewById(R.id.textViewZodiaco);
        Bundle extras = getIntent().getExtras();
        int edad = extras.getInt("edad");
        String signo = extras.getString("signo");
        if(edad == 1)
        {
            String stringEdad = getString(R.string.resultados_edad) + " " + edad + " " + getString(R.string.fin_edad_alterno);
            resultadosEdad.setText(stringEdad);
        }
        else
        {
            String stringEdad = getString(R.string.resultados_edad) + " " + edad + " " + getString(R.string.fin_edad);
            resultadosEdad.setText(stringEdad);
        }
        String stringZodiaco = getString(R.string.resultados_zodiaco) + " " + signo;
        resultadosZodiaco.setText(stringZodiaco);
    }
}