package com.ascpm.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button01;
    private Button button02;
    private Button button03;
    private Button button04;

    private TextView textView;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        bindEvent();
    }

    private void bindEvent() {
        this.button01.setOnClickListener(v -> textView.setText(Button.class.cast(v).getText().toString()));
        this.button02.setOnClickListener(v -> textView.setText(Button.class.cast(v).getText().toString()));
        this.button03.setOnClickListener(v -> textView.setText(Button.class.cast(v).getText().toString()));
        this.button04.setOnClickListener(v -> textView.setText(Button.class.cast(v).getText().toString()));

        this.textView.setOnClickListener(v -> Toast.makeText(getApplicationContext(), TextView.class.cast(v).getText(), Toast.LENGTH_LONG).show());

        this.editText.setOnKeyListener((v, k, e) -> {
            if (KeyEvent.ACTION_DOWN == e.getAction() && KeyEvent.KEYCODE_ENTER == k) {
                textView.setText(EditText.class.cast(v).getText().toString());
                return true;
            }

            return false;
        });
    }

    private void initView() {
        this.button01 = Button.class.cast(findViewById(R.id.button01));
        this.button02 = Button.class.cast(findViewById(R.id.button02));
        this.button03 = Button.class.cast(findViewById(R.id.button03));
        this.button04 = Button.class.cast(findViewById(R.id.button04));

        this.textView = TextView.class.cast(findViewById(R.id.textView));

        this.editText = EditText.class.cast(findViewById(R.id.editText));
    }
}
