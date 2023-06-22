package com.example.assignment1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.internal.ContextUtils;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    TextView question1;
    TextView question2;
    TextView question3;
    Spinner answer1;
    Spinner answer2;
    Spinner answer3;
    Button submit;
    Button login;

    Questions q1;
    Questions q2;
    Questions q3;
    private  HolderAdapter adapter;
    private RecyclerView recycler ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveData();

        recycler = findViewById(R.id.pizza_recycler);
        answer1 = findViewById(R.id.spinner);
        String[] questions = new String[Questions.questions.length];
        String[] answers = new String[Questions.questions.length];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = Questions.questions[i].getQuestion();
            answers[i] = Questions.questions[i].getAnswer();
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HolderAdapter(questions, answers);
        recycler.setAdapter(adapter);




    }

    public void login(View view) {
//        //when click on this button edit the screen to show the question
//        question1.setVisibility(View.VISIBLE);
//        question2.setVisibility(View.VISIBLE);
//        question3.setVisibility(View.VISIBLE);
//        answer1.setVisibility(View.VISIBLE);
//        answer2.setVisibility(View.VISIBLE);
//        answer3.setVisibility(View.VISIBLE);
//        submit.setVisibility(View.VISIBLE);
//        login.setVisibility(View.GONE);
//
//        //get a random question from the DAQuestion and show it on the screen
//        q1=question.getQuestion((int) (10*Math.random()));
//        q2=question.getQuestion((int) (10*Math.random()));
//        q3=question.getQuestion((int) (10*Math.random()));
//        question1.setText(q1.getQuestion());
//        question2.setText(q2.getQuestion());
//        question3.setText(q3.getQuestion());

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

    public void saveData(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        Questions[] Qaa = Questions.questions;


        String QaaString = gson.toJson(Qaa);

        editor.putString("QAKnwolage", QaaString);
        editor.commit();

        Toast.makeText(this, "Data Saved:\n" ,
                Toast.LENGTH_SHORT).show();
    }




}