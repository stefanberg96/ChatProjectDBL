package dbl.tue.chatproject;

/**
 * dbl.tue.chatproject.Message class
 */
public class Message {
    String data;
    User recipient;
    User sender;
    double timestamp;

    Message(String data){
        this.data=data;
        timestamp=System.currentTimeMillis();
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

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
