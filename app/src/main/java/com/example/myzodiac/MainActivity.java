package com.example.myzodiac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    CalendarView calendario;
    TextView fecha;
    Button aceptar;
    String fechaElegida;
    Calendar calendar;
    SimpleDateFormat dateFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        calendario = findViewById(R.id.calendarView);
        fecha = findViewById(R.id.textViewFecha);
        aceptar = findViewById(R.id.buttonAceptar);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        fechaElegida = dateFormat.format(calendar.getTime());
        fecha.setText(fechaElegida);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int anio, int mes, int dia)
            {
                fechaElegida = dia + "/" + (mes + 1) + "/" + anio;
                fecha.setText(fechaElegida);
            }
        });
        aceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, ActivityZodiaco.class);
        String[] fechaCortada = fechaElegida.split("/");
        int dia = Integer.parseInt(fechaCortada[0]);
        int mes = Integer.parseInt(fechaCortada[1]);
        int anio = Integer.parseInt(fechaCortada[2]);
        String fechaActual = dateFormat.format(calendar.getTime());
        String[] fechaActualCortada = fechaActual.split("/");
        int diaActual = Integer.parseInt(fechaActualCortada[0]);
        int mesActual = Integer.parseInt(fechaActualCortada[1]);
        int anioActual = Integer.parseInt(fechaActualCortada[2]);
        int edad = anioActual - anio;
        if(diaActual < dia && mesActual == mes || diaActual >= dia && mesActual < mes || diaActual < dia && mesActual < mes)
        {
            edad = edad - 1;
        }
        if(edad < 0)
        {
            String stringError = getString(R.string.error);
            fecha.setText(stringError);
        }
        else
        {
            intent.putExtra("edad", edad);
            if(dia >= 21 && mes == 3 || dia <= 19 && mes == 4)
            {
                intent.putExtra("signo", getString(R.string.aries));
            }
            else if(dia >= 20 && mes == 4 || dia <= 20 && mes == 5)
            {
                intent.putExtra("signo", getString(R.string.tauro));
            }
            else if(dia >= 21 && mes == 5 || dia <= 20 && mes == 6)
            {
                intent.putExtra("signo", getString(R.string.geminis));
            }
            else if(dia >= 23 && mes == 6 || dia <= 22 && mes == 7)
            {
                intent.putExtra("signo", getString(R.string.cancer));
            }
            else if(dia >= 23 && mes == 7 || dia <= 22 && mes == 8)
            {
                intent.putExtra("signo", getString(R.string.leo));
            }
            else if(dia >= 23 && mes == 8 || dia <= 22 && mes == 9)
            {
                intent.putExtra("signo", getString(R.string.virgo));
            }
            else if(dia >= 23 && mes == 9 || dia <= 22 && mes == 10)
            {
                intent.putExtra("signo", getString(R.string.libra));
            }
            else if(dia >= 23 && mes == 10 || dia <= 21 && mes == 11)
            {
                intent.putExtra("signo", getString(R.string.escorpio));
            }
            else if(dia >= 22 && mes == 11 || dia <= 21 && mes == 12)
            {
                intent.putExtra("signo", getString(R.string.sagitario));
            }
            else if(dia >= 22 && mes == 12 || dia <= 19 && mes == 1)
            {
                intent.putExtra("signo", getString(R.string.capricornio));
            }
            else if(dia >= 20 && mes == 1 || dia <= 18 && mes == 2)
            {
                intent.putExtra("signo", getString(R.string.acuario));
            }
            else
            {
                intent.putExtra("signo", getString(R.string.piscis));
            }
            startActivity(intent);
        }
    }
}