package com.app.tringuyen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.app.tringuyen.myapplication.adapter.ChatAdapter;
import com.app.tringuyen.myapplication.model.ChatItem;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ChatItem> items;
    private RecyclerView.LayoutManager manager;
    private ChatAdapter adapter;
    private RecyclerView recyclerView;
    private DatabaseReference mDatabaseReference;

    private EditText editText;
    private ImageButton btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();

        adapter = new ChatAdapter(items);

        editText = (EditText) findViewById(R.id.edit_text_message);
        btnSend = (ImageButton) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                ChatItem chatItem = new ChatItem();
                chatItem.setMessage(message);

                //save message to Firebase
                FirebaseHelper.getInstance().saveChatItem(chatItem);
                editText.setText("");
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv_chat_container);
        manager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        FirebaseHelper.getInstance().getChatFirebaseClient().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatItem chatItem = new ChatItem(dataSnapshot);
                items.add(chatItem);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(adapter.getItemCount() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
