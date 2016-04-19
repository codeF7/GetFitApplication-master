package com.example.gabe.getfitapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        setContentView(R.layout.activity_main);

        Fragment_login fragmentLogin = new Fragment_login();
        fragmentTransaction.replace(android.R.id.content,fragmentLogin);

        fragmentTransaction.commit();

    }




    public void onClickDisplay(View v)
    {
        if(v.getId() == R.id.Blogin)
        {

            EditText x = (EditText) findViewById(R.id.TFusername);
            String str = x.getText().toString();
            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("Username", str);
            startActivity(i);
        }

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
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
