package com.example.s521942.androidproject.StoreLocations;


import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s521942.androidproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresMap extends Fragment {

    static final LatLng locat = new LatLng(21 , 57);
    private GoogleMap mMap;
    Marker mMarker;
    LocationManager lm;
    private Marker[] placeMarkers;
    private final int MAX_PLACES = 20;
    private MarkerOptions[] places;
    String placesSearchStr;
    Double lat,lng;

    private String[] ListOfIntersts={"store","food","hospital","night_club"};


    public StoresMap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_stores_map, container, false);
           setUpMapIfNeeded();
        String provider=lm.getBestProvider(new Criteria(), true);
        Location loc=lm.getLastKnownLocation(provider);
        lat=loc.getLatitude();lng=loc.getLongitude();
        placesSearchStr="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=1000&types=food&key=AIzaSyBeHb9mtrDW4oiBWIDgnToBm4uwItxt8uA";

        new GetPlaces().execute(placesSearchStr);

           return view;
    }

    private GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            mMap.clear();
            LatLng latlng=new LatLng(location.getLatitude(),location.getLongitude());// This methods gets the users current longitude and latitude.
            mMarker = mMap.addMarker(new MarkerOptions().position(latlng).title("You are here"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));//Moves the camera to users current longitude and latitude
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15.0f));//Animates camera and zooms to preferred state on the user's current location.
            new GetPlaces().execute(placesSearchStr);
        }
    };
    private void setUpMapIfNeeded(){
        if (mMap == null) {
            mMap = ((MapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        }
    if (mMap != null) {
               mMap.setMyLocationEnabled(true);//Makes the users current location visible by displaying a blue dot.
               mMap.setOnMyLocationChangeListener(myLocationChangeListener);
              mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
              placeMarkers = new Marker[MAX_PLACES];
               mMap.getUiSettings().setZoomControlsEnabled(true);
             lm =(LocationManager)getActivity().getSystemService(getActivity().LOCATION_SERVICE);//use of location services by firstly defining location manager.
                String provider=lm.getBestProvider(new Criteria(), true);
                Location loc=lm.getLastKnownLocation(provider);

                if (loc!=null){
                    myLocationChangeListener.onMyLocationChange(loc);
                }
            }


    }



    private class GetPlaces extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... placesURL) {
           // return null;
            StringBuilder placesBuilder = new StringBuilder();
            //process search parameter string(s)
            for (String placeSearchURL : placesURL) {
//execute search
                HttpClient placesClient = new DefaultHttpClient();
                try {
                    //try to fetch the data
                    HttpGet placesGet = new HttpGet(placeSearchURL);
                    HttpResponse placesResponse = placesClient.execute(placesGet);
                    StatusLine placeSearchStatus = placesResponse.getStatusLine();
                    if (placeSearchStatus.getStatusCode() == 200) {
//we have an OK response
                        HttpEntity placesEntity = placesResponse.getEntity();
                        InputStream placesContent = placesEntity.getContent();
                        InputStreamReader placesInput = new InputStreamReader(placesContent);
                        BufferedReader placesReader = new BufferedReader(placesInput);
                        String lineIn;
                        while ((lineIn = placesReader.readLine()) != null) {
                            placesBuilder.append(lineIn);
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            return placesBuilder.toString();
        }

        @Override
        protected void onPostExecute(String result) {


//            if(placeMarkers!=null){
//                for(int pm=0; pm<placeMarkers.length; pm++){
//                    if(placeMarkers[pm]!=null)
//                        placeMarkers[pm].remove();
//                }
//            }

            try {
                //parse JSON
                JSONObject resultObject = new JSONObject(result);
                JSONArray placesArray = resultObject.getJSONArray("results");
                places = new MarkerOptions[placesArray.length()];
                //loop through places
                for (int p=0; p<placesArray.length(); p++) {
                    //parse each place
                    LatLng placeLL=null;
                    String placeName="";
                    String vicinity="";
                    boolean missingValue=false;
                    try{
                        missingValue=false;
                        JSONObject placeObject = placesArray.getJSONObject(p);
                        JSONObject loc = placeObject.getJSONObject("geometry").getJSONObject("location");
                        placeLL = new LatLng(Double.valueOf(loc.getString("lat")),Double.valueOf(loc.getString("lng")));
                        JSONArray types = placeObject.getJSONArray("types");
                        for(int t=0; t<types.length(); t++){
                            //what type is it
                            String thisType=types.get(t).toString();

                        }
                        vicinity = placeObject.getString("vicinity");
                        placeName = placeObject.getString("name");


                        //attempt to retrieve place data values
                    }
                    catch(JSONException jse){
                        missingValue=true;
                        jse.printStackTrace();
                    }
                    if(missingValue)  places[p]=null;
                    else
                        places[p]=new MarkerOptions()
                                .position(placeLL)
                                .title(placeName)
                                .snippet(vicinity);
                }


            }
            catch (Exception e) {
                e.printStackTrace();
            }
            if(places!=null && placeMarkers!=null){
                for(int p=0; p<places.length && p<placeMarkers.length; p++){
                    //will be null if a value was missing
                    if(places[p]!=null)
                        placeMarkers[p]=mMap.addMarker(places[p]);
                }
            }

        }
    }



}
