package com.anazworth.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// Emulator used for testing: Pixel 3a API 33 arm64-v8a

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void currencySelectButtonClick(View view) {
        // Select currency button clicked
        Button button = (Button) view;

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.currencyRadioGroup);
        int currency = radioGroup.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) findViewById(currency);
        String currencyName = radioButton.getText().toString();

        Intent currencySelection = new Intent(this, ConverterActivity.class);
        currencySelection.putExtra("currency", currencyName);
        startActivity(currencySelection);
    }
}