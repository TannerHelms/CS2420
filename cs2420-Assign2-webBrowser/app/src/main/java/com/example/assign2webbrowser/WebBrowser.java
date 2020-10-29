package com.example.assign2webbrowser;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

public class WebBrowser extends WebView {
    public WebBrowser(@NonNull Context context, WebViewClient webViewClient) {
        super(context);
        setWebViewClient(webViewClient);
        loadUrl("https://usu.edu");
    }
}
