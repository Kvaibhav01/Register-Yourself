package com.example.kvaib.resgisteryourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view)
    {
        if (view.getId() == R.id.Blogin)
        {
            EditText a = (EditText) findViewById(R.id.TFusername);
            String string = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.TFPassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(string);

            if (pass.equals(password))
            {
                Intent intent = new Intent(MainActivity.this, Display.class);
                intent.putExtra("Username", string);
                startActivity(intent);
            }

            else
            {
                Toast temp = Toast.makeText(MainActivity.this, "Oh, Username and Password didn't match!", Toast.LENGTH_SHORT);
                temp.show();
            }


        }
        if (view.getId() == R.id.Bsignup)
        {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        }
    }
}
