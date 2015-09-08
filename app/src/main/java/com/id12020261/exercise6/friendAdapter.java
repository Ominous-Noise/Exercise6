package com.id12020261.exercise6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nathan on 8/29/2015.
 */
public class friendAdapter extends ArrayAdapter<FriendData> {

    //Constructor for trainAdapter
    public friendAdapter(Context context, ArrayList<FriendData> friends) {
        super(context, 0, friends);
    }


    //Override GetView to set the custom adapter and aply data from trainData
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FriendData friend = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population

        //Declatartion of layout items
        final TextView list_name = (TextView) convertView.findViewById(R.id.list_item_name);
        final TextView list_occupation = (TextView) convertView.findViewById(R.id.list_item_occupation);
        final TextView list_lives = (TextView) convertView.findViewById(R.id.list_item_lives);
        final TextView list_since = (TextView) convertView.findViewById(R.id.list_item_since);


        // Populate the data into the template view using the data object
        list_name.setText(friend.mName);
        list_occupation.setText("Occupation: "+ friend.mOccupation);
        list_lives.setText("Lives: "+ friend.mCity);
        list_since.setText("Friend Since: "+ (Long.toString(friend.mFriendSince)));


        ImageButton list_delete = (ImageButton) convertView.findViewById(R.id.list_delete);

        // Set on Click listener on linear layout
        list_delete.setOnClickListener(new View.OnClickListener()
        {
            //Overriide onclick to call Asynctask and generate random number
            @Override
            public void onClick(View v)
            {





            }
        });


        // Return the completed view to render on screen
        return convertView;
    }
}
