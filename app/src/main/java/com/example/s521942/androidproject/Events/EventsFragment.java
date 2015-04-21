package com.example.s521942.androidproject.Events;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.s521942.androidproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    static String Connectiontest="nothing yet";
    TextView textView;
    String JsonToParse;
    ProgressDialog dialog;

    final String url = "http://192.168.0.14:3000/api/events";
    private List<Event> events ;
    SimpleDateFormat dateFormat;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter adapter;
    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_events,container,false);
        events= new ArrayList<Event>();
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_viewEvents);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        new AsyncHttpTask().execute(url);



       // textView.setText(Connectiontest);


        return view;
    }




    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Loading Events...");
            dialog.show();
        }

        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            Integer result = 0;
            HttpURLConnection urlConnection = null;

            try {
                /* forming th java.net.URL object */
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                /* for Get request */
                urlConnection.setRequestMethod("GET");
                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode ==  200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }

                    parseResult(response.toString());

                    //Connectiontest=events.get(0).getName();
                    result = 1; // Successful
                }else{
                    result = 0; //"Failed to fetch data!";
                }

            } catch (Exception e) {
                Log.d("Cant connect", e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
                adapter = new MyRecyclerAdapter(getActivity(), events);
            mRecyclerView.setAdapter(adapter);

         dialog.dismiss();
        }
    }

    private void parseResult(String result) {
        try {

            JSONArray EventsJArray=new JSONArray(result);
           // textView.setText(EventsJArray.getJSONObject(0).toString());

//            /*Initialize array if null*/
//            if (null == events) {
//                events = new ArrayList<Event>();
//            }

            for (int i = 0; i <=EventsJArray.length(); i++) {
                JSONObject eventJObj = EventsJArray.getJSONObject(i);
                //textView.setText(eventJObj.getString("date"));
                //dateFormat=new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss.SSSZ");
                Event item = new Event(eventJObj.getString("name"),eventJObj.getString("desc"),eventJObj.getString("date").substring(0,10));
                events.add(item);

            }
            //textView.setText("hello");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dialog= new ProgressDialog(activity);
    }
}
