package dbl.tue.chatproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * dbl.tue.chatproject.Message class
 */
public class Message implements Comparable<Message> {
    String data;
    int recipient;
    int sender;
    String timestamp;

    Message(String data, int senderid, int receiverid){
        this.data=data;
        timestamp = getDateTime();
        this.sender=senderid;
        this.recipient=receiverid;
    }

    Message(String data, int senderid, int receiverid, String timestamp){
        this.data=data;
        this.timestamp = timestamp;
        this.sender=senderid;
        this.recipient=receiverid;
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

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Message another) {
        SimpleDateFormat df= new SimpleDateFormat();

        return - this.timestamp.compareTo(another.timestamp);
    }
}
