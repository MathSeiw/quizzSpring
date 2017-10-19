package com.mathseiw.quizz.model;

import java.util.ArrayList;
import java.util.List;

public class Quizz {

    private List<Question> listquestions;
    private List<String>    listreponses;
    
    public List<String> getListreponses() {
        return listreponses;
    }

    public void setListreponses( List<String> listreponses ) {
        this.listreponses = listreponses;
    }

    Quizz(){
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("question 1","1") );
        questions.add(new Question("question 2","2") );
        this.setlistquestions( questions );
    }
    
    public List<Question> getlistquestions() {
        return listquestions;
    }

    public void setlistquestions( List<Question> listquestions ) {
        this.listquestions = listquestions;
    }    
    
}
