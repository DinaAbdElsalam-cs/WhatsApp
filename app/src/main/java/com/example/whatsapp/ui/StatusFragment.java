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
import com.example.whatsapp.data.model.StatusModel;
import com.example.whatsapp.ui.adapter.StatusAdapter;

import java.util.ArrayList;


public class StatusFragment extends Fragment {


    RecyclerView statusRecycler;
    ArrayList<StatusModel>status=new ArrayList<>();
    StatusAdapter statusAdapter;

    public StatusFragment() {
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
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler(view);
    }

    private void setupRecycler(View view){
        status.add(new StatusModel(R.drawable.image5,"Mamy"));
        status.add(new StatusModel(R.drawable.image9,"My Bro"));


        statusRecycler=view.findViewById(R.id.status_recycler);
        statusAdapter=new StatusAdapter(status);
        statusRecycler.setAdapter(statusAdapter);
        statusRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.status_option_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.status_privacy)
            Toast.makeText(getActivity(), "status privecy", Toast.LENGTH_SHORT).show();
        if(id==R.id.settings2)
            Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}