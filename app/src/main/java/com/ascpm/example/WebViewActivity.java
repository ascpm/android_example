package com.ascpm.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button goButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
        bindEvent();
    }

    private void bindEvent() {
        this.urlEditText.setOnEditorActionListener((v, i, e) -> {
            if (KeyEvent.ACTION_DOWN == e.getAction() && KeyEvent.KEYCODE_ENTER == e.getKeyCode()) {
                goButton.callOnClick();
                return true;
            }

            return false;
        });
        this.goButton.setOnClickListener(v -> {
            String url = urlEditText.getText().toString();

            if (!"".equals(url)) {
                webView.loadUrl(url);
            }
        });
    }

    private void initView() {
        this.urlEditText = EditText.class.cast(findViewById(R.id.urlEditText));
        this.goButton = Button.class.cast(findViewById(R.id.goButton));
        this.webView = WebView.class.cast(findViewById(R.id.webView));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebViewClient(new WebViewClient());
    }
}
