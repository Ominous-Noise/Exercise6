package com.id12020261.exercise6;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListAllActivity extends ActionBarActivity {

    friendAdapter mAdapter;
    FriendDataBaseHelper nFriendhelper;
    ArrayList<FriendData> arrayOfFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        populateFriendList();
    }
    public void populateFriendList() {
        // Construct the data source
        ArrayList<FriendData> arrayOfFriends = nFriendhelper.getAllFriends();
        // Create the adapter to convert the array to views
        mAdapter = new friendAdapter(this, arrayOfFriends);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_all_friend_list);
        listView.setAdapter((ListAdapter) mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_all, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
