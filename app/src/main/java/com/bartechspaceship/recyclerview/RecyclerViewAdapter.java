package com.bartechspaceship.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "Recycle View Adapter Testing In progress";
    private ArrayList<Character> mCharacterList;
    private Context mContext;//Create new constructor for all 3 of these

    public RecyclerViewAdapter(Context context, ArrayList<Character> characterList ) {
        this.mCharacterList = characterList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_test,parent,false);
        return new ViewHolder(view);
    }

    @Override// Here is where all the widgets get attached to each individual list item
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        //final Character character = mCharacterList.get(position);

        holder.mTextView.setText(mCharacterList.get(position).getName());

        //holder.nameJSON.setText(mNamesJSON.get(position));// Here the JSON name will be placed the code might be removed

    }

    @Override//Returns the number of items that will be in the list
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //CircleImageView image;
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //now it refers to xml image from fragment_layout
            //image = itemView.findViewById(R.id.image);
            mTextView = itemView.findViewById(R.id.characterName);
        }
    }

}
