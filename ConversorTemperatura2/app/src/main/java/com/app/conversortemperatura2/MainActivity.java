package com.app.conversortemperatura2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String TITULO_APPBAR = "Conversor de Temperatura";
    private EditText tcEdit;
    private EditText tfEdit;
    private EditText tkEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_main);

        tcEdit = findViewById(R.id.edit_text_celsius);
        tfEdit = findViewById(R.id.edit_text_fahrenheit);
        tkEdit = findViewById(R.id.edit_text_kelvin);

    }

    public void button_converter(View view){

        try {

            if(tcEdit.isFocused() && !tcEdit.getText().toString().isEmpty()){
                int tc = Integer.parseInt(tcEdit.getText().toString());
                int tf = (tc * 9/5) + 32;
                int tk = (tc + 273);
                setKelvinAndFahrenheitFields(tk, tf);

            } else if(tfEdit.isFocused() && !tfEdit.getText().toString().isEmpty()){
                int tf = Integer.parseInt(tfEdit.getText().toString());
                int tc = (tf - 32) * 5/9;
                int tk = (tf - 32) * 5/9 + 273;
                setKelvinAndCelsiusFields(tk, tc);

            } else if(tkEdit.isFocused() && !tkEdit.getText().toString().isEmpty()){
                int tk = Integer.parseInt(tkEdit.getText().toString());
                int tc = tk - 273;
                int tf = (tk - 273) * 9/5 + 32;
                setCelsiusAndFahrenheitFields(tc, tf);
            }

        }
         catch(IllegalStateException e) {
            resetFields();
            Toast.makeText(this, "Temperatura Inválida", Toast.LENGTH_SHORT).show();
        }


    }

    public void button_reset(View view){
        resetFields();
    }

    public void resetFields() {
        tcEdit.setText(""); tfEdit.setText(""); tkEdit.setText("");
    }

    public void setKelvinAndFahrenheitFields(int tk, int tf) {
        tkEdit.setText(String.valueOf(tk));
        tfEdit.setText(String.valueOf(tf));
    }

    public void setKelvinAndCelsiusFields(int tk, int tc) {
        tkEdit.setText(String.valueOf(tk));
        tcEdit.setText(String.valueOf(tc));
    }

    public void setCelsiusAndFahrenheitFields(int tc, int tf) {
        tcEdit.setText(String.valueOf(tc));
        tfEdit.setText(String.valueOf(tf));
    }
}
