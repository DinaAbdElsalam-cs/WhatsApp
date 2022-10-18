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
import com.example.whatsapp.data.model.CallsModel;
import com.example.whatsapp.ui.adapter.CallsAdapter;

import java.util.ArrayList;


public class CallsFragment extends Fragment {

    RecyclerView callRecycler;
    ArrayList<CallsModel>call=new ArrayList<>();
    CallsAdapter callsAdapter;

    public CallsFragment() {
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
        return inflater.inflate(R.layout.fragment_calls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupcallsRecycler(view);
    }

    private void setupcallsRecycler(View view)
    {
        call.add(new CallsModel(R.drawable.image15,"Mamy"));
        call.add(new CallsModel(R.drawable.image7,"My Bro"));

        callRecycler=view.findViewById(R.id.call_recycler);
        callsAdapter=new CallsAdapter(call);
        callRecycler.setAdapter(callsAdapter);
        callRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.calls_option_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.clear)
            Toast.makeText(getActivity(), "clear call log", Toast.LENGTH_SHORT).show();
        if(id==R.id.settings3)
            Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}