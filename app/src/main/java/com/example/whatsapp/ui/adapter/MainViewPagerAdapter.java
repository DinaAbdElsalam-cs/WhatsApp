package com.example.whatsapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.whatsapp.ui.CallsFragment;
import com.example.whatsapp.ui.ChatFragment;
import com.example.whatsapp.ui.StatusFragment;

public class MainViewPagerAdapter extends FragmentStateAdapter {

    private int count;
    public MainViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle ,int count) {
        super(fragmentManager, lifecycle);
        this.count=count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ChatFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
        }

        return new Fragment();
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
