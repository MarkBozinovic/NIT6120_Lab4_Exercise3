package com.vu.nit6120_lab4_exercise3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity
{
    public static final String EXTRA_ASWER = "the answer";
    public static final String EXTRA_ANSWER = EXTRA_ASWER;
    private int valueToWorkWith;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        //Get intent to strat to find a parameter
        Intent intent = getIntent();
        valueToWorkWith
                = intent.getIntExtra(MainActivity.EXTRA_USER_NUMBER, 0);

        //Display value to the screen
        TextView displayNumber = (TextView) findViewById(R.id.textViewUserNumber);
        displayNumber.setText("" + valueToWorkWith);

        setupDoubleButton();
        setUpCancelButton();
    }

    private void setUpCancelButton()
    {
        Button btn = (Button) findViewById(R.id.btnCancel);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //Return answer to calling activity
                Intent intent = new Intent();

                setResult(Activity.RESULT_CANCELED, intent);

                finish();
            }
        });

    }

    private void setupDoubleButton()
    {
        Button btn = (Button) findViewById(R.id.btnDoubleIt);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //compute the answer
                int answer = valueToWorkWith * 2;

                //Return answer to calling activity
                Intent intent = new Intent();
                intent.putExtra(EXTRA_ANSWER, answer);
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }




    /*@Override
    public boolean onCreateOptionMenu(Menu menu)
    {
        //Inflate the menu, this adds items to the action bar if present
        getMenuInflater().inflate(R.menu.math, menu);
        return true;
    }*/

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

}
