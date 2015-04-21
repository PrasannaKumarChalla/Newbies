package com.example.s521942.androidproject.IncomingStudents;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.s521942.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dialog extends DialogFragment {
AlertDialog ad;

    public Dialog() {
        // Required empty public constructor
    }

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build=new AlertDialog.Builder(getActivity());
        build.setMessage("Registration Successful");
        build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad=build.create();
        return ad;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }


}
