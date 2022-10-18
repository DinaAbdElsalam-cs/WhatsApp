package com.example.whatsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsapp.R;
import com.example.whatsapp.data.model.ChatModel;
import com.example.whatsapp.ui.adapter.ChatAdapter;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    RecyclerView chatRecycler;
    ArrayList<ChatModel>users=new ArrayList<>();
    ChatAdapter chatAdapter;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler(view);
    }

    private void setupRecycler(View view)
    {
        users.add(new ChatModel(R.drawable.image11,"Mamy","Hi"));
        users.add(new ChatModel(R.drawable.image8,"Samaka","Hello"));
        users.add(new ChatModel(R.drawable.image12,"Soso","welcome"));
        users.add(new ChatModel(R.drawable.image5,"Shrouk","Hi "));
        users.add(new ChatModel(R.drawable.image9,"Sahar","Hello"));
        users.add(new ChatModel(R.drawable.image6,"Mai","welcome"));
        users.add(new ChatModel(R.drawable.image7,"Hager","Hi"));
        users.add(new ChatModel(R.drawable.image15,"My Bro","Hello "));
        users.add(new ChatModel(R.drawable.image11,"Mamy","Hi"));
        users.add(new ChatModel(R.drawable.image8,"Samaka","Hello"));
        users.add(new ChatModel(R.drawable.image12,"Soso","welcome"));

        chatRecycler=view.findViewById(R.id.chat_recycler);
        chatAdapter=new ChatAdapter(users);
        chatRecycler.setAdapter(chatAdapter);
        chatRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.chat_option_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item)


    {
        int id=item.getItemId();
        if(id==R.id.new_group)
        {
            Toast.makeText(getActivity(), "new_group", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.new_broadcast)
        {
            Toast.makeText(getActivity(), "new_broadcast", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.linked_devices)
        {
            Toast.makeText(getActivity(), "linked_devices", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.starred_message)
        {
            Toast.makeText(getActivity(), "starred_message", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.setting1)
        {
            Toast.makeText(getActivity(), "settings", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.search)
        {
            Toast.makeText(getActivity(), "search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}