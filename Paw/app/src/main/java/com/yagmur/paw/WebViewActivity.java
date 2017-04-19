package com.yagmur.paw;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

/**
 * Created by Yagmur on 19.4.2017.
 */

@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        Init();
    }

    // TODO: 19.4.2017 Burasi cok bagimli duzelecek.
    private void Init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Objects.equals(getIntent().getExtras().getString("TextId", getResources().getString(R.string.temizmama)), getResources().getString(R.string.temizmama))) {
            toolbar.setTitle("Temiz Mama");
        } else {
            toolbar.setTitle("Mama Sepati");
        }
        toolbar.setSubtitle(getIntent().getExtras().getString("TextId", getResources().getString(R.string.temizmama)));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        webView = (WebView) this.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(getIntent().getExtras().getString("TextId", getResources().getString(R.string.temizmama)));
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
