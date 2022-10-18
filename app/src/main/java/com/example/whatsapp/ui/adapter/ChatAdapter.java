package com.example.whatsapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.example.whatsapp.data.model.ChatModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder>{

    private List<ChatModel>users;

    public ChatAdapter(List<ChatModel> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_layout,parent,false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        ChatModel userModel=users.get(position);
        holder.profileImage.setImageResource(userModel.getProfileImage());
        holder.username.setText(userModel.getUserName());
        holder.chatText.setText(userModel.getChatText());

    }

    @Override
    public int getItemCount() {
        if(users!=null)
            return users.size();
        return 0;
    }

    static class ChatHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView username,chatText;

        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profile_image);
            username=itemView.findViewById(R.id.user_name);
            chatText=itemView.findViewById(R.id.chat_text);
        }
    }

}
