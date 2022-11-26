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
        //  Genera Datos Automatica Cuando inicia app
    private void generaDatos() {
        for(int x = 1; x <= 25; ++x){
            Tarea i = new Tarea();
            i.setTitulo("Item " + x);
            i.setDescripcion("Sub item " + x);
            losTareaLista.add(i);
        }


    }

    private void evento(){
        // Funcion para Button Buscar
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funcion para entra segundo pantalla
                segundoActividad();
            }
        });

        //  Funcion para Botton Ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener Datos en Textlayoutinput
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                // valida usuario debe ingresar titulo y descripcion
                validacion();



                // Agregar nuevo Objecto de Class Tarea
                Tarea i = new Tarea();
                i.setTitulo(titulo);
                i.setDescripcion(descripcion);
                losTareaLista.add(i);


            }
        });

        // Funcion para Botton Modificar
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener datos en Textlayoutinput
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                // valida usuario debe ingresar titulo y descripcion
                validacion();


                boolean encontrado = false;
                // Leer todos Arraylist de Tarea
                for (int x = 0; x < losTareaLista.size(); x++ ){
                    Tarea i = losTareaLista.get(x);
                    // si encuentra titulo que usario ingresa
                    if (i.getTitulo().equals(titulo)){
                        encontrado = true;

                        // Modificar descripcion
                        i.setDescripcion(descripcion);

                        // salir leer Arraylist
                        break;
                    }
                }
                // Si no encuentro mismo Titulo, mandar Toast mensaje "Tarea no existe"
                if (!encontrado){
                    Toast.makeText(MainActivity.this, "Tarea no existe", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }
    // valida usuario debe ingresar titulo y descripcion
    private void validacion() {
        // Obtener datos en textlayout
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        // si titulo o descripcion is vacio, SetError rojo en TextInputLayout
        if (titulo.isEmpty() || descripcion.isEmpty()){
            if(titulo.isEmpty())
                tilTitulo.setError("Debes completar este campo");
            if(descripcion.isEmpty())
                tilDescripcion.setError("Debes completar este campo");
        }
    }
    // Funcion para entra segundo Actividad
    private void segundoActividad() {
            // Obtener datos
            String titulo = tilTitulo.getEditText().getText().toString();
            String descripcion = tilDescripcion.getEditText().getText().toString();

            //Crear nuevo Intent para desde mainActividad  al segundo actividad
            Intent segundoPantalla = new Intent(getBaseContext(), actividadSegundo.class);

            // envia Arraylist al segundo actividad
            segundoPantalla.putExtra("list", losTareaLista);

            // abrir segundo actividad
            startActivity(segundoPantalla);
    }

    // Conecta Diseña y java
    private void refecrencia() {
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar = findViewById(R.id.btnBuscar);

        losTareaLista = new ArrayList<Tarea>();

    }
}
