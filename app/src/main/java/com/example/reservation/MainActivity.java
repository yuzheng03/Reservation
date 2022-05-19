package com.example.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //step 1: declare the final variabales
    DatePicker dp;
    TimePicker tp;
    Button submitbtn;
    TextView tvDisplay;
    Button btnReset;
    EditText name;
    EditText number;
    EditText pax;
    CheckBox smoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step 2: link the field variables to UI components in layout
        dp= findViewById(R.id.datePicker);
        tp= findViewById(R.id.timePicker);
        submitbtn= findViewById(R.id.button);
        tvDisplay= findViewById(R.id.textView);
        btnReset=findViewById(R.id.reset);
        name=findViewById(R.id.inputName);
        number=findViewById(R.id.inputNumber);
        pax=findViewById(R.id.inputPax);
        smoking=findViewById(R.id.checkBox);
        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);
        dp.updateDate(2020,0,01);

        //FOR time BUTTONS TO WORK
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getHour= tp.getCurrentHour();
                int getMin = tp.getCurrentMinute();
                int getMonth=dp.getMonth()+1;
                int getYear=dp.getYear();
                int getDayOfMonth=dp.getDayOfMonth();
                String smkTxt = "";
                if(smoking.isChecked()){
                    smkTxt = "Smoking Area";
                }else {
                    smkTxt = "Non-Smoking Area";
                }
                Toast.makeText(MainActivity.this,"Name: " + name.getText() +
                                "\nPhone Number: " + number.getText() + "\nNo of Pax: " + pax.getText() +
                                "\nArea: " + smkTxt + "\nTime is: " + getHour + ": " +
                                getMin + "\nDate is: " + getDayOfMonth+ "/" +getMonth + "/" + getYear,
                        Toast.LENGTH_LONG).show();
            }
        });

        //for reset button to work
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                number.setText("");
                pax.setText("");
                smoking.setChecked(false);
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,0,01);
            }
        });


    }
}