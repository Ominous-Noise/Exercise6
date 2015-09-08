package com.id12020261.exercise6;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class addFriendActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        Button cancelButton = (Button) findViewById(R.id.add_friend_cancel_button);
        Button confirmButton = (Button) findViewById(R.id.add_friend_confirm_button);
        cancelButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_friend, menu);
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

    @Override
    public void onClick(View v) {

        EditText nameText=(EditText)findViewById(R.id.add_friend_name_editText);
        EditText occupationText=(EditText)findViewById(R.id.add_friend_occupation_editText);
        EditText cityText=(EditText)findViewById(R.id.add_friend_city_editText);

        String friendName = nameText.getText().toString();
        String friendOccupation = occupationText.getText().toString();
        String friendCity = cityText.getText().toString();


        switch (v.getId()) {
            case R.id.add_friend_cancel_button:
                super.finish();
                break;
            case R.id.add_friend_confirm_button:
                Intent intent = new Intent();
                intent.putExtra("name",friendName);
                intent.putExtra("occupation",friendOccupation);
                intent.putExtra("city",friendCity);
                setResult(RESULT_OK, intent);
                super.finish();
                break;

        }
    }
}
