package com.example.s521942.androidproject.IncomingStudents;


import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.s521942.androidproject.MainActivity;
import com.example.s521942.androidproject.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class IncomingListFragment extends Fragment {

    String [] homeScreenOptions={"Need a pick up?","Temporary Accomdation","utilities"};
    String [] explanation={"register here for a pickup","fill here, we will reach through mail","what you need to get?"};
    ListView listView;
    public IncomingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_incoming_list, container, false);
        listView=(ListView)view.findViewById(R.id.incomingLV);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), R.layout.icominglistrow, R.id.listhead,homeScreenOptions) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view1 = super.getView(position, convertView, parent);
                TextView tv1 = (TextView) view1.findViewById(R.id.listhead);
TextView newText=(TextView)view1.findViewById(R.id.listhead2);
                tv1.setText(homeScreenOptions[position]);
    newText.setText(explanation[position]);

                Typeface funky= Typeface.createFromAsset(getActivity().getAssets(), "fonts/funky.otf");
                tv1.setTypeface(funky);
                Typeface Lemon= Typeface.createFromAsset(getActivity().getAssets(), "fonts/funky.otf");
                newText.setTypeface(Lemon);
                return view1;
            }

        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ((MainActivity) getActivity()).onNeedPickup();
                }
            }
        });


            return view;
    }


    }


