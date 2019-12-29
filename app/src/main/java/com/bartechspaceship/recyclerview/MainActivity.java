package com.bartechspaceship.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;//bridge between array list and recycler view
    private RecyclerView.LayoutManager mLayoutManager;
    private ViewPager mViewPager;
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem("Title Of Film 1", "Release Date"));
        exampleList.add(new ExampleItem("Title Of Film 2", "Release Date2"));
        exampleList.add(new ExampleItem("Title Of Film 3", "Release Date3"));
        exampleList.add(new ExampleItem("Title Of Film 4", "Release Date4"));
        exampleList.add(new ExampleItem("Title Of Film 5", "Release Date5"));
        exampleList.add(new ExampleItem("Title Of Film 6", "Release Date6"));

        mRecyclerView = findViewById(R.id.recyclerView);
        //Set it to true if the recycle view doesnt change in size
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);



        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.containter);

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentEpisode4(), "Fragment1");
        adapter.addFragment(new FragmentEpisode5(), "Fragment2");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }


}
