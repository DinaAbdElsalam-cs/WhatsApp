package com.example.whatsapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.example.whatsapp.data.model.CallsModel;

import java.util.List;

public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.CallsHolder>{

    private List<CallsModel>call;

    public CallsAdapter(List<CallsModel> call) {
        this.call = call;
    }

    @NonNull
    @Override
    public CallsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calls_layout,parent,false);
        return new CallsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallsHolder holder, int position) {

        CallsModel callsmodel=call.get(position);
        holder.userCallImage.setImageResource(callsmodel.getUserCallImage());
        holder.userCallName.setText(callsmodel.getUserCallName());
    }

    @Override
    public int getItemCount() {
        if(call!=null)
            return call.size();
        return 0;
    }

    static class CallsHolder extends RecyclerView.ViewHolder
    {
        ImageView userCallImage;
        TextView userCallName;

        public CallsHolder(@NonNull View itemView) {
            super(itemView);

            userCallImage=itemView.findViewById(R.id.userImage_calls);
            userCallName=itemView.findViewById(R.id.username_calls);
        }
    }
}
