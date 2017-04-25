package com.ascpm.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.ViewById;

/**
 * Created by ascpm on 2017-04-19.
 */
@EActivity(R.layout.activity_main)
public class MainAnnotationActivity extends AppCompatActivity {
    @ViewById(R.id.button01)
    Button button01;
    @ViewById(R.id.button02)
    Button button02;
    @ViewById(R.id.button03)
    Button button03;
    @ViewById(R.id.button04)
    Button button04;

    @ViewById(R.id.textView)
    TextView textView;

    @ViewById(R.id.editText)
    EditText editText;

    @Click({R.id.button01, R.id.button03, R.id.button04})
    void buttonClick(View v) {
        this.textView.setText(Button.class.cast(v).getText().toString());
    }

    @Click(R.id.button02)
    void webViewButtonClick() {
        startActivity(new Intent(getApplicationContext(), WebViewAnnotationActivity_.class));
        finish();
    }

    @Click(R.id.textView)
    void textViewClick(View v) {
        Toast.makeText(getApplicationContext(), TextView.class.cast(v).getText().toString(), Toast.LENGTH_LONG).show();
    }

    @EditorAction(R.id.editText)
    void editTextEditorAction(TextView view, int actionId, KeyEvent keyEvent) {
        if (KeyEvent.ACTION_DOWN == keyEvent.getAction() && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()) {
            textView.setText(EditText.class.cast(view).getText().toString());
        }
    }
}
