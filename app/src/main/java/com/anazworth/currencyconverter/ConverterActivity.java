package com.anazworth.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.Objects;

public class ConverterActivity extends AppCompatActivity {

    final double USD_TO_CAD = 1.26;
    final double USD_TO_EUR = 0.85;
    final double USD_TO_YEN = 109.94;

    String currencyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        currencyName = getIntent().getStringExtra("currency");
        TextView currencyTextView = findViewById(R.id.foreignCurrencyTextView);
        currencyTextView.setText(currencyName);

        Button convertButton = findViewById(R.id.toForeignCurrencyButton);
        convertButton.setText(String.format("To %s", currencyName));
    }

    public void convertToUsdButtonClick(View view) {
        TextInputEditText toForeignInput = findViewById(R.id.foreignCurrencyTextInput);
        if (toForeignInput == null) {
            return;
        }

        double toForeignAmount = Double.parseDouble(Objects.requireNonNull(toForeignInput.getText()).toString());
        convertToUsd(toForeignAmount);
    }

    public void convertToUsd(Double amount) {
        if (amount <= 0.00) {
            return;
        }
        double convertedAmount = 0.0;
        switch (currencyName) {
            case "CAD":
                convertedAmount = amount / USD_TO_CAD;
                break;
            case "EUR":
                convertedAmount = amount / USD_TO_EUR;
                break;
            case "YEN":
                convertedAmount = amount / USD_TO_YEN;
                break;
        }
        TextInputEditText toUSDInput = findViewById(R.id.currencyUSD);
        toUSDInput.setText(String.format(Locale.ENGLISH,"%.2f", convertedAmount));
    }

    public void convertToForeignButtonClick(View view) {
        TextInputEditText toUSDInput = findViewById(R.id.currencyUSD);
        if (toUSDInput == null) {
            return;
        }

        double toUSDAmount = Double.parseDouble(Objects.requireNonNull(toUSDInput.getText()).toString());
        convertToForeign(toUSDAmount);
    }

    public void convertToForeign(Double amount) {
        if (amount <= 0.00) {
            return;
        }
        double convertedAmount = 0.0;
        switch (currencyName) {
            case "CAD":
                convertedAmount = amount * USD_TO_CAD;
                break;
            case "EUR":
                convertedAmount = amount * USD_TO_EUR;
                break;
            case "YEN":
                convertedAmount = amount * USD_TO_YEN;
                break;
        }
        TextInputEditText toForeignInput = findViewById(R.id.foreignCurrencyTextInput);
        toForeignInput.setText(String.format(Locale.ENGLISH,"%.2f", convertedAmount));
    }

    public void backButton(View view) {
        finish();
    }
}