package com.app.tringuyen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.app.tringuyen.myapplication.model.ChatItem;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.util.List;

public class firebaseUI extends AppCompatActivity {
    private RecyclerView listItems;
    private RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ui);

        FirebaseRecyclerAdapter<ChatItem,MessageViewHolder> adapter = new FirebaseRecyclerAdapter<ChatItem, MessageViewHolder>(
            ChatItem.class,
                R.layout.layout_send_message,
                MessageViewHolder.class,
                FirebaseHelper.getInstance().getChatFirebaseClient()) {
            @Override
            protected void populateViewHolder(MessageViewHolder viewHolder, ChatItem model, int position) {
                viewHolder.message.setText(model.getMessage());
            }
        };

        manager = new LinearLayoutManager(this);
        listItems = (RecyclerView) findViewById(R.id.chatItems);
        listItems.setLayoutManager(manager);
        listItems.setAdapter(adapter);
    }

    private static class MessageViewHolder extends RecyclerView.ViewHolder
    {
        private TextView message;
        public MessageViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.tv_message);
        }
    }
}
