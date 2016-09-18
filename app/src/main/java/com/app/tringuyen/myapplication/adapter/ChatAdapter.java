package com.app.tringuyen.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tringuyen.myapplication.R;
import com.app.tringuyen.myapplication.model.ChatItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tri Nguyen on 9/9/2016.
 */
public class ChatAdapter extends RecyclerView.Adapter{
    private List<ChatItem> items = new ArrayList<>();

    public ChatAdapter (List<ChatItem> items)
    {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_send_message,parent,false);
        ChatViewHolder holder = new ChatViewHolder(v);
//        ChatViewHolder holder = new ChatViewHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChatViewHolder)holder).tv_message.setText(items.get(position).getMessage());
    }

    private class ChatViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tv_message;
        public ChatViewHolder(View itemView) {
            super(itemView);
            tv_message = (TextView) itemView.findViewById(R.id.tv_message);
        }
    }

    public int getItemCount() {
        return items.size();
    }
}
