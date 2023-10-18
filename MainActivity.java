package com.example.dicegame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageDice1;
    ImageView imageDice2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageDice1 = findViewById(R.id.imageDice1);
        imageDice2 = findViewById(R.id.imageDice2);

    }


    public void onClick(View v) {
        int[] diceId = {R.drawable.dice1, R.drawable.dice2,
                R.drawable.dice3, R.drawable.dice4,
                R.drawable.dice5, R.drawable.dice6};
        int rand = getRandom(6, 0);
        imageDice1.setImageResource( diceId[rand] );

        rand = getRandom(6, 0);
        imageDice2.setImageResource( diceId[rand] );

    }



    int getRandom(int range, int min) {

        return (int)(Math.random() * range) + min;

    }

}