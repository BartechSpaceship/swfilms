package com.bartechspaceship.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.VolleyLog.TAG;

public class FragmentEpisode4 extends Fragment {
    private TextView mTitle;
    private TextView mOpeningCrawl;
    private TextView mDirectorTitle;
    private TextView mProducer;
    private TextView mReleaseDate;
    public RequestQueue mQueue;
    public RequestQueue mQueue2;
    private ArrayList<StarWarsDataModel> mStarWarsDataModels;
    private int episodeNum;
    private RecyclerView recyclerView;
    private ArrayList<CharacterURL> characterURLs;
    private StarWarsDataModel mStarWarsDataModel;


    //Character Names
    private Character mCharacter;
    private ArrayList<Character> mCharacters;

    //public Context mContext;

    //private ArrayList mCharacters; Comment out for now

    //Names for testing


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode4, container, false);


        //mTitle = view.findViewById(R.id.title);

        //Character URLs


        View rootView = inflater.inflate(R.layout.resource_test, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView2);
        final FragmentActivity c = getActivity();


        //recyclerView = view.findViewById(R.id.recyclerView2);
        mTitle = view.findViewById(R.id.title);
        mOpeningCrawl = view.findViewById(R.id.opening_crawl);
        mDirectorTitle = view.findViewById(R.id.director);
        mProducer = view.findViewById(R.id.producer);
        mReleaseDate = view.findViewById(R.id.release_date);


        //for testing purposes


        //Holds characters in each movie.
        mCharacters = new ArrayList<>();



        mQueue = Volley.newRequestQueue(getActivity());
        mQueue2 = Volley.newRequestQueue(getActivity());

        mStarWarsDataModels = new ArrayList<>();//Change mStarWarsDataModel to something like mStarWarsArray
        episodeNum = 4;

        //mCharacters.get()




        //Might have to make a seperate thread

        //NAMES FOR TESTING
        /*
        mNames = new ArrayList<>();

        mNames.add("Darth");

        mNames.add("Luke");

        mNames.add("bob");

         */

        //hardcoded initRecyclerView

        jsonParse();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(layoutManager);
        HorizontalAdapter adapter = new HorizontalAdapter(c, mCharacters);
        recyclerView.setAdapter(adapter);

        return view;

    }


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

                                characterURLs = new ArrayList();

                                String title = result.getString("title");
                                String openingCrawl = result.getString("opening_crawl");
                                String director = result.getString("director");
                                String producer = result.getString("producer");
                                String release_date = result.getString("release_date");
                                int episode_id = result.getInt("episode_id");
                                //Characters
                                JSONArray characters = result.getJSONArray("characters");
                                for (int j = 0; j < characters.length(); j++) {
                                    //JSONObject result2 = characters.getJSONObject(j); //- DOES NOT NEED TO BE CONVERTED TO JSONObject, already a string.
                                    CharacterURL characterURL = new CharacterURL(characters.getString(j));
                                    characterURLs.add(characterURL);
                                    //characterURLs.add(characters.getString(j));
                                    Log.d(TAG, "onResponse5:" + characterURLs);
                                    //JSONObject name = characters.getJSONObject(j);
                                    //Character character = new Character(name);
                                    //mCharacters.add(character);
                                }



                                mStarWarsDataModel = new StarWarsDataModel(title, openingCrawl, director, producer, release_date, episode_id, mCharacters);
                                mStarWarsDataModel.setCharacterURLS(characterURLs);
                                getCharactersFromJson(mStarWarsDataModel);


                                mStarWarsDataModels.add(mStarWarsDataModel);


                                //int age = result.getInt("age");
                                //String mail = result.getString("mail");

                                //mTitle.setText(title);//Was previously append
                                setTextViews(mStarWarsDataModels);

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


    public void setTextViews(ArrayList<StarWarsDataModel> starWarsDataModels) {
        for (StarWarsDataModel starWarsDataModel : starWarsDataModels) {
            if (starWarsDataModel.getEpisode_id() == episodeNum) {
                mTitle.setText(starWarsDataModel.getTitle());
                mOpeningCrawl.setText(starWarsDataModel.getOpening_crawl());
                mDirectorTitle.setText(starWarsDataModel.getDirector());
                mProducer.setText(starWarsDataModel.getProducer());
                mReleaseDate.setText(starWarsDataModel.getRelease_date());
                mCharacters = starWarsDataModel.getCharacters();

            }

        }
    }


    public void getCharactersFromJson(StarWarsDataModel starWarsDataModel) {


        //String url = "https://swapi.co/api/people";
        //String url = starWarsDataModel.getCharacterURLS();

        for (String url : starWarsDataModel.getCharacterURLStoString()) {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {


                                String name = response.get("name").toString();
                                //JSONArray jsonArray = response.getJSONArray("name");

                                Log.d(TAG, "onResponseTest: " + name);

                                mStarWarsDataModel.addCharacter(new Character(name));

                            } catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue2.add(request);

        }

        }



        }


