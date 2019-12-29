package com.bartechspaceship.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    private Context mContext;
    private ArrayList<ExampleItem> mExampleItems;
    public ViewPager

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        public TextView mTextView2;
        CardView mCardView;

        public ExampleViewHolder(View itemView){
            super(itemView);
            //if i want image ill add it here find view by id
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mCardView = itemView.findViewById(R.id.cardViewItem);
        }

    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem exampleItem = mExampleItems.get(position);
        //Was previously ExampleItem currentItem = mExampleList.get(position);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });




        holder.mTextView1.setText(exampleItem.getText1());//Was previously currentItem
        holder.mTextView2.setText(exampleItem.getText2());//Was previously currentItem


    }
     //Have to define howmany items are going to be in the list
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
