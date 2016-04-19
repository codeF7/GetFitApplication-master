package com.example.gabe.getfitapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Signature extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signature_form);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        // MenuInflater inflater = getMenuInflater();
        // inflater.inflate(R.menu.menu_settings, menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.log_off){
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(Signature.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Signature.this, "Logging You Off", Toast.LENGTH_LONG).show();



        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        Intent intent = new Intent(Signature.this, Receipt.class);
        startActivity(intent);

    }
    public void onClick1(View v){
        Intent intent = new Intent(Signature.this, Payment.class);
        startActivity(intent);

    }
}
