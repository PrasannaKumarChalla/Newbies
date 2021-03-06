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

import com.example.s521942.androidproject.Accomodations.Accomodation;
import com.example.s521942.androidproject.Accomodations.AccomodationName;
import com.example.s521942.androidproject.Accomodations.AccomodationWeb;
import com.example.s521942.androidproject.Bridge.BridgeFargment;
import com.example.s521942.androidproject.ContactInfo.ContactFragment;
import com.example.s521942.androidproject.Events.EventsFragment;
import com.example.s521942.androidproject.HomeScreen.HomeGridFrag;
import com.example.s521942.androidproject.IncomingStudents.IncomingListFragment;
import com.example.s521942.androidproject.IncomingStudents.RegistrationFragment;
import com.example.s521942.androidproject.StoreLocations.StoresMap;


public class MainActivity extends Activity implements AccomodationName.OnAccomodationInteractionListener {
GridView gv;
TextView welcome;
Typeface typeface;
FragmentTransaction fragmentTransaction;
FragmentManager fragmentManager;
HomeGridFrag homeGridFrag;
EventsFragment eventsFragment;
StoresMap storesMap;
RegistrationFragment registrationFragment;
BridgeFargment bridgeFargment;
IncomingListFragment incomingListFragment;


    AccomodationName accomodationName;
    ContactFragment contactFragment;

//adding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


accomodationName=new AccomodationName();
        homeGridFrag=new HomeGridFrag();
       eventsFragment=new EventsFragment();
        registrationFragment=new RegistrationFragment();
        bridgeFargment=new BridgeFargment();
        storesMap=new StoresMap();
        contactFragment=new ContactFragment();
        incomingListFragment=new IncomingListFragment();

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
    public void onStoresClick(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,storesMap);
        fragmentTransaction.addToBackStack("Stores");
        fragmentTransaction.commit();
    }
    public void onBridgeClick(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,bridgeFargment);
        fragmentTransaction.addToBackStack("bridge");
        fragmentTransaction.commit();

    }
    public void onAccomodateClick(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,accomodationName);
        //fragmentTransaction.remove(homeGridFrag);
        fragmentTransaction.addToBackStack(null);
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
    public void onContactClicked(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,contactFragment);
        //fragmentTransaction.remove(homeGridFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void onNeedPickup(){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.remove(incomingListFragment);
        fragmentTransaction.replace(R.id.mainFrameLayout,registrationFragment);
        //fragmentTransaction.remove(homeGridFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onAccomodationSelected(Accomodation.DummyItem di) {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.remove(accomodationName);
        AccomodationWeb accomodationWeb=new AccomodationWeb();
        fragmentTransaction.replace(R.id.mainFrameLayout,AccomodationWeb.newInstance(di.url));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
