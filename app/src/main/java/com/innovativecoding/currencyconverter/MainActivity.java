package com.innovativecoding.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner=findViewById(R.id.spinner);
        Spinner spinner1=findViewById(R.id.spinner1);
        Button convert =findViewById(R.id.convert);
        EditText amt=findViewById(R.id.Amount);
        TextView preans=findViewById(R.id.preans);
        TextView ans=findViewById(R.id.ans);
        Button clear=findViewById(R.id.clear);
        clear.setVisibility(View.INVISIBLE);
        final DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("INR");
        arr.add("USD");
        arr.add("YEN");
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arr);
        spinner.setAdapter(ad);
        spinner1.setAdapter(ad);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!amt.getText().toString().isEmpty()){
                    float amount = Float.parseFloat(amt.getText().toString());
                    String unit1 = spinner.getSelectedItem().toString();
                    String unit2 = spinner1.getSelectedItem().toString();


                    if (unit1 == "INR" && unit2 == "USD") {
                        Double new_amt = Double.valueOf(df.format(amount / 78.95));
                        preans.setText("Converted Amount is");
                        ans.setText("USD. " + new_amt.toString());
                        clear.setVisibility(View.VISIBLE);
                    }

                    if (unit1 == "INR" && unit2 == "INR") {
                        preans.setText("Converted Amount is");
                        ans.setText("INR. " + amt.getText().toString());
                        clear.setVisibility(View.VISIBLE);
                    }
                    if (unit1 == "INR" && unit2 == "YEN") {
                        Double new_amt = Double.valueOf(df.format(amount * 1.72));
                        preans.setText("Converted Amount is");
                        ans.setText("YEN. " + new_amt.toString());
                        clear.setVisibility(View.VISIBLE);
                    }

                    if (unit1 == "USD" && unit2 == "USD") {
                        preans.setText("Converted Amount is");
                        ans.setText("USD. " + amt.getText().toString());
                        clear.setVisibility(View.VISIBLE);
                    }
                    if (unit1 == "USD" && unit2 == "INR") {
                        Double new_amt = Double.valueOf(df.format(amount * 78.95));
                        preans.setText("Converted Amount is");
                        ans.setText("INR. " + new_amt.toString());
                        clear.setVisibility(View.VISIBLE);
                    }

                    if (unit1 == "USD" && unit2 == "YEN") {
                        Double new_amt = Double.valueOf(df.format(amount * 136.16));
                        preans.setText("Converted Amount is");
                        clear.setVisibility(View.VISIBLE);

                        ans.setText("YEN. " + new_amt.toString());
                    }
                    if (unit1 == "YEN" && unit2 == "INR") {
                        Double new_amt = Double.valueOf(df.format(amount / 1.72));
                        preans.setText("Converted Amount is");
                        ans.setText("INR. " + new_amt.toString());
                        clear.setVisibility(View.VISIBLE);
                    }

                    if (unit1 == "YEN" && unit2 == "YEN") {
                        preans.setText("Converted Amount is");
                        ans.setText("YEN. " + amt.getText().toString());
                        clear.setVisibility(View.VISIBLE);
                    }
                    if (unit1 == "YEN" && unit2 == "USD") {
                        Double new_amt = Double.valueOf(df.format(amount / 136.16));
                        preans.setText("Converted Amount is");
                        ans.setText("USD. " + new_amt.toString());
                        clear.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter value",Toast.LENGTH_SHORT).show();
                }


                clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preans.setText("");
                        ans.setText("");
                        amt.setText("");
                        clear.setVisibility(view.INVISIBLE);
                    }
                });


            }
        });


    }
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}
