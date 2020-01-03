/*package com.bartechspaceship.recyclerview;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import com.bartechspaceship.recyclerview.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {
    private HttpURLConnection mHttpURLConnection;
    InputStream mInputStream;
    String data="";
    String dataParsed="";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://swapi.co/api/films");

            mHttpURLConnection = (HttpURLConnection) url.openConnection();
            mInputStream = mHttpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mInputStream));
            String line= "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i=0 ;i<JA.length();i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = ""+JO.get("title");

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(dataParsed);

    }
}
*/