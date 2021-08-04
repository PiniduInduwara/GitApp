package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_faran;
    Button btn_calculate;
    TextView tv_displayAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_faran = findViewById(R.id.btn_faran);
        btn_calculate = findViewById(R.id.btn_celsius);
        tv_displayAnswer = findViewById(R.id.tv_displayAnswer);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {

        Calculations calculations = new Calculations();
        String temp_value = et_value.getText().toString();

        if( TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
 else{
     Float temp = Float.parseFloat(temp_value);
            if(btn_celsius.isChecked()){
                temp = calculations.convertCelciusToFahrenheit(temp);

            }
            else if(btn_faran.isChecked()){
                temp = calculations.convertFahrenheitToCelcius(temp);

            }
            tv_displayAnswer.setText(new Float(temp).toString());
        }
    }
}