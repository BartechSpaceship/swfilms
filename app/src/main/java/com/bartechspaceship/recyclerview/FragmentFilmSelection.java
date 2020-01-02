package com.bartechspaceship.recyclerview;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class FragmentFilmSelection extends Fragment {

    //private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;//bridge between array list and recycler view
    private RecyclerView.LayoutManager mLayoutManager;

    //View is first created.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_film_selection, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final FragmentActivity c = getActivity();

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        //First fragment is just main page
        exampleList.add(new ExampleItem("A New Hope", "1977-05-25"));//Movie4
        exampleList.add(new ExampleItem("The Empire Strkies Back", "1980-05-17"));//Movie5
        exampleList.add(new ExampleItem("Title Of Film 3", "Release Date3"));//Movie6
        exampleList.add(new ExampleItem("Title Of Film 4", "Release Date4"));//Movie1
        exampleList.add(new ExampleItem("Title Of Film 5", "Release Date5"));//Movie2
        exampleList.add(new ExampleItem("Title Of Film 6", "Release Date6"));//Movie3




        //Set it to true if the recycle view doesnt change in size
        recyclerView.setHasFixedSize(true);

        mAdapter = new ExampleAdapter(getActivity(), exampleList);
        mLayoutManager = new LinearLayoutManager(c);





        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        //mRecyclerView = (RecyclerView) view.getRootView().findViewById(R.id.recyclerView);






        return view;
    }

    //After view was created, OnViewCreated is called.

}
