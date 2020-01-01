package com.bartechspaceship.recyclerview;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StarWarsDataModel {
    //Declare member variables
    private String mTitle;
    private String mOpening_crawl;
    private String mDirector;
    private String mProducer;
    private String mRelease_date;

    public StarWarsDataModel(String title, String opening_crawl, String director, String producer, String release_date) {
        mTitle = title;
        mOpening_crawl = opening_crawl;
        mDirector = director;
        mProducer = producer;
        mRelease_date = release_date;
    }

    /* //create a StarWarsDataModel from a JSON
    public static StarWarsDataModel fromJson(JSONObject jsonObject){

        StarWarsDataModel starWarsData = new StarWarsDataModel();
        try {
            starWarsData.mTitle = jsonObject.getString("title");
            //episode id is inside of results and its index 4 inside episode id - this will signify what you are calling
            //starWarsData.mEpisode_id = jsonObject.getJSONArray("results").getJSONObject(4).getInt("episode_id");
            starWarsData.mOpening_crawl=jsonObject.getString("opening_crawl");
            starWarsData.mDirector=jsonObject.getString("director");
            starWarsData.mProducer=jsonObject.getString("producer");
            starWarsData.mRelease_date=jsonObject.getString("release_date");
            //starWarsData.mCharacters = jsonObject.getJSONArray("characters").getString();
            //starWarsData.updateStarWarsFilms(starWarsData.mEpisode_id);//WTF IS THIS LOL I THINK I GET IT
            return starWarsData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
    */


    /*private static String updateStarWarsFilms(int episode_id){
        if(episode_id==4){
            return updateStarWarsFilms(4);
        }else if(episode_id==5){
            return updateStarWarsFilms(5);
        }else{
            return null;
        }
    }*/

    public String getTitle() {
        return mTitle;
    }

    public String getOpening_crawl() {
        return mOpening_crawl;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getProducer() {
        return mProducer;
    }

    public String getRelease_date() {
        return mRelease_date;
    }

    public ArrayList getCharacters() {
        return mCharacters;
    }
}

