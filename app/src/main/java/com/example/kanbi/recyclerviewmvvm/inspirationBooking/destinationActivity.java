package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.bokaResa.kryssningWeb;

public class destinationActivity extends AppCompatActivity {

    private String WebURL="https://www.ving.se/langsemester";
    private WebView webView;
    private ProgressBar progressBar;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        Toolbar toolbar=(Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);

        frameLayout=(FrameLayout) findViewById(R.id.framelayout);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        webView=(WebView) findViewById(R.id.sistaWeb);
        webView.setWebViewClient(new destinationActivity.HelpClient());
        webView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view,int progress){
                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);

                setTitle("Loading...");

                if(progress==100){
                    frameLayout.setVisibility(View.GONE);
                    setTitle(view.getTitle());

                }
                super.onProgressChanged(view, progress);
            }
        });
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.loadUrl(WebURL);
        progressBar.setProgress(0);

    }
    private class HelpClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            frameLayout.setVisibility(View.VISIBLE);
            return true;
        }


    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK)    {
            if (webView.canGoBack()){
                webView.goBack();
                return true;
            }

        }
        return super.onKeyDown(keyCode, event)   ;
    }




}
