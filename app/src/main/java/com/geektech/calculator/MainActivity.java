package com.geektech.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Double firstVar;
    private Double secondVar;
    private Boolean isOperationClick;
    private String operation;
    private MaterialButton btnNotAnInteger;
    private MaterialButton btnEqual;
    private MaterialButton btnInvisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEqual=findViewById(R.id.btn_equal);
        btnInvisible=findViewById(R.id.btn_invisible);
        btnInvisible.setOnClickListener(view -> {
            String result = String.valueOf(tvResult.getText());
            Intent intent = new Intent(MainActivity.this,MainActivityPolicies.class);
            intent.putExtra("key1",result);
            startActivity(intent);
        });
        tvResult = findViewById(R.id.tv_result);

       btnEqual.setOnClickListener(view -> {
           if(btnInvisible.getAlpha()==0){
               btnInvisible.animate().alpha(1);
           }else {
               onOperationClick(view);
           }

        });
    }


    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_null:
                setNumber("0");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_one:
                setNumber("1");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_two:
                setNumber("2");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_three:
                setNumber("3");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_four:
                setNumber("4");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_five:
                setNumber("5");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_six:
                setNumber("6");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_seven:
                setNumber("7");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_eight:
                setNumber("8");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_nine:
                setNumber("9");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                firstVar = 0.0;
                secondVar = 0.0;
                btnInvisible.animate().alpha(0);
                break;



        }
    }

    private void setNumber(String number){
        btnNotAnInteger=findViewById(R.id.btn_not_an_integer);
        btnNotAnInteger.setOnClickListener(view -> {
            if(tvResult.getText().toString().equals("0")){
                tvResult.append(".");
            } else {
                tvResult.append(".");
            }
        });
        if (tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }
            else if (isOperationClick){
            tvResult.setText(number);

        }

            else{
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_negative_and_positive_number:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "+/-";
                isOperationClick = true;
                break;
            case R.id.btn_plus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case R.id.btn_division:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case R.id.btn_multiplication:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "*";
                isOperationClick = true;
                break;

            case R.id.btn_equal:
                secondVar = Double.parseDouble(tvResult.getText().toString());
                Double result = 0.0;
                switch (operation ){
                    case "+/-":
                        result = firstVar+secondVar;
                    case "+":
                        result = firstVar + secondVar;
                        break;
                    case "-":
                        result = firstVar-secondVar;
                        break;
                    case "*":
                        result = firstVar*secondVar;
                        break;
                    case "/":
                        result = firstVar/secondVar;
                        break;

                }
                tvResult.setText(result.toString());
                break;
        }
    }
}