package com.asashka.instagrama.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asashka.instagrama.MainActivity;
import com.asashka.instagrama.R;
import com.asashka.instagrama.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    RecyclerView recyclerView;
    PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.home_recycler);
        adapter = new PostAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setPosts(((MainActivity) getActivity()).posts);

        //List<Post> list = new ArrayList<>();
        //list.add(new Post("https://www.w3schools.com/html/img_girl.jpg", ""))
    }
}