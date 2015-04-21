package com.example.s521942.androidproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.s521942.androidproject.Events.EventsFragment;
import com.example.s521942.androidproject.HomeScreen.HomeGridFrag;
import com.example.s521942.androidproject.IncomingStudents.RegistrationFragment;


public class MainActivity extends Activity {
GridView gv;
TextView welcome;
Typeface typeface;
FragmentTransaction fragmentTransaction;
FragmentManager fragmentManager;
    HomeGridFrag homeGridFrag;
    EventsFragment eventsFragment;
    RegistrationFragment registrationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       typeface=Typeface.createFromAsset(getAssets(),"fonts/Transformers.ttf");
        welcome=(TextView)findViewById(R.id.welcome);
        welcome.setTypeface(typeface);
        homeGridFrag=new HomeGridFrag();
       eventsFragment=new EventsFragment();
        registrationFragment=new RegistrationFragment();

       fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFrameLayout,homeGridFrag);
        fragmentTransaction.addToBackStack("home grid Fragment");
        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onEventsClick(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,eventsFragment);
        fragmentTransaction.addToBackStack("events fragment");
        fragmentTransaction.commit();
    }
    public void onIncomingClick(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,registrationFragment);
        fragmentTransaction.addToBackStack("events fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }
}
