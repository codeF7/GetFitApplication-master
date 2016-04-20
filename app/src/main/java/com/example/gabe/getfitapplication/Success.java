package com.example.gabe.getfitapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Success extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.log_off){
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(Success.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Success.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}

