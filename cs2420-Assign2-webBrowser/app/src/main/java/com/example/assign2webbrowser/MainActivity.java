package com.example.assign2webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Create a layout for the browser
        LinearLayout webLayout = new LinearLayout(this);
        webLayout.setOrientation(LinearLayout.VERTICAL);
        final WebBrowser webBrowser = new WebBrowser(this, new WebViewClient());
        webLayout.addView(webBrowser);

        // Create a queue that will hold the history
        final Queue historyQueue = new Queue();
        historyQueue.Add("https://usu.edu");

        // Create a navigation bar
        final NavigationBar navigationBar = new NavigationBar(this);
        navigationBar.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (historyQueue.Previous()) {
                    webBrowser.loadUrl(historyQueue.GetUrl());
                    navigationBar.url.setText(historyQueue.GetUrl());
                }
            }
        });
        navigationBar.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUrl = navigationBar.url.getText().toString();
                historyQueue.Add(newUrl);
                webBrowser.loadUrl(newUrl);
            }
        });
        navigationBar.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (historyQueue.Next()) {
                    webBrowser.loadUrl(historyQueue.GetUrl());
                    navigationBar.url.setText(historyQueue.GetUrl());
                }
            }
        });



        // Add everything to the main layout
        mainLayout.addView(navigationBar);
        mainLayout.addView(webLayout);
        setContentView(mainLayout);

    }
}