package dbl.tue.chatproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatProject extends AppCompatActivity {
    ChatHistoryLocal chatHistoryLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView msgListView= (ListView) findViewById(R.id.listView);


        final User sender = new User();
        sender.userID = 1234;
        final User receiver = new User();
        sender.userID = 5678;
        chatHistoryLocal = new ChatHistoryLocal(this);
        final ChatAdapter chatAdapter=new ChatAdapter(this,chatHistoryLocal.getMessages(),msgListView,receiver);
        msgListView.setAdapter(chatAdapter);
        final TextView messagetext = (TextView) findViewById(R.id.editText);
        messagetext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (!messagetext.equals("\n")) {
                        sendMessage(messagetext, sender, receiver, chatAdapter);
                    }

                }
                return false;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendMessage(messagetext,sender,receiver,chatAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_chat_project, menu);
        return true;
    }

    public void sendMessage(TextView messagetext, User sender, User receiver,ChatAdapter chatAdapter){
        String data = messagetext.getText().toString();
        if(!data.isEmpty()) {
            Log.v("ChatHistoryLocal", data);

            Message message = new Message(data.replaceAll("\n",""), sender.getUserID(), receiver.getUserID());
            chatHistoryLocal.saveToDevice(message, sender);
            messagetext.setText("");
            chatAdapter.update(getApplicationContext());
            chatAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
