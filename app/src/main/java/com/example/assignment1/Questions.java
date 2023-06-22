package com.example.assignment1;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Questions {//We make this class for sit a mani of a questions and choose a random from it in evrey time run the app

    private String question;
    private String answer;

    public Questions(String question,String answer){
        this.question=question;
        this.answer=answer;
    }

    public static final Questions[] questions={
            new Questions("What is the function of the heart?","Pump blood"),
            new Questions("What is the function of the lungs?","Breathe air"),
            new Questions("What is the function of the brain?","Control body"),
            new Questions("What is the function of the kidneys?","Filter blood"),
            new Questions("What is the function of the liver?","Process toxins"),
            new Questions("What is the function of the stomach?","Digest food"),
            new Questions("What is the function of the muscles?","Move body"),
            new Questions("What is the function of the skin?","Protect body"),
            new Questions("What is the function of the bones?","Support body"),
            new Questions("What is the function of the immune system?","Fight infection")
    };


    public static String[] getAllans(){//use it i assi1
        String[] a=new String[questions.length];
        for(int i=0;i<=questions.length-1;i++){
            a[i]=questions[i].getAnswer();
        }
        return  a;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
