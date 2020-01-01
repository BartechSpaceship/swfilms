package com.bartechspaceship.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentEpisode4 extends Fragment {
    public TextView mTitle;
    public RequestQueue mQueue;
    //public Context mContext;

    //private ArrayList mCharacters; Comment out for now



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode4, container, false);

        mTitle = view.findViewById(R.id.title);
        mQueue = Volley.newRequestQueue(getActivity());

        jsonParse();
        return view;
    }


    /*private void jsonRequest(View v) {
        final TextView mTitle;
        mTitle = (TextView) v.findViewById(R.id.title);
        String url = "https://swapi.co/api/films";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //JSONArray jsonArray = response.getJSONArray(0);
                            mTitle.setText("Response: " + response.getJSONObject(0).toString()
                                    .substring(0, 50));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        VolleyHelper.getInstance(v.getContext()).addToRequestQueue(jsonArrayRequest);
    }*/

    public void jsonParse() {

        //final TextView mTitle;
        //mTitle = (TextView) v.findViewById(R.id.title);
        String url = "https://swapi.co/api/films";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            //Comment what result is
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                String title = result.getString("title");
                                String openingCrawl = result.getString("opening_crawl");
                                String director = result.getString("director");
                                String producer = result.getString("producer");
                                String release_date = result.getString("release_date");



                                //int age = result.getInt("age");
                                //String mail = result.getString("mail");

                                //mTitle.setText(title);//Was previously append

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast toast = new Toast(getActivity());
                            //toast.makeText(getActivity(), "Call Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
