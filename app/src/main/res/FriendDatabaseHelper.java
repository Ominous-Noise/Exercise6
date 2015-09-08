import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.id12020261.exercise6.FriendData;

/**
 * Created by Nathan on 9/6/2015.
 */
public class FriendDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "friendlist";
    private static final String TABLE_CONTACTS = "friends";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CITY = "city";
    private static final String KEY_SINCE = "friend since";
    private static final String KEY_OCCUPATION = "Occupation";


    public FriendDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CITY + " TEXT" + ")"
                + KEY_OCCUPATION + " TEXT" + ")"
                + KEY_SINCE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }
    public addFriend(FriendData friendData)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, friendData.getName()); // Contact Name
        values.put(KEY_CITY, friendData.getCity()); // Contact Phone Number
        values.put(KEY_OCCUPATION, friendData.getOccupation());
        values.put(KEY_SINCE, friendData.getSince());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }



}
