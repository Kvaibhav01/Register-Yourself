package com.example.kvaib.resgisteryourself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by kvaib on 15-08-2017.
 */

public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View view)
    {
        if (view.getId() == R.id.Bsignupbutton)
        {
            EditText name = (EditText) findViewById(R.id.TFName);
            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText uname = (EditText) findViewById(R.id.TFuname);
            EditText pass1 = (EditText) findViewById(R.id.TFpass1);
            EditText pass2 = (EditText) findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str))
            {
                //Popup message if passwords don't match
                Toast pass = Toast.makeText(SignUp.this, "Hmmm...Passwords didn't match!", Toast.LENGTH_SHORT);
                pass.show();
            }

            else
            {
                //Insert details in the database
                Contact contact = new Contact();
                contact.setName(namestr);
                contact.setEmail(emailstr);
                contact.setUname(unamestr);
                contact.setPass(pass1str);

                helper.insertContact(contact);
            }
        }
    }
}
