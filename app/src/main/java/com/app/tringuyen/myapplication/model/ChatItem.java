package com.app.tringuyen.myapplication.model;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Tri Nguyen on 9/15/2016.
 */
public class ChatItem {
    private String message;
    private boolean fromMe;
//    private String sendingDate;
//    private String senderName;
//    private String receiverName;

    public ChatItem ()
    {

    }

    public ChatItem (String message, boolean fromMe)
    {
        this.message = message;
        this.fromMe = fromMe;
//        this.sendingDate = date;
//        this.senderName = senderName;
//        this.receiverName = receiverName;
    }

    public ChatItem(DataSnapshot dataSnapshot) {
        ChatItem tempItem = dataSnapshot.getValue(ChatItem.class);
        this.setMessage(tempItem.getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
