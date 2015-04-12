package com.example.s521942.androidproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends Activity {
GridView gv;
TextView welcome;
    public static String [] prgmNameList={"Events","Incoming Students","Accomodation & facilities","Store locations","Conatct info","Bridge"};
    public static int [] prgmImages={R.drawable.events,R.drawable.students,R.drawable.home,R.drawable.store,R.drawable.contact,R.drawable.a};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Transformers.ttf");
        welcome=(TextView)findViewById(R.id.welcome);
        welcome.setTypeface(typeface);

        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
