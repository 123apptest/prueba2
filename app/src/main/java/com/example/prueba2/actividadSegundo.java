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
        obteneDatos();
        eventos();


        adaptadorTareaLista = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, losTareaLista);
        ltvnombres.setAdapter(adaptadorTareaLista);
    }

    private void eventos() {
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = tilBuscar.getEditText().getText().toString();

            }
        });
        ltvnombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                losTareaLista.remove(i);
                adaptadorTareaLista.notifyDataSetChanged();
                return false;

            }

        });

    }

    private void obteneDatos() {

        for(int x = 1; x <= 25; ++x){
            Tarea i = new Tarea();
            i.setTitulo("Item " + x);
            i.setDescripcion("Sub item " + x);
            losTareaLista.add(i);
        }

        String titulo = getIntent().getExtras().getString("datoTitulo");
        String descripcion = getIntent().getExtras().getString("datoDescripcion");
        Tarea i = new Tarea();
        i.setTitulo(titulo);
        i.setDescripcion(descripcion);
        losTareaLista.add(i);


    }


    private void referencia() {

        ltvnombres = findViewById(R.id.ltvnombres);
        tilBuscar = findViewById(R.id.tilBuscar);
        btnFiltrar = findViewById(R.id.btnFiltrar);

        losTareaLista = new ArrayList<Tarea>();

    }
}