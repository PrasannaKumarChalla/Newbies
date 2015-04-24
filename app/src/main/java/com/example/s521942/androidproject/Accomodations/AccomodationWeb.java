package com.example.s521942.androidproject.Accomodations;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class AccomodationWeb extends WebViewFragment {

    private static String newurl;
    WebView wv;
    private static final String URL = "url";

//    public String newurl;
    public AccomodationWeb() {
        // Required empty public constructor
    }

    public static AccomodationWeb newInstance(String url) {
        AccomodationWeb fragment = new AccomodationWeb();
        Bundle args = new Bundle();
        newurl=url;
        args.putString(URL, url);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        WebView w = getWebView();
        w.setWebViewClient(new WebViewClient());
        w.loadUrl(newurl);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        wv=(WebView)super.onCreateView(inflater,container,savedInstanceState);
        return wv;

    }


}
