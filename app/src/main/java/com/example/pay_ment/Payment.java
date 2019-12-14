package com.example.pay_ment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectItem(View view){

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case  R.id.check1 :
                if(checked){
                    selection.add("Apple : 120 Taka");
                }else {
                    selection.remove("Apple : 120 Taka");
                }
                break;
            case  R.id.check2 :
                if(checked){
                    selection.add("Mango : 220 Taka");
                }else {
                    selection.remove("Mango : 220 Taka");
                }
                break;
            case  R.id.check3 :
                if(checked){
                    selection.add("Banana : 20 Taka");
                }else {
                    selection.remove("Banana : 20 Taka");
                }
                break;
            case  R.id.check4 :
                if(checked){
                    selection.add("Orange : 80 Taka");
                }else {
                    selection.remove("Orange : 80 Taka");
                }
                break;
            case  R.id.check5 :
                if(checked){
                    selection.add("JackFruit : 280 Taka");
                }else {
                    selection.remove("JackFruit : 280 Taka");
                }
                break;

        }
    }
    public void finalSelection(View view){

        String finalResult = "";
        for(String Selections : selection){
            finalResult = finalResult + Selections + "\n";
        }
        Intent intent = new Intent(Payment.this,CheckOut.class);
        intent.putExtra("Extra",finalResult);
        startActivity(intent);
    }
}
