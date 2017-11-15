package com.example.dm2.examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    int num1,num2,res,cont=0,contAciertos=0;
    RadioButton rbSuma,rbResta,rbMult;
    Button btnEmpezar,btnEvaluar,btnSalir;
    EditText texto;
    TextView lbloper;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);


        rbSuma=(RadioButton)findViewById(R.id.rbSuma);
        rbResta=(RadioButton)findViewById(R.id.rbResta);
        rbMult=(RadioButton)findViewById(R.id.rbMult);

        lbloper=(TextView)findViewById(R.id.lblOper);
        btnEmpezar=(Button)findViewById(R.id.btnEmpezar);
        btnEvaluar=(Button)findViewById(R.id.btnEvaluar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        texto=(EditText)findViewById(R.id.txtOper);


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEvaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(texto.getText().toString().equals("")){
                    return;
                }
                cont++;
                if(operador.equals("+")) {
                    if (num1 + num2 == Integer.parseInt(texto.getText().toString())) {
                        contAciertos++;
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " + " + num2 + " = ");
                        texto.setText("");
                        Toast.makeText(getApplicationContext(),"Acertada",Toast.LENGTH_SHORT).show();
                    } else {
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " + " + num2 + " = ");
                        texto.setText("");
                    }
                } else if (operador.equals("-")){
                    if (num1 - num2 == Integer.parseInt(texto.getText().toString())) {
                        contAciertos++;
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " - " + num2 + " = ");
                        texto.setText("");
                    } else {
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " - " + num2 + " = ");
                        texto.setText("");
                    }
                } else {
                    if (num1 * num2 == Integer.parseInt(texto.getText().toString())) {
                        contAciertos++;
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " * " + num2 + " = ");
                        texto.setText("");
                    } else {
                        num1 = (int) (Math.random() * 100);
                        num2 = (int) (Math.random() * 100);
                        lbloper.setText(num1 + " * " + num2 + " = ");
                        texto.setText("");
                    }
                }

                if(cont==10){
                    double media = contAciertos/cont*100;
                    btnEvaluar.setVisibility(View.INVISIBLE);
                    btnEmpezar.setVisibility(View.VISIBLE);
                    cont=0;
                    contAciertos=0;
                    Toast.makeText(getApplicationContext(),"Has tenido un " + media + "% de aciertos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!rbSuma.isChecked() && !rbResta.isChecked() && !rbMult.isChecked()){
                    Toast.makeText(getApplicationContext(),"Debe seleccionar una opcion para empezar con los cálculos",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(rbSuma.isChecked()){
                    btnEmpezar.setVisibility(View.INVISIBLE);
                    btnEvaluar.setVisibility(View.VISIBLE);
                    num1=(int)(Math.random()*100);
                    num2=(int)(Math.random()*100);
                    lbloper.setText(num1 +" + " + num2 + " = ");
                    operador="+";
                } else if(rbResta.isChecked()){
                    btnEmpezar.setVisibility(View.INVISIBLE);
                    btnEvaluar.setVisibility(View.VISIBLE);
                    num1=(int)(Math.random()*100);
                    num2=(int)(Math.random()*100);
                    lbloper.setText(num1 +" - " + num2 + " = ");
                    operador="-";
                } else {
                    btnEmpezar.setVisibility(View.INVISIBLE);
                    btnEvaluar.setVisibility(View.VISIBLE);
                    num1=(int)(Math.random()*100);
                    num2=(int)(Math.random()*100);
                    lbloper.setText(num1 +" * " + num2 + " = ");
                    operador="*";
                }
            }
        });

    }
}
