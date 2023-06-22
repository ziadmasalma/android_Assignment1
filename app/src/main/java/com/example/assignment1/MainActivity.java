package com.example.assignment1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.ContextUtils;

public class MainActivity extends AppCompatActivity {

    TextView question1;
    TextView question2;
    TextView question3;
    Spinner answer1;
    Spinner answer2;
    Spinner answer3;
    Button submit;
    Button login;
    DAQuestion question=new DAQuestion();
    Questions q1;
    Questions q2;
    Questions q3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        question1=findViewById(R.id.textView3);
        question2=findViewById(R.id.textView4);
        question3=findViewById(R.id.textView6);
        answer1=findViewById(R.id.spinner);
        answer2=findViewById(R.id.spinner2);
        answer3=findViewById(R.id.spinner3);
        submit=findViewById(R.id.button2);
        login=findViewById(R.id.button);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,question.getAllans());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answer1.setAdapter(adapter);
        answer2.setAdapter(adapter);
        answer3.setAdapter(adapter);
    }

    public void login(View view) {
        //when click on this button edit the screen to show the question
        question1.setVisibility(View.VISIBLE);
        question2.setVisibility(View.VISIBLE);
        question3.setVisibility(View.VISIBLE);
        answer1.setVisibility(View.VISIBLE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);
        submit.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);

        //get a random question from the DAQuestion and show it on the screen
        q1=question.getQuestion((int) (10*Math.random()));
        q2=question.getQuestion((int) (10*Math.random()));
        q3=question.getQuestion((int) (10*Math.random()));
        question1.setText(q1.getQuestion());
        question2.setText(q2.getQuestion());
        question3.setText(q3.getQuestion());

    }
    public void submit(View view) {
        int i=0;
        if (answer1.getSelectedItem().toString()==q1.getAnswer())
            i++;
        if (answer2.getSelectedItem().toString()==q2.getAnswer())
            i++;
        if(answer3.getSelectedItem().toString()==q3.getAnswer())
            i++;
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Grade");
        alertDialog.setMessage("your grade is"+i+"/3");
        alertDialog.show();

        question1.setVisibility(View.GONE);
        question2.setVisibility(View.GONE);
        question3.setVisibility(View.GONE);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
        answer3.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        login.setVisibility(View.VISIBLE);
    }
}