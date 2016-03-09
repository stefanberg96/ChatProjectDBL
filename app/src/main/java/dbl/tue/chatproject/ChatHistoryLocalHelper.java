package dbl.tue.chatproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christian on 8-3-2016.
 */
public class ChatHistoryLocalHelper extends SQLiteOpenHelper{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "messages.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ChatHistoryContract.FeedEntry.TABLE_NAME + " (" +
                    ChatHistoryContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    ChatHistoryContract.FeedEntry.COLUMN_PERSON + TEXT_TYPE + COMMA_SEP +
                    ChatHistoryContract.FeedEntry.COLUMN_SENDER + TEXT_TYPE + COMMA_SEP +
                    ChatHistoryContract.FeedEntry.COLUMN_MESSAGE + TEXT_TYPE + COMMA_SEP +
                    ChatHistoryContract.FeedEntry.COLUMN_TIMESTAMP + TEXT_TYPE + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ChatHistoryContract.FeedEntry.TABLE_NAME;

    public ChatHistoryLocalHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
