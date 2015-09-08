package com.id12020261.exercise6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nathan on 9/6/2015.
 */
public class FriendDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "friendlist";
    private static final String TABLE_FRIENDS = "friends";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CITY = "city";
    private static final String KEY_SINCE = "friend since";
    private static final String KEY_OCCUPATION = "Occupation";

    private static Connection DBConnection;


    public FriendDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CITY + " TEXT" + ")"
                + KEY_OCCUPATION + " TEXT" + ")"
                + KEY_SINCE + " TEXT" + ")";
        db.execSQL(CREATE_FRIENDS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<FriendData> getAllFriends()
    {
        // Select All Query
        String selectQuery = "SELECT * FROM friendlist";
        // Get the isntance of the database
        SQLiteDatabase db = this.getWritableDatabase();
        //get the cursor you're going to use
        Cursor cursor = db.rawQuery(selectQuery, null);

        //this is optional - if you want to return one object
        //you don't need a list
        ArrayList<FriendData> friendList = new ArrayList<FriendData>();

        //you should always use the try catch statement incase
        //something goes wrong when trying to read the data
        try
        {
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    //the .getString(int x) method of the cursor returns the column
                    //of the table your query returned
                    FriendData friend= new FriendData(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            Long.parseLong(cursor.getString(6)));
                    // Adding contact to list
                    friendList.add(friend);
                } while (cursor.moveToNext());
            }
        }
        catch (SQLiteException e)
        {
            Log.d("SQL Error", e.getMessage());
            return null;
        }
        finally
        {
            //release all your resources
            cursor.close();
            db.close();
        }
        return friendList;
    }

    public void addFriend(FriendData friendData)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, friendData.getName()); // Contact Name
        values.put(KEY_CITY, friendData.getCity()); // Contact Phone Number
        values.put(KEY_OCCUPATION, friendData.getOccupation());
        values.put(KEY_SINCE, friendData.getSince());

        // Inserting Row
        db.insert(TABLE_FRIENDS, null, values);
        db.close(); // Closing database connection
    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("friendlist", null, null);
    }



}
