package com.example.anandika.anandikanuriman_1202150112_modul6;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class fragmenthomeuser extends Fragment {
    RecyclerView rv;
    DatabaseReference ref;
    ArrayList<databasepost> list;
    adapterpost adapter;

    public fragmenthomeuser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmenthomeuser, container, false);
        ref = FirebaseDatabase.getInstance().getReference().child("post");
        list = new ArrayList<>();
        adapter = new adapterpost(list, this.getContext());
        rv = v.findViewById(R.id.rvhomeuser);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(adapter);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                databasepost cur = dataSnapshot.getValue(databasepost.class);
                if (cur.getUser().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())){
                    cur.key = dataSnapshot.getKey();
                    list.add(cur);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }

}
