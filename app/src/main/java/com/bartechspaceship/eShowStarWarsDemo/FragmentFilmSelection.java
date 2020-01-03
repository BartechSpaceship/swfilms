package com.bartechspaceship.eShowStarWarsDemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        exampleList.add(new ExampleItem("Return of the Jedi", "1983-05-25"));//Movie6
        exampleList.add(new ExampleItem("The Phantom Menace", "1999-05-19"));//Movie1
        exampleList.add(new ExampleItem("Attack of the Clones", "2002-05-16"));//Movie2
        exampleList.add(new ExampleItem("Revenge of the Sith", "2005-05-19"));//Movie3
        exampleList.add(new ExampleItem("The Force Awakens", "2015-12-11"));//Movie3





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
