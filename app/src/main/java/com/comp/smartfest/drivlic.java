package com.comp.smartfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class drivlic extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivlic);

        webView = (WebView) findViewById(R.id.drivlic);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://parivahan.gov.in/rcdlstatus/?pur_cd=101");
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
