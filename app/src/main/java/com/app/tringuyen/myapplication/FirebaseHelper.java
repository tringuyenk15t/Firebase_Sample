package com.app.tringuyen.myapplication;

import com.app.tringuyen.myapplication.model.ChatItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Tri Nguyen on 9/14/2016.
 */
public class FirebaseHelper {

    private static FirebaseHelper instance;
    private DatabaseReference firebaseClinent;
    private final  String CHAT_COLLECTION = "demo-chat";

    private FirebaseHelper ()
    {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);//store data in local until internet connection work
        firebaseClinent = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseHelper getInstance()
    {
        if (instance == null)
        {
            instance = new FirebaseHelper();
        }
        return instance;
    }

    public DatabaseReference getFirebaseClinent() {
        return firebaseClinent;
    }

    public String saveChatItem(ChatItem chatItem)
    {
        DatabaseReference chatCollectionRef =  firebaseClinent.child(CHAT_COLLECTION);
        DatabaseReference newChatItem = chatCollectionRef.push();
        newChatItem.setValue(chatItem);
        return newChatItem.getKey();
    }

    public DatabaseReference getChatFirebaseClient() {
        return firebaseClinent.child(CHAT_COLLECTION);
    }
}
