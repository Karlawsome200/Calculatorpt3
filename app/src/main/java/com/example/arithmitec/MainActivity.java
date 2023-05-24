package com.example.arithmitec;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder currentNumber;
    private double operand1;
    private double operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        currentNumber = new StringBuilder();
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentNumber.append(button.getText().toString());
        resultTextView.setText(currentNumber.toString());
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(currentNumber.toString());
        currentNumber.setLength(0);
    }

    public void onEqualsClick(View view) {
        operand2 = Double.parseDouble(currentNumber.toString());
        double result = performOperation();
        resultTextView.setText(String.valueOf(result));
        currentNumber.setLength(0);
        currentNumber.append(result);
    }

    private double performOperation() {
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }
        return result;
    }

    public void onClearClick(View view) {
        currentNumber.setLength(0);
        resultTextView.setText("");
    }
}
