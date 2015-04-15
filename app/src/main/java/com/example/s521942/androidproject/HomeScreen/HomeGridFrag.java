package com.example.s521942.androidproject.HomeScreen;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.s521942.androidproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeGridFrag extends Fragment {
    public static String [] prgmNameL={"Events","Incoming Students","Accomodation & facilities","Store locations","Conatct info","Bridge"};
    public static int [] prgmImage={R.drawable.events,R.drawable.students,R.drawable.home,R.drawable.store,R.drawable.contact,R.drawable.a};
    //MainActivity mainActivity=new MainActivity();

    public HomeGridFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_grid, container, false);
        GridView gridView=(GridView)view.findViewById(R.id.homeGrid);
        gridView.setAdapter(new CustomAdapter(getActivity(), prgmNameL,prgmImage));
        return view;

    }


}
