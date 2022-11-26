package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainCrearMascota extends AppCompatActivity {
    Button btn_add;
    EditText nombre, edad, color;
    private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crear_mascota);

        this.setTitle("Crear Mascota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFirestore = FirebaseFirestore.getInstance();

        nombre = findViewById(R.id.txtnombre);
        edad = findViewById(R.id.txtedad);
        color = findViewById(R.id.txtcolor);
        btn_add = findViewById(R.id.btnRegistrar);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nombre.getText().toString();
                String e = edad.getText().toString();
                String c = color.getText().toString();
                if (n.isEmpty() && e.isEmpty() && c.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    postPet(n,e,c);
                }
            }
        });
        }

        private void postPet(String n, String e, String c){
            Map<String, Object> map = new HashMap<>();
            map.put("nombre",nombre);
            map.put("edad",edad);
            map.put("color",color);

            mFirestore.collection("mascotas").add(map).addOnSuccessListener (new OnSuccessListener<DocumentReference>()){

            }




        }
    }
