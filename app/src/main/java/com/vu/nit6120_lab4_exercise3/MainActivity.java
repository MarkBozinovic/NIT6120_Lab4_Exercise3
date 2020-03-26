package com.vu.nit6120_lab4_exercise3;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vu.nit6120_lab4_exercise3.MathActivity;
import com.vu.nit6120_lab4_exercise3.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    public static final String EXTRA_USER_NUMBER = "user number";
    private static final int RESULT_CODE_DO_MATH = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDoMathButton();
    }

    private void setupDoMathButton()
    {


        Button btn = (Button) findViewById(R.id.btnDoMath);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText userTextEntry = (EditText) findViewById(R.id.editTextUserNumber);
                String userData = userTextEntry.getText().toString();
                int userNumber = Integer.parseInt(userData);

                Intent intent = new Intent(MainActivity.this, MathActivity.class);
                intent.putExtra(EXTRA_USER_NUMBER, userNumber);
                startActivityForResult(intent, RESULT_CODE_DO_MATH);


            }
        });
    }

    //Gets called when the activity we started finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_CANCELED)
        {
            TextView answerView = (TextView) findViewById(R.id.textViewAnswer);
            answerView.setText("User Canceled");
            return;
        }

        switch(requestCode)
        {
            case RESULT_CODE_DO_MATH:
                int answer = data.getIntExtra(MathActivity.EXTRA_ANSWER, 0);
                TextView answerView = (TextView) findViewById(R.id.textViewAnswer);
                answerView.setText("" + answer);
                break;
        }


    }
}
