package com.bartechspaceship.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ExampleViewHolder> {

    String FILM_URL = "https://swapi.co/api/films/";
    private ArrayList<Character> mCharacterList;
    //private String mTitle;
    //ToDo Change <String> to <Character>

    private Context mContext;
    //private ArrayList<ExampleItem> mExampleItems;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        //public TextView mTextView2;
        //CardView mCardView;

        public ExampleViewHolder(View itemView){
            super(itemView);
            //if i want image ill add it here find view by id
            mTextView1 = itemView.findViewById(R.id.characterName);
            //mTextView2 = itemView.findViewById(R.id.textView2);
            //mCardView = itemView.findViewById(R.id.cardViewItem);
        }

    }



    public HorizontalAdapter(Context mContext, ArrayList<Character> characterList){
        this.mCharacterList = characterList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_test,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        final Character character = mCharacterList.get(position);


        //Was previously ExampleItem currentItem = mExampleList.get(position);

        /*//Just added from tutorial
        fetchData process = new fetchData();
        process.execute();*/

        holder.mTextView1.setText(character.getName());//Was previously currentItem




    }
    //Havle to define howmany items are going to be in the ist
    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }


    public void updateCharacters(ArrayList<Character> characters) {
        mCharacterList.clear();
        mCharacterList.addAll(characters);
        notifyDataSetChanged();
    }



}
