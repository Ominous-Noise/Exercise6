package com.id12020261.exercise6;

import java.util.ArrayList;

/**
 * Created by Nathan on 9/6/2015.
 */
public class FriendData {

    int mId;
    String mName;
    String mOccupation;
    String mCity;
    long mFriendSince;

    public FriendData(int Id,String name,String occupation,String city,long friendSince)
    {
        mId = Id;
        mName = name;
        mOccupation = occupation;
        mCity = city;
        mFriendSince = friendSince;

    }
    public static ArrayList<FriendData> GetFriends() {

        ArrayList<FriendData> friends = new ArrayList<FriendData>();


        return friends;
    }

    public int getID(){
        return mId;
    }
    public String getName(){
        return mName;
    }
    public String getOccupation(){
        return mOccupation;
    }
    public String getCity(){
        return mCity;
    }
    public long getSince(){
        return mFriendSince;
    }

    public void setID(int id){
        mId = id;
    }
    public void setName(String name){
        mName = name;
    }
    public void setOccupation(String occupation){
        mOccupation = occupation;
    }
    public void setCity(String city){
        mCity = city;
    }
    public void setSince(long since){mFriendSince = since;}


}
