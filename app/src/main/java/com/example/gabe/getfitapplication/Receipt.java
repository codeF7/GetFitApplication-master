package com.example.gabe.getfitapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Receipt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_receipt);
        Intent callingIntent = getIntent();
        String str = callingIntent.getExtras().getString("mystring");
        TextView tv = (TextView) findViewById(R.id.receiptTV);
        tv.setText(str);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Beginner", "Intermediate", "Advanced"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void onClick(View v)
    {
        Intent intent = new Intent(Receipt.this, Payment.class);
        startActivity(intent);
    }

    public void onClick1(View v)
    {
        Intent intent = new Intent(Receipt.this, Session.class);
        startActivity(intent);
    }




    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.log_off){
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(Receipt.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Receipt.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
