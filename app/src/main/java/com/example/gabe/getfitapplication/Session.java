package com.example.gabe.getfitapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Session extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_session);
        TextView tv = (TextView) findViewById(R.id.Username1);
        String username = getIntent().getStringExtra("Username");
        tv.setText("Logged in: " +username);
    }


    public void onClick(View v)
    {
        Intent intent = new Intent(Session.this, Display.class);
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
            Intent intent = new Intent(Session.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Session.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        String str = null;
        switch (view.getId()){
            case R.id.yogaButton:
                if(checked){
                    str = "(1) Yoga Session. Duration: 1 hour. \n" +
                            "\n" +
                            " Sub-Total.......................... $6.99";
                    Toast.makeText(Session.this, "Added Yoga Session. 1 Hour. $6.99", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.cardioButton:
                if(checked){
                    str = "(1) Cardio Session. Duration: 30 Minutes. \n" +
                            "\n" +
                            " Sub-Total.......................... $4.99";
                    Toast.makeText(Session.this, "Added Cardio Session. 30 Minutes. $4.99", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.upperBodyButton:
                if(checked){
                    str = "(1) Upper Body Strength. Duration: 45 Minutes.\n\n Sub-Total.......................... $7.99";
                    Toast.makeText(Session.this, "Added Upper Body Strength. 45 Minutes. $7.99", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.lowerBodyButton:
                if(checked){
                    str = "(1) Lower Body Strength. Duration: 40 Minutes. \n" +
                            "\n" +
                            " Sub-Total.......................... $7.99";
                    Toast.makeText(Session.this, "Added Lower Body Strength. 40 Minutes. $7.99", Toast.LENGTH_SHORT).show();
                    break;
                }

        }
        Intent myIntent = new Intent(Session.this, Receipt.class);
        myIntent.putExtra("mystring", str);
        startActivity(myIntent);

    }

}
