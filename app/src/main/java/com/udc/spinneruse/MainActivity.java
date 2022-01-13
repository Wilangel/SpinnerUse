package com.udc.spinneruse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // instanciamos objetos de componentes
    private Spinner Spinner1;
    private EditText et1, et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignamos los componentes de la interfaz

        et1 = (EditText) findViewById(R.id.txt1);
        et2 = (EditText) findViewById(R.id.txt2);
        tv1 = (TextView) findViewById(R.id.tv1);
        Spinner1 = (Spinner) findViewById(R.id.spinner1);

        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        Spinner1.setAdapter(adapter);

    }
    // metodo calcular para el boton

    public void Calcular(View view) {
        String Valor1str = et1.getText().toString();
        String Valor2str = et2.getText().toString();

        int Valor1int = Integer.parseInt(Valor1str);
        int Valor2int = Integer.parseInt(Valor2str);

        String Seleccion = Spinner1.getSelectedItem().toString();

        if (Seleccion.equals("Sumar")) {
// calculo de la suma
            int suma = Valor1int + Valor2int;
            String Resultado = String.valueOf(suma);
            tv1.setText(Resultado);

        } else if (Seleccion.equals("Restar")) {
            //calculo Resta
            int resta = Valor1int - Valor2int;
            String Resultado = String.valueOf(resta);
            tv1.setText(Resultado);
        } else if (Seleccion.equals("Multiplicar")) {
            //calculo Multiplicacion
            int multiplicacion = Valor1int * Valor2int;
            String Resultado = String.valueOf(multiplicacion);
            tv1.setText(Resultado);


        } else if (Seleccion.equals("Dividir")) {
            //calculo Division

            if (Valor2int != 0) {
                int division = Valor1int / Valor2int;
                String Resultado = String.valueOf(division);
                tv1.setText(Resultado);
            } else {

                Toast.makeText(this, "No se puede Dividir entre cero", Toast.LENGTH_LONG).show();
            }


        }
    }
}