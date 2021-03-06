package com.example.s521942.androidproject.Accomodations;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.s521942.androidproject.R;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>

 * interface.
 */
public class AccomodationName extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    CardView cv;
RelativeLayout rl;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    LayoutInflater inflater = getActivity().getLayoutInflater();
    private OnAccomodationInteractionListener mListener;

    // TODO: Rename and change types of parameters
    public static AccomodationName newInstance(String param1, String param2) {
        AccomodationName fragment = new AccomodationName();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AccomodationName() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // TODO: Change Adapter to display your content
        setListAdapter(new ArrayAdapter<Accomodation.DummyItem>(getActivity(), R.layout.accomodations,R.id.name, Accomodation.ITEMS){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater li=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = li.inflate(R.layout.accomodations,parent,false);
                TextView tv=(TextView)view.findViewById(R.id.name);
//                rl=(RelativeLayout)view.findViewById(R.id.rl);
//                rl.setBackgroundResource(getItem(position).imageID);
                cv=(CardView)view.findViewById(R.id.card);
                cv.setBackgroundResource(getItem(position).imageID);

                tv.setText(getItem(position).id);
                ObjectAnimator obj=ObjectAnimator.ofFloat(tv,"Y",375f);
                obj.setDuration(3000);
                obj.start();
//                ImageView iv=(ImageView)view.findViewById(R.id.imageView);
//                iv.setImageResource(getItem(position).imageID);
                return view;
            }
        });
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnAccomodationInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnAccomodationInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onAccomodationSelected(Accomodation.ITEMS.get(position));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnAccomodationInteractionListener {
        // TODO: Update argument type and name
        public void onAccomodationSelected(Accomodation.DummyItem di);
    }

}
