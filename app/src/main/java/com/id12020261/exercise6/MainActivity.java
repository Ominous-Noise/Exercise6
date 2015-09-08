package com.id12020261.exercise6;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    static final int REQUEST_CODE1 = 1;
    static final int REQUEST_CODE2 = 2;
    static final int REQUEST_CODE3 = 3;
    static final int REQUEST_CODE4 = 4;
    int mFriendNum = 1;

    friendAdapter mAdapter;
    FriendDataBaseHelper nFriendhelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nFriendhelper = new FriendDataBaseHelper(getApplicationContext());

        nFriendhelper.addFriend(new FriendData(mFriendNum,"Nathan","unemployed","Sydney",System.currentTimeMillis()));mFriendNum++;
        nFriendhelper.addFriend(new FriendData(mFriendNum, "Bob", "Stocker", "Melbourn", System.currentTimeMillis()));mFriendNum++;
        nFriendhelper.addFriend(new FriendData(mFriendNum, "Ross", "Cashier", "Burnie", System.currentTimeMillis()));mFriendNum++;
        nFriendhelper.addFriend(new FriendData(mFriendNum, "Jason", "Architect", "Sydney", System.currentTimeMillis()));mFriendNum++;





        Button addButton = (Button) findViewById(R.id.activity_main_add_button);
        Button listButton = (Button) findViewById(R.id.activity_main_list_button);
        Button searchButton = (Button) findViewById(R.id.activity_main_search_button);
        addButton.setOnClickListener(this);
        listButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivityForResult(new Intent(this,SettingsActivity.class), REQUEST_CODE1);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        EditText searchName = (EditText) findViewById(R.id.activity_main_search_edittext);

        Intent addIntent;
        Intent listIntent;
        Intent searchIntent;

        switch (v.getId()) {
            case R.id.activity_main_add_button:
                startActivityForResult(addIntent = new Intent(this,addFriendActivity.class), REQUEST_CODE2);
                break;
            case R.id.activity_main_list_button:
                startActivityForResult(listIntent = new Intent(this,ListAllActivity.class), REQUEST_CODE3);
                break;
            case R.id.activity_main_search_button:
                startActivityForResult(searchIntent = new Intent(this, ListAllActivity.class), REQUEST_CODE4);
                searchIntent.putExtra("search",searchName.getText().toString());
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE2) {
            if (resultCode == RESULT_CANCELED)
                setTitle("OK");
            else if (resultCode == RESULT_OK) {
                nFriendhelper.addFriend(new FriendData(mFriendNum, data.getStringExtra("name"), data.getStringExtra("occupation"), data.getStringExtra("city"), System.currentTimeMillis()));
                mFriendNum++;
                Toast.makeText(getApplicationContext(), "Friend Added",
                        Toast.LENGTH_LONG).show();
                }

            }
        }
    }
