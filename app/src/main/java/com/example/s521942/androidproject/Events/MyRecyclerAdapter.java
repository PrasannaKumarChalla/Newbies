package com.example.s521942.androidproject.Events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s521942.androidproject.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by S521942 on 4/19/2015.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<EventsRowHolder> {
    private final LayoutInflater inflater;
    private List<Event> eventList= Collections.emptyList();

    public MyRecyclerAdapter(Context context,List<Event> eventList) {
        inflater= LayoutInflater.from(context);
        this.eventList=eventList;
    }

    @Override
    public EventsRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.events_row,parent,false);
        EventsRowHolder eventsRowHolder=new EventsRowHolder(view);
        return eventsRowHolder;
    }

    @Override
    public void onBindViewHolder(EventsRowHolder holder, int position) {
        Event currentEvent=eventList.get(position);
        holder.name.setText(currentEvent.getName());
        holder.desc.setText(currentEvent.getDesc());
        holder.date.setText(currentEvent.getDate().toString());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
