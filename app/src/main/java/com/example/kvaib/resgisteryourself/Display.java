package com.example.kvaib.resgisteryourself;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kvaib on 15-08-2017.
 */

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        TextView textView = (TextView) findViewById(R.id.TVUsername);
        textView.setText(username);
    }
}
