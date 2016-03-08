package dbl.tue.chatproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

/**
 * Created by Christian on 8-3-2016.
 */
public class ChatHistoryLocal {
    public String messages;
    private ChatHistoryLocalHelper localHelper;


    ChatHistoryLocal(Context ctx){
        localHelper = new ChatHistoryLocalHelper(ctx);

    }
    public void saveToDevice(Message msg, User currentUser){
        int tableId;

        // Gets the data repository in write mode
        SQLiteDatabase db = localHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ChatHistoryContract.FeedEntry.COLUMN_SENDER, msg.getSender().getUserID());
        values.put(ChatHistoryContract.FeedEntry.COLUMN_TIMESTAMP, msg.getTimestamp());
        values.put(ChatHistoryContract.FeedEntry.COLUMN_MESSAGE, msg.getData());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;

        if(msg.getSender().getUserID() == currentUser.getUserID()){
            tableId = msg.getRecipient().getUserID();
        }else{
            tableId = msg.getSender().getUserID();
        }

        newRowId = db.insert(
                ChatHistoryContract.FeedEntry.TABLE_NAME + tableId,
                ChatHistoryContract.FeedEntry.COLUMN_NULLABLE,
                values);
    }

    public void getMessages(User otherUser){
//        SQLiteDatabase db = mDbHelper.getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                ChatHistoryContract.FeedEntry._ID,
//                ChatHistoryContract.FeedEntry.COLUMN_NAME_TITLE,
//                ChatHistoryContract.FeedEntry.COLUMN_NAME_UPDATED,
//
//        };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                ChatHistoryContract.FeedEntry.COLUMN_NAME_UPDATED + " DESC";
//
//        Cursor c = db.query(
//                ChatHistoryContract.FeedEntry.TABLE_NAME,  // The table to query
//                projection,                               // The columns to return
//                selection,                                // The columns for the WHERE clause
//                selectionArgs,                            // The values for the WHERE clause
//                null,                                     // don't group the rows
//                null,                                     // don't filter by row groups
//                sortOrder                                 // The sort order
//        );
    }
}



