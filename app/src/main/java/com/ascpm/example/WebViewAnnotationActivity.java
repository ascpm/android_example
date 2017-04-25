package com.ascpm.example;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.ViewById;

/**
 * Created by ascpm on 2017-04-19.
 */
@EActivity(R.layout.activity_web_view)
public class WebViewAnnotationActivity extends AppCompatActivity {
    @ViewById(R.id.urlEditText)
    EditText urlEditText;

    @ViewById(R.id.goButton)
    Button goButton;

    @ViewById(R.id.webView)
    WebView webView;

    @AfterViews
    void afterViews() {
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebViewClient(new WebViewClient());
    }

    @Click(R.id.goButton)
    void goButtonClick() {
        String url = this.urlEditText.getText().toString();

        if (!"".equals(url)) {
            this.webView.loadUrl(url);
        }
    }

    @EditorAction(R.id.urlEditText)
    void urlEditTextEditorAction(TextView view, int actionId, KeyEvent keyEvent) {
        if (KeyEvent.ACTION_DOWN == keyEvent.getAction() && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()) {
            this.goButtonClick();
        }
    }
}
