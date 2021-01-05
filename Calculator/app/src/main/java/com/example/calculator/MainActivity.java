package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String num1 = "0";

    String num2 = "0";

    int mathOp;

    int count = 0;

    boolean switchText = false;

    public void mathKeys(View view) {

        TextView resultTextView = (TextView) findViewById(R.id.resulttextView);



        count++;

        Button button = (Button) view;

        if(count < 2) {
                switchText = true;
        } else {

            double result = 0;

            Double firstNum = Double.parseDouble(num1);

            Double secondNum = Double.parseDouble(num2);

            switch (mathOp) {
                case 1: result = firstNum + secondNum;
                break;
                case 2: result = firstNum - secondNum;
                break;
                case 3: result = firstNum / secondNum;
                break;
                case 4: result = firstNum * secondNum;
                break;
                default: result = 0;
            }

            resultTextView.setText(String.valueOf(result));
            num1 = String.valueOf(result);
            num2 = "0";

        }

        mathOp = Integer.parseInt(button.getTag().toString());


    }

    public void numberKeys(View view) {

        TextView num1TextView = (TextView) findViewById(R.id.num1TextView);

        TextView num2TextView = (TextView) findViewById(R.id.mathOpTextView);

        Button button = (Button) view;

        String digits = (button.getTag().toString());

        if(!switchText) {

            num1 = num1.concat(digits);

            num1TextView.setText(String.valueOf(num1));
        } else {

            num2 = num2.concat(digits);

            num2TextView.setText(String.valueOf(num2));
        }


    }

    public void calculate(View view) {

        TextView resultTextView = (TextView) findViewById(R.id.resulttextView);

        double result = 0;

        Double firstNum = Double.parseDouble(num1);

        Double secondNum = Double.parseDouble(num2);

        switch (mathOp) {
            case 1: result = firstNum + secondNum;
                break;
            case 2: result = firstNum - secondNum;
                break;
            case 3: result = firstNum / secondNum;
                break;
            case 4: result = firstNum * secondNum;
                break;
            default: result = 0;
        }

        resultTextView.setText(String.valueOf(result));
        num1 = String.valueOf(result);
        num2 = "0";

        mathOp = -1;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}