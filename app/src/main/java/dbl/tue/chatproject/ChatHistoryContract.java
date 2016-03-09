package dbl.tue.chatproject;

import android.provider.BaseColumns;

/**
 * Created by Christian on 8-3-2016.
 */
public final class ChatHistoryContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ChatHistoryContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "allmessages";
        public static final String COLUMN_PERSON = "person";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_MESSAGE = "message";
        public static final String COLUMN_NULLABLE = "NOMESSAGEINPUT";
    }
}