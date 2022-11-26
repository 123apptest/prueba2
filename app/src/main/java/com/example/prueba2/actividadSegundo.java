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

    private ArrayAdapter<String> adaptadorTareaLista;

    private ArrayList<String> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_segundo);

        referencia();
        eventos();

        Bundle b = getIntent().getExtras();
        ArrayList<String> arr = b.getStringArrayList("list");


        adaptadorTareaLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        ltvnombres.setAdapter(adaptadorTareaLista);
    }

    private void eventos() {
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = tilBuscar.getEditText().getText().toString();
                adaptadorTareaLista.getFilter().filter(dato);
                ltvnombres.setAdapter(adaptadorTareaLista);
            }
        });
        ltvnombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                arr.remove(i);
                adaptadorTareaLista.notifyDataSetChanged();
                return false;

            }

        });

    }




    private void referencia() {

        ltvnombres = findViewById(R.id.ltvnombres);
        tilBuscar = findViewById(R.id.tilBuscar);
        btnFiltrar = findViewById(R.id.btnFiltrar);

        arr = new ArrayList<String>();

    }
}