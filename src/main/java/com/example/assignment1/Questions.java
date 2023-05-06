package com.example.assignment1;

public class Questions {//We make this class for sit a mani of a questions and choose a random from it in evrey time run the app

    private String question;
    private String answer;

    public Questions(String question,String answer){
        this.question=question;
        this.answer=answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
