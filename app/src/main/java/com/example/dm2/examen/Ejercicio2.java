package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {

    Spinner spinProvincias;
    TextView ubicacion;
    RadioGroup grupo;
    RadioButton rbCosta, rbInterior;
    Button btnVisualizar;
    String seleccionada,zona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);


        btnVisualizar=(Button)findViewById(R.id.btnVisualizar);
        ubicacion=(TextView)findViewById(R.id.lblUbicacion);
        grupo=(RadioGroup)findViewById(R.id.grupo2);
        rbCosta=(RadioButton)findViewById(R.id.rbCosta);
        rbInterior=(RadioButton)findViewById(R.id.rbInterior);

        spinProvincias=(Spinner)findViewById(R.id.spinProvincias);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.provincias, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinProvincias.setAdapter(adaptador);
        spinProvincias.setSelected(false);

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Ejercicio2.this,localidades.class);
                intento.putExtra("nombre",seleccionada);

                if(rbCosta.isChecked()){
                    zona="costa";
                } else{
                    zona="interior";
                }

                intento.putExtra("zona",zona);
                startActivity(intento);
            }
        });



        spinProvincias.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                        switch (adapterView.getSelectedItem().toString()){
                            case "Bizkaia":
                                ubicacion.setVisibility(View.VISIBLE);
                                grupo.setVisibility(View.VISIBLE);
                                seleccionada="Bizkaia";

                                break;
                            case "Gipuzkoa":
                                ubicacion.setVisibility(View.VISIBLE);
                                grupo.setVisibility(View.VISIBLE);
                                seleccionada="Gipuzkoa";
                                break;
                            case "Araba":
                                ubicacion.setVisibility(View.INVISIBLE);
                                grupo.setVisibility(View.INVISIBLE);
                                seleccionada="Araba";
                                rbCosta.setSelected(false);
                                rbInterior.setSelected(true);
                                break;
                         }
                  }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
