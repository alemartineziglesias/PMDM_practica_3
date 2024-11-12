package com.example.myzodiac;

import android.os.Bundle;
import android.widget.ImageView;
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
        ImageView imageview = findViewById(R.id.imageView);
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
        if(signo.equals(getString(R.string.aries)))
        {
            imageview.setImageResource(R.drawable.aries);
        }
        else if(signo.equals(getString(R.string.tauro)))
        {
            imageview.setImageResource(R.drawable.tauro);
        }
        else if(signo.equals(getString(R.string.geminis)))
        {
            imageview.setImageResource(R.drawable.geminis);
        }
        else if(signo.equals(getString(R.string.cancer)))
        {
            imageview.setImageResource(R.drawable.cancer);
        }
        else if(signo.equals(getString(R.string.leo)))
        {
            imageview.setImageResource(R.drawable.leo);
        }
        else if(signo.equals(getString(R.string.virgo)))
        {
            imageview.setImageResource(R.drawable.virgo);
        }
        else if(signo.equals(getString(R.string.libra)))
        {
            imageview.setImageResource(R.drawable.libra);
        }
        else if(signo.equals(getString(R.string.escorpio)))
        {
            imageview.setImageResource(R.drawable.escorpio);
        }
        else if(signo.equals(getString(R.string.sagitario)))
        {
            imageview.setImageResource(R.drawable.sagitario);
        }
        else if(signo.equals(getString(R.string.capricornio)))
        {
            imageview.setImageResource(R.drawable.capricornio);
        }
        else if(signo.equals(getString(R.string.acuario)))
        {
            imageview.setImageResource(R.drawable.acuario);
        }
        else
        {
            imageview.setImageResource(R.drawable.piscis);
        }
    }
}