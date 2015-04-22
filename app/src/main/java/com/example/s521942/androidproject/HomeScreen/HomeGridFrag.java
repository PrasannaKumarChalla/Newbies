package com.example.s521942.androidproject.HomeScreen;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.s521942.androidproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeGridFrag extends Fragment {
    public static String [] prgmNameL={"Events","Incoming Students","Accomodation & facilities","Store locations","Conatct info","Bridge"};
    public static int [] prgmImage={R.drawable.events,R.drawable.students,R.drawable.home,R.drawable.store,R.drawable.contact,R.drawable.a};
    //MainActivity mainActivity=new MainActivity();
    TextView welcome;
    Typeface typeface;

    public HomeGridFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_grid, container, false);
        typeface= Typeface.createFromAsset(view.getContext().getAssets(), "fonts/Transformers.ttf");
        welcome=(TextView)view.findViewById(R.id.eventTitle);
        welcome.setTypeface(typeface);
        GridView gridView=(GridView)view.findViewById(R.id.homeGrid);
        gridView.setAdapter(new CustomAdapter(getActivity(), prgmNameL,prgmImage));
        return view;

    }


}
