package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class actividadSegundo extends AppCompatActivity {

    private TextInputLayout tilBuscar;
    private ListView ltvnombres;
    private Button btnFiltrar;

    private ArrayAdapter<Tarea> adaptadorTareaLista;

    private ArrayList<Tarea> losTareaLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_segundo);

        referencia();
        eventos();

        // recibir arraylist desde primera actividad
        losTareaLista = (ArrayList<Tarea>) getIntent().getSerializableExtra("list");

        // modificar adaptador y llena adptador con arraylist de Tarea
        adaptadorTareaLista = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, losTareaLista);
        ltvnombres.setAdapter(adaptadorTareaLista);
    }

    private void eventos() {
        // Funcion para Botton Filtrat
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener Datos en TextInputLayout
                String dato = tilBuscar.getEditText().getText().toString();

                //Filtrar datos
                adaptadorTareaLista.getFilter().filter(dato);

                // Actualiza Datos para mustrar
                ltvnombres.setAdapter(adaptadorTareaLista);
            }
        });
        // Funcion Para ListView, cuando presiona largo tiempo y eliminar item
        ltvnombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //eliminar item
                losTareaLista.remove(i);

                //Actualizar Datos para muestrar
                adaptadorTareaLista.notifyDataSetChanged();
                return true;

            }

        });

    }



    // conecta diseña y java
    private void referencia() {

        ltvnombres = findViewById(R.id.ltvnombres);
        tilBuscar = findViewById(R.id.tilBuscar);
        btnFiltrar = findViewById(R.id.btnFiltrar);

        losTareaLista = new ArrayList<Tarea>();


    }
}
