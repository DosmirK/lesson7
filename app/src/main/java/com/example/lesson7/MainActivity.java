package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstOperand, secondOperand, result;
    private Boolean isOperationClick, isClick;
    private int flag;
    private String operation;
    private double percent, percent2, doubleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            firstOperand = 0;
            secondOperand = 0;
        } else if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick && (view.getId() != R.id.btn_zero)) {
                textView.setText(text);
            }else if (view.getId() == R.id.btn_dot) {
                textView.setText(textView.getText().toString() + ".");
            }else if (view.getId() == R.id.btn_plus_minus) {
                textView.setText("-" + textView.getText().toString());
            }else if (view.getId() == R.id.btn_zero){
                textView.setText("0");
            } else {
                textView.append(text);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            flag = 1;
            isClick = true;
        }
        if (view.getId() == R.id.btn_minus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            flag = 2;
            isClick = true;
        }
        if (view.getId() == R.id.btn_multiply) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            flag = 3;
            isClick = true;
        }
        if (view.getId() == R.id.btn_divide) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            flag = 4;
            isClick = true;
        }
        isOperationClick = true;
    }

    public void onOperationEqual(View view) {
        if (view.getId() == R.id.btn_equal && flag == 1){
            secondOperand = Integer.valueOf(textView.getText().toString());
            result = firstOperand + secondOperand;
            textView.setText(result.toString());
            operation = "+";
            isClick = false;
        }
        if (view.getId() == R.id.btn_equal && flag == 2){
            secondOperand = Integer.valueOf(textView.getText().toString());
            result = firstOperand - secondOperand;
            textView.setText(result.toString());
            operation = "-";
            isClick = false;
        }
        if (view.getId() == R.id.btn_equal && flag == 3){
            secondOperand = Integer.valueOf(textView.getText().toString());
            result = firstOperand * secondOperand;
            textView.setText(result.toString());
            operation = "*";
            isClick = false;
        }
        if (view.getId() == R.id.btn_equal && flag == 4){
            secondOperand = Integer.valueOf(textView.getText().toString());
            result = firstOperand / secondOperand;
            textView.setText(result.toString());
            operation = "/";
            isClick = false;
        }
        if (view.getId() == R.id.btn_equal && flag == 5){
            textView.setText(String.valueOf(doubleResult));
            isClick = false;
        }
        isOperationClick = true;
    }

    public void onOperationPercent(View view) {
        if (view.getId() == R.id.btn_percent && !isClick){
            firstOperand = Integer.valueOf(textView.getText().toString());
            double temp = Double.parseDouble(firstOperand.toString()) / 100;
            doubleResult = temp;
            flag = 5;
        }else if (isClick){
            switch (flag) {
                case 1:
                    percent2 = Double.parseDouble(textView.getText().toString());
                    doubleResult = firstOperand + firstOperand * percent2/100;
                    flag = 5;
                    break;
                case 2:
                    percent2 = Double.parseDouble(textView.getText().toString());
                    doubleResult = firstOperand - firstOperand * percent2/100;
                    flag = 5;
                    break;
                case 3:
                    percent2 = Double.parseDouble(textView.getText().toString());
                    secondOperand = Integer.valueOf(textView.getText().toString());
                    doubleResult = firstOperand * percent2/100;
                    flag = 5;
                    break;
                case 4:
                    percent2 = Double.parseDouble(textView.getText().toString());
                    secondOperand = Integer.valueOf(textView.getText().toString());
                    doubleResult = firstOperand / (percent2/100);
                    flag = 5;
                    break;
            }
        }
    }
}


