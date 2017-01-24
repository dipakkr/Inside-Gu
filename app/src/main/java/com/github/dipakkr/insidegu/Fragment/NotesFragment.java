package com.github.dipakkr.insidegu.Fragment;


import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.dipakkr.insidegu.R;

/**
 * Created by deepak on 20-01-2017.
 */

public class NotesFragment extends Fragment {
    private static final String DRIVE_URL = "https://www.google.com";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notes_fragment,container,false);
        WebView webView = (WebView)rootView.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
                 @Override
                 public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                     view.loadUrl(DRIVE_URL);
                     return true;
                 }

                 @Override
                 public void onPageStarted(WebView view, String url, Bitmap favicon) {
                     super.onPageStarted(view, url, favicon);
                 }

                 @Override
                 public void onPageFinished(WebView view, String url) {
                     super.onPageFinished(view, url);
                 }

                 @Override
                 public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                     super.onReceivedError(view, request, error);
                 }
             });
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl(DRIVE_URL);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DRIVE_URL));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"Downloads");
                DownloadManager downloadManager = (DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });

        return rootView;
    }

}
