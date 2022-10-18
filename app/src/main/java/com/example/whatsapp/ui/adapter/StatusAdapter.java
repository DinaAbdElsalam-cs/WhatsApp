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
import com.example.whatsapp.data.model.StatusModel;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusHolder> {

    private List<StatusModel>status;

    public StatusAdapter(List<StatusModel> status) {
        this.status = status;
    }

    @NonNull
    @Override
    public StatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_status_layout,parent,false);
        return new StatusHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StatusHolder holder, int position) {
        StatusModel statusmodel=status.get(position);
        holder.statusImage.setImageResource(statusmodel.getStatusImage());
        holder.userStatusName.setText(statusmodel.getUserStatusName());
    }

    @Override
    public int getItemCount() {
        if(status!=null)
            return status.size();
        return 0;
    }

    static class StatusHolder extends RecyclerView.ViewHolder{

        ImageView statusImage;
        TextView userStatusName;

        public StatusHolder(@NonNull View itemView) {
            super(itemView);
            statusImage=itemView.findViewById(R.id.status_image);
            userStatusName=itemView.findViewById(R.id.user_status_name);

        }
    }
}
