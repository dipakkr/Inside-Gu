package com.github.dipakkr.insidegu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by deepak on 15-02-2017.
 */

public class StoryFragment extends Fragment {
    private static String URL = "https://www.facebook.com/humansofGalgotiasOfficial/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_story,container,false);
        WebView webView = (WebView)root.findViewById(R.id.HogView);
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl(URL);
        return root;
    }
}
