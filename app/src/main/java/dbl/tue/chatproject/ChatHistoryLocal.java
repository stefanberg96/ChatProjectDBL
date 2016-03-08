package dbl.tue.chatproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.util.Log;

/**
 * Created by Christian on 8-3-2016.
 */
public class ChatHistoryLocal {
    public String colMessages;
    private ChatHistoryLocalHelper localHelper;
    String colSender = ChatHistoryContract.FeedEntry.COLUMN_SENDER;
    String colTimestamp = ChatHistoryContract.FeedEntry.COLUMN_TIMESTAMP;
    String colMessage = ChatHistoryContract.FeedEntry.COLUMN_MESSAGE;

    ChatHistoryLocal(Context ctx){
        localHelper = new ChatHistoryLocalHelper(ctx);

    }
    public void saveToDevice(Message msg, User currentUser){
        int tableId;    // will be used to have multiple id's to create different tables for different persons

        // Gets the data repository in write mode
        SQLiteDatabase db = localHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(colSender, msg.getSender().getUserID());
        values.put(colTimestamp, msg.getTimestamp());
        values.put(colMessage, msg.getData());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;

        if(msg.getSender().getUserID() == currentUser.getUserID()){
            tableId = msg.getRecipient().getUserID();
        }else{
            tableId = msg.getSender().getUserID();
        }

        newRowId = db.insert(
                ChatHistoryContract.FeedEntry.TABLE_NAME,
                ChatHistoryContract.FeedEntry.COLUMN_NULLABLE,
                values);

    }

    public void getMessages(){
        SQLiteDatabase db = localHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ChatHistoryContract.FeedEntry._ID,
                colSender,
                colMessage,
                colTimestamp
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                colTimestamp + " DESC";


        String selection = colTimestamp+ " = ( SELECT MAX(" + colTimestamp + "))";

        Cursor cursor = db.query(
                ChatHistoryContract.FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(ChatHistoryContract.FeedEntry._ID)
        );
        String msgData = cursor.getString(
                cursor.getColumnIndex(colMessage)
        );
        Log.v("ChatHistoryLocal", msgData);

    }
}



