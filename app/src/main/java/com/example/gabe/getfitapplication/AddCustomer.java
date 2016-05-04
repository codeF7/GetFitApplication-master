package com.example.gabe.getfitapplication;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.TimeZone;

public class AddCustomer extends AppCompatActivity {
    MyAdapter myAdapter;
    EditText etTasks;
    TimeZone tz = TimeZone.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additional_customers);

        etTasks = (EditText) findViewById(R.id.editTestTask);
        openDB();
        populateListView();


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.log_off){
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(AddCustomer.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(AddCustomer.this, "Logging You Off", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickContinue(View v){
        Intent intent = new Intent(AddCustomer.this, Session.class);
        startActivity(intent);
    }


    private void openDB(){
        myAdapter = new MyAdapter(this);
        myAdapter.open();
    }

    public void onClick_AddTask (View v){
        Toast.makeText(AddCustomer.this, "New Customer Added!", Toast.LENGTH_SHORT).show();
        String timestamp = tz.getDisplayName();

        if(!TextUtils.isEmpty(etTasks.getText().toString())){
            myAdapter.insertRow(etTasks.getText().toString(), timestamp);
        }
        populateListView();

    }

    public void onClickDeleteAll(View v){
        myAdapter.deleteAll();
        populateListView();
        Toast.makeText(AddCustomer.this, "Clearing the List", Toast.LENGTH_SHORT).show();
    }

    private void populateListView() {
        Cursor cursor = myAdapter.getAllRows();
        String[] fromFieldNames = new String[] {MyAdapter.KEY_ROWID, MyAdapter.KEY_TASK};
        int[] toViewIDs = new int[] {0, R.id.textViewItemTask};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_layout, cursor, fromFieldNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.listViewTasks);
        myList.setAdapter(myCursorAdapter);
    }

    public void onClickPhoto(View v){
        Intent intent = new Intent(AddCustomer.this, Camera.class);
        startActivity(intent);
    }















}



