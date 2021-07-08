package com.example.kcetcollegepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomWebViewClient client = new CustomWebViewClient(this);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://share.streamlit.io/vishnusastryhk/kcetcollegepredictor/KCETCollegePredictor.py");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

class CustomWebViewClient extends WebViewClient implements CustomWebViewClient1 {
    private Activity activity;
    public CustomWebViewClient(Activity activity){
        this.activity = activity;
    }
    //API level less than 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
        return false;
    }
    //API level >= 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
        return false;
    }
}
