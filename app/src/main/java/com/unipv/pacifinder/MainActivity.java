package com.unipv.pacifinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFindButton();
        }

        private void initFindButton(){

        ImageButton findButton = findViewById(R.id.findButton);

        findButton.setOnClickListener(view -> {

            Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(getPackageManager()) != null) {

                CharSequence text = "Ongoing Research...";
                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
                startActivity(mapIntent);
            }
        });
    }
}