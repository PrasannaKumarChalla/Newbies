package com.example.s521942.androidproject.IncomingStudents;


import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.s521942.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
Button btn1;
String msg;
String name,id,email,pickup,date,time;
    String test="kumar";
    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_registration, container, false);
        btn1= (Button) v.findViewById(R.id.register);
        final EditText nameEt=(EditText)v.findViewById(R.id.nameET);
        final EditText idEt=(EditText)v.findViewById(R.id.idET);
        final EditText emailEt=(EditText)v.findViewById(R.id.emailET);
        final EditText pickupEt=(EditText)v.findViewById(R.id.pickupET);
        final EditText dateEt=(EditText)v.findViewById(R.id.dateET);
        final EditText timeEt=(EditText)v.findViewById(R.id.timeET);


      //msg="Hey there I need a Pickup on "+date+" at "+time+ ". Following are my details.\n "+name+" \n"+email +" \n Pickup Location"+pickup;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameEt.getText().toString();
                id=idEt.getText().toString();
                email=emailEt.getText().toString();
                pickup=pickupEt.getText().toString();
                date=dateEt.getText().toString();
                time=timeEt.getText().toString();
                msg="Hey there I need a Pickup on "+date+" at "+time+ ". Following are my details.\n "+name+" \n"+email +" \n Pickup Location: "+pickup;
                Dialog d=new Dialog();
                d.show(getFragmentManager(),"Your request has been noticed.");
                new DownloadFilesTask().execute(msg);
            }
        });
        return v;



    }

    private class DownloadFilesTask extends AsyncTask<String, Integer, Long>{

        @Override
        protected Long doInBackground(String... params) {
            try {
                GMailSender sender = new GMailSender("isapickups@gmail.com", "isapicks");
                sender.sendMail("Need Pickup",
                        params[0],
                        "jagan4204@gmail.com",
                        "jagan4204@gmail.com");
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
         return null;
        }
    }

}
