package com.comp.smartfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class eaadhar extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eaadhar);

        webView = (WebView) findViewById(R.id.eaadhar);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://uidai.gov.in/my-aadhaar/get-aadhaar.html");
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
