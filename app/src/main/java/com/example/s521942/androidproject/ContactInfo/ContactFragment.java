package com.example.s521942.androidproject.ContactInfo;


import android.app.Fragment;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.s521942.androidproject.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class ContactFragment extends Fragment {

Typeface tf;
Outline ol;
    CardView cv;
    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v= inflater.inflate(R.layout.fragment_contact, container, false);
        cv=(CardView) v.findViewById(R.id.card2);
        TextView presidentBox=(TextView)v.findViewById(R.id.PresidentBox);
        tf=Typeface.createFromAsset(v.getContext().getAssets(),"fonts/batmfa.ttf");
        presidentBox.setTypeface(tf);
        TextView presidentname=(TextView)v.findViewById(R.id.presidentName);
        presidentname.setTypeface(tf);
        TextView presidentNum=(TextView)v.findViewById(R.id.PresidentNumber);
        presidentNum.setTypeface(tf);
        TextView presidentMail=(TextView)v.findViewById(R.id.PresidentMail);
        presidentMail.setTypeface(tf);
        TextView vicepresidentBox=(TextView)v.findViewById(R.id.VicePresidentBox);

        vicepresidentBox.setTypeface(tf);
        TextView vicepresidentname=(TextView)v.findViewById(R.id.VicePresidentName);
        vicepresidentname.setTypeface(tf);
        TextView vicepresidentNum=(TextView)v.findViewById(R.id.VicePresidentNumber);
        vicepresidentNum.setTypeface(tf);
        TextView vicepresidentMail=(TextView)v.findViewById(R.id.VicePresidentMail);
        vicepresidentMail.setTypeface(tf);















        return v;
    }


}
