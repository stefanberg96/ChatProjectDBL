package dbl.tue.chatproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * dbl.tue.chatproject.Message class
 */
public class Message {
    String data;
    User recipient;
    User sender;
    String timestamp;

    Message(String data){
        this.data=data;
        timestamp = getDateTime();
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
