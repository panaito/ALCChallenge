package com.jafriam.alc_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Button mBtLaunchActivity;
        Button mButton1 = findViewById( R.id.bt_about );
        mButton2 = findViewById( R.id.bt_profile );

        mButton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, AboutAlc.class ) );
            }
        } );
        mButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, ProfileActivity.class ) );
            }
        } );
    }
}