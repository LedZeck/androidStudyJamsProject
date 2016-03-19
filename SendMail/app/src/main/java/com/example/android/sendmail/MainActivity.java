package com.example.android.sendmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMail(View view){
        EditText name_field = (EditText) findViewById(R.id.name_field_view);
        String name = name_field.getText().toString();

        EditText subject_field = (EditText) findViewById(R.id.subject_field_view);
        String subject = subject_field.getText().toString();

        EditText address_field = (EditText) findViewById(R.id.address_field_view);
        String address = address_field.getText().toString();

        EditText message_field = (EditText) findViewById(R.id.message_field_view);
        String message = message_field.getText().toString();

        String finalMessage = message + "\n\nSent from my Android Study Jams Project";


        Log.v("Wololo", "Simbora!!!");

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{address});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT   , finalMessage);
        try {
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
