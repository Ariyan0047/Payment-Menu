package com.example.pay_ment;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class CheckOut extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Button btn = (Button) findViewById(R.id.show);
        Button btn1 = (Button) findViewById(R.id.show1);
        TextView result = (TextView) findViewById(R.id.final_result01);
        TextView bill  = (TextView) findViewById(R.id.total_bill);
        TextView bill1  = (TextView) findViewById(R.id.total_bill1);

        Bundle extras = getIntent().getExtras();

        assert extras != null;
        String sc = extras.getString("Extra");
        result.setText(sc);

        float count = 0;

        assert sc != null;
        if(sc.contains("Apple : 120 Taka")){
            count = count + 120;
        }

        if(sc.contains("Mango : 220 Taka")){
            count = count + 220;

        }

        if(sc.contains("Banana : 20 Taka")){
            count = count + 20;

        }

        if(sc.contains("Orange : 80 Taka")){
            count = count + 80;

        }

        if(sc.contains("JackFruit : 280 Taka")){
            count = count + 280;

        }

        @SuppressLint("DefaultLocale")
        String count2 = String.format("%.2f",count);
        bill.setText(count2+" Taka");

        float dollar = count/80;
        @SuppressLint("DefaultLocale")
        String count3 = String.format("%.2f",dollar);

        bill1.setText(count3+" $");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial("01799058804");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);

                i.putExtra("address", "01799058804");

                i.putExtra("sms", "Confirm Order");

                i.setType("vnd.android-dir/mms-sms");

                startActivity(i);
            }
        });
    }

    private void dial(final String phoneNumber){
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
