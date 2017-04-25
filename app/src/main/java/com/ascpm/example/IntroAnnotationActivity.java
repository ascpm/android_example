package com.ascpm.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

/**
 * Created by ascpm on 2017-04-19.
 */
@EActivity(R.layout.activity_intro)
public class IntroAnnotationActivity extends AppCompatActivity {
    @AfterViews
    void afterViews() {
        this.background();
    }

    @Background(delay = 2000)
    void background() {
        startActivity(new Intent(getApplicationContext(), MainAnnotationActivity_.class));
        finish();
    }
}
