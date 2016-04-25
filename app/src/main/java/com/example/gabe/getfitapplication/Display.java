package com.example.gabe.getfitapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Display extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.Username1);
        tv.setText("Logged in: " +username);

        String [] customerList = {username};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, customerList);
        ListView theListView = (ListView) findViewById(R.id.customerListView);
        int[] toViewIDs = new int[] {0, R.id.textViewItemTask};
        theListView.setAdapter(theAdapter);
    }


    public void onClick(View v)
    {
        Intent intent = new Intent(Display.this, Session.class);
        startActivity(intent);
    }

    public void onClickAddMoreCustomers(View v)
    {
        Intent intent = new Intent(Display.this, AddCustomer.class);
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
            Intent intent = new Intent(Display.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Display.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

}
