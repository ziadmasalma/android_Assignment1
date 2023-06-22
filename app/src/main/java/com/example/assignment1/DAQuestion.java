package com.example.assignment1;

import java.util.ArrayList;

public class DAQuestion {
    ArrayList<Questions> questions=new ArrayList<>();
    DAQuestion(){
        questions.add(new Questions("What is the function of the heart?","Pump blood"));
        questions.add(new Questions("What is the function of the lungs?","Breathe air"));
        questions.add(new Questions("What is the function of the brain?","Control body"));
        questions.add(new Questions("What is the function of the kidneys?","Filter blood"));
        questions.add(new Questions("What is the function of the liver?","Process toxins"));
        questions.add(new Questions("What is the function of the stomach?","Digest food"));
        questions.add(new Questions("What is the function of the muscles?","Move body"));
        questions.add(new Questions("What is the function of the skin?","Protect body"));
        questions.add(new Questions("What is the function of the bones?","Support body"));
        questions.add(new Questions("What is the function of the immune system?","Fight infection"));
    }
    public Questions getQuestion(int x){//method to get a random question and show it in the app
        Questions q=questions.get(x);
        return q;
    }
    public ArrayList getAllans(){//return all answer to set it in spinner
        ArrayList<String> a=new ArrayList<>();
        for(int i=0;i<=questions.size()-1;i++){
            a.add(questions.get(i).getAnswer());
        }
        return a;
    }

}
