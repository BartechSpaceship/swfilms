package com.bartechspaceship.recyclerview;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

//Soppoused to be called Recycler view adapter
//Need viewholder to hold the widgets in memory, aka the pictures and shit and layouts and shit
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "Recycle View Adapter Testing In progress";
    //Vars
    private ArrayList<String> mNamesJSON = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mContext;//Create new constructor for all 3 of these

    public RecyclerViewAdapter(Context context, ArrayList<String> namesJSON, ArrayList<String> imageUrls) {
        mNamesJSON = namesJSON;
        mImageUrls = imageUrls;
        mContext = context;
    }

    //All methods required to use recycle view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // HERE I AM REFERENCING FRAGMENT LAYOUT, inflates each individual layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override// Here is where all the widgets get attached to each individual list item
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);//THIS WILL ATTACH IMGAGES -- MIGHT BE REMOVED

        holder.nameJSON.setText(mNamesJSON.get(position));// Here the JSON name will be placed the code might be removed

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image: " + mNamesJSON.get(position));
                // I dont need an onclick listener but it looks cool
                Toast.makeText(mContext,mNamesJSON.get(position), Toast.LENGTH_SHORT).show();//This will be cool though

            }
        });
    }

    @Override//Returns the number of items that will be in the list
    public int getItemCount() {
        return mNamesJSON.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView nameJSON;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //now it refers to xml image from fragment_layout
            image = itemView.findViewById(R.id.image);
            nameJSON = itemView.findViewById(R.id.nameJSON);
        }
    }

}
