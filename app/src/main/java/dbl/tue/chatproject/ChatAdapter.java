package dbl.tue.chatproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ChatAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    ArrayList<Message> messages;
    ListView chatMessageList;
    User currentUser;

    public ChatAdapter(Activity activity, ArrayList ChatMessage,ListView list,User currentUser) {
        chatMessageList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.currentUser=currentUser;
        messages=ChatMessage;
        chatMessageList=list;
        Collections.sort(messages);
        Collections.reverse(messages);

    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = (Message) messages.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.chatbubble, null);

        TextView msg = (TextView) vi.findViewById(R.id.message_text);
        msg.setText(message.data);
        LinearLayout layout = (LinearLayout) vi
                .findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = (LinearLayout) vi
                .findViewById(R.id.bubble_layout_parent);

        // if message is mine then align to right
        if (message.sender==currentUser.userID) {
            layout.setBackgroundResource(R.drawable.bubble2);
            parent_layout.setGravity(Gravity.RIGHT);
        }
        // If not mine then align to left
        else {
            layout.setBackgroundResource(R.drawable.bubble1);
            parent_layout.setGravity(Gravity.LEFT);
        }
        msg.setTextColor(Color.BLACK);
        return vi;
    }

    public void update(Context context) {
        messages= new ChatHistoryLocal(context).getMessages(10);
        Collections.sort(messages);
        Collections.reverse(messages);
    }
    public void update(Context context , int n, SwipeRefreshLayout swipe) {
        messages= new ChatHistoryLocal(context).getMessages(n);
        Collections.sort(messages);
        Collections.reverse(messages);
        swipe.setRefreshing(false);
    }
}