package com.example.s521942.androidproject.Bridge;


import android.app.Fragment;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.s521942.androidproject.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class BridgeFargment extends Fragment {

    ListView lv;
    VideoView videoView;


    String[] bridgeList = {"CULTURE IN USA", "PLACES TO EXPLORE", "ABOUT UNIVERSITY"};

    public BridgeFargment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bridge, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        videoView = (VideoView) view.findViewById(R.id.video);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        playVideo("v1");
                      break;
                    case 1:
                        playVideo("v3");
                        break;
                    case 2:
                        playVideo("v2");
                        break;
                }
            }
        });
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.bridgelistlayout,R.id.textView9, bridgeList));

        return view;
    }


    private void playVideo(String fileName) {
        if (videoView != null && !videoView.isPlaying()) {

            videoView.setVisibility(View.VISIBLE);
            Uri videoPath = Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + fileName);

            videoView.setVideoURI(videoPath);
             android.widget.MediaController mediaControl = new android.widget.MediaController(getActivity());
            videoView.setMediaController(mediaControl);
            videoView.start();
        }else{
            videoView.stopPlayback();
            playVideo(fileName);
        }

    }


}

