package com.mathseiw.quizz.model;

public class Question {

    private String question;
    private String response;

    public Question( String question, String reponse ) {
        super();
        this.question = question;
        this.response = reponse;
    }
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion( String question ) {
        this.question = question;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse( String response ) {
        this.response = response;
    }
}
