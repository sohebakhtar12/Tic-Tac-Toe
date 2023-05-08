package com.example.tom_and_jerry;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int player=1;//player1 is tom
    int[][] winningStates = {
            // Rows
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            // Columns
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            // Diagonals
            {0, 4, 8},
            {2, 4, 6}
    };
    int []gameStates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {

        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageClicked=gameStates[tag];
        if(isWinner==false && imageClicked==-1){
            if(player==1)
            {
                v.setImageResource(R.drawable.tom);
//            Toast.makeText(this,tag+"Tom",Toast.LENGTH_SHORT).show();
                gameStates[tag]=player;
                player=0;
            }else {
                v.setImageResource(R.drawable.jerry);
//            Toast.makeText(this,tag+"Jerry",Toast.LENGTH_SHORT).show();
                gameStates[tag]=player;
                player=1;
            }
            for(int i=0;i<winningStates.length;i++) {
                if (gameStates[winningStates[i][0]] == gameStates[winningStates[i][1]] && gameStates[winningStates[i][1]] == gameStates[winningStates[i][2]] && gameStates[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? "Player 1" : "Player 2"), Toast.LENGTH_LONG).show();
                    isWinner=true;
                }

            }

        }


    }
    public void restart(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int totalImages=gridLayout.getChildCount();
        for(int i=0;i<totalImages;i++)
        {
            ImageView v =(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        for (int i=0;i<gameStates.length;i++)
        {
            gameStates[i]=-1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}