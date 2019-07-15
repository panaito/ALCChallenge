package com.jafriam.alc_challenge;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.jafriam.Constants.WebUrl;


public class AboutAlc extends MainActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_about );

        webView = findViewById( R.id.webViewID );

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled( true );
        WebView.setWebContentsDebuggingEnabled( false );
        webView.getSettings().setAppCacheEnabled( true );
        webView.getSettings().setSupportZoom( true );
        webView.setHorizontalScrollBarEnabled( false );
        webView.setVerticalScrollBarEnabled( false );
        settings.setDomStorageEnabled( true );
        settings.setLayoutAlgorithm( WebSettings.LayoutAlgorithm.NARROW_COLUMNS );
        settings.setUseWideViewPort( true );


        webView.setWebViewClient( new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted( view, url, favicon );
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished( view, url );
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        } );
        webView.loadUrl( WebUrl.WEB_URL );

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
        }return true;
    }
}