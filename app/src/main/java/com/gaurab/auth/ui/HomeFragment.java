package com.gaurab.auth.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaurab.auth.R;
import com.gaurab.auth.data.pojo.UserResponse;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class HomeFragment extends Fragment {

    private static final String ARG_USER = "user";
    private UserResponse user;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(UserResponse user) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (UserResponse) getArguments().getSerializable(ARG_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView(view);
    }

    private void initializeView(View view){
        TextView welcomeMsg = view.findViewById(R.id.welcomeMessage);
        welcomeMsg.setText("welcome " + user.getName());
    }
}