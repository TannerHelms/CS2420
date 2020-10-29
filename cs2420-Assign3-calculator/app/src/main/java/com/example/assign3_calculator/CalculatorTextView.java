package com.example.assign3_calculator;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.style.TtsSpan;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.concurrent.ExecutionException;

public class CalculatorTextView extends AppCompatTextView implements TextViewInterface{
    private ButtonData data;
    private String text = "";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CalculatorTextView(@NonNull Context context, ButtonData buttonData) {
        super(context);
        this.data = buttonData;
        setText(data.getButtonText());
        setTextSize(40);
        setTextColor(data.getColor());
        setBackgroundColor(Color.BLACK);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.getRow(), 1, 1f);
        params.columnSpec = GridLayout.spec(data.getColumn(), data.getSize(), 1f);
        params.setMargins(0,0,3,0);
        setLayoutParams(params);
    }

    public double sum(){
        String[] tokens = text.split(" ");
        if (tokens.length == 0) {
            return Double.NaN;
        }
        if (tokens.length == 1) {
            if (checkForOperator(text)){
                return Double.NaN;
            }
            return Integer.parseInt(text);
        }
        if (tokens.length == 2) {
            return Double.NaN;
        }
        return sumValues(text.split(" "));
    }
    public boolean checkForOperator(String data){
        try {
            Integer.parseInt(data);
            return false;
        } catch (Exception e){
            return true;
        }
    }

    private double sumValues(String[] arr){
        double Total = 0;
        try {
            Total = Double.parseDouble(arr[0]);
            if (Double.isNaN(Total)){
                Total = 0;
                arr[0] = "0";
            }
            arr = sliceArray(arr, 1, arr.length);
            while(true){
                Total = calcValues(Total, arr[0], Double.parseDouble(arr[1]));
                arr = sliceArray(arr, 2, arr.length);
                if (arr.length <2) {
                    break;
                }
            }
        } catch (Exception e){
            Total = Double.NaN;
        }
        return Total;
    }
    private double calcValues(double firstNum, String operator, double secondNum){
         switch (operator){
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                return firstNum / secondNum;
        }
        return 0;
    }
    public static String[] sliceArray(String array[], int startIndex, int endIndex){
        int size = endIndex-startIndex;
        String part[] = new String[size];
        //Copying the contents of the array
        for(int i=0; i<part.length; i++){
            part[i] = array[startIndex+i];
        }
        return part;
    }

    @Override
    public void addText(String data) {
        if (data.equals("C")){
            text = "";
            setText(text);
            return;
        }
        if (data.equals("=")){
            double total = 0;
            try{
                total = sum();
            } catch (Exception e){
                total = Double.NaN;
            }
            if (total == (int)total) {
                text = Integer.toString((int)total);
            } else {
                text = Double.toString(total);
            }
            setText(text);
            return;
        }
        if (checkForOperator(data) && !data.equals(".")){
            text += " " + data + " ";
            setText(text);
            return;
        }
        text += data;
        setText(text);
    }


}
