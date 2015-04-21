package com.example.s521942.androidproject.Events;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.s521942.androidproject.R;

/**
 * Created by S521942 on 4/19/2015.
 */
public class EventsRowHolder extends RecyclerView.ViewHolder {
//    Context context;
//
//    public EventsRowHolder(View itemView, Context context) {
//        super(itemView);
//        this.context = context;
//    }

    TextView name;
    TextView desc;
    TextView date;

    public EventsRowHolder(View itemView) {
        super(itemView);
        Typeface typeface=Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/Lmilk.otf");
        Typeface funky=Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/funky.otf");
        name=(TextView)itemView.findViewById(R.id.EventNameTV);
        name.setTypeface(funky);
        desc=(TextView)itemView.findViewById(R.id.EventDescTV);
        desc.setTypeface(typeface);
        date=(TextView)itemView.findViewById(R.id.EventDateTV);
        date.setTypeface(typeface);
    }
}
