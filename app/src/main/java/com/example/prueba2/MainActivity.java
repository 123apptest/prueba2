package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.time.Instant;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilTitulo,tilDescripcion;
    private Button btnIngresar,btnModificar, btnBuscar;
    private ArrayList<Tarea> losTareaLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refecrencia();
        generaDatos();
        evento();
    }

    private void generaDatos() {
        for(int x = 1; x <= 25; ++x){
            Tarea i = new Tarea();
            i.setTitulo("Item " + x);
            i.setDescripcion("Sub item " + x);
            losTareaLista.add(i);
        }


    }

    private void evento() {
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segundoActividad();
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();
                validacion();
                Tarea i = new Tarea();
                i.setTitulo(titulo);
                i.setDescripcion(descripcion);
                losTareaLista.add(i);


            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                validacion();

                boolean encontrado = false;
                for (int x = 0; x < losTareaLista.size(); x++ ){
                    Tarea i = losTareaLista.get(x);
                    if (i.getTitulo().equals(titulo)){
                        encontrado = true;
                        i.setDescripcion(descripcion);
                        break;
                    }
                }

                if (!encontrado){
                    Toast.makeText(MainActivity.this, "Tarea no existe", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }

    private void validacion() {
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        if (titulo.isEmpty() || descripcion.isEmpty()){
            if(titulo.isEmpty())
                tilTitulo.setError("Debes completar este campo");
            if(descripcion.isEmpty())
                tilDescripcion.setError("Debes completar este campo");
        }
    }

    private void segundoActividad() {
            String titulo = tilTitulo.getEditText().getText().toString();
            String descripcion = tilDescripcion.getEditText().getText().toString();


            Intent segundoPantalla = new Intent(getBaseContext(), actividadSegundo.class);

            segundoPantalla.putExtra("list", losTareaLista);

            startActivity(segundoPantalla);
    }

    private void refecrencia() {
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar = findViewById(R.id.btnBuscar);


        losTareaLista = new ArrayList<Tarea>();

    }
}
