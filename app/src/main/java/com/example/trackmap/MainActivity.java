package com.example.trackmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.editText);
        b=findViewById(R.id.editText2);
        c=findViewById(R.id.button);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSource =a.getText().toString().trim();
                String sDestination =b.getText().toString().trim();
                if(sSource.equals("")&& sDestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both location",Toast.LENGTH_SHORT).show();

                }
                else {
                    DisplayTrack(sSource,sDestination);

                }

            }

            private void DisplayTrack(String sSource, String sDestination) {
                try{
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+sSource +"/" + sDestination);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }catch (ActivityNotFoundException e){
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}