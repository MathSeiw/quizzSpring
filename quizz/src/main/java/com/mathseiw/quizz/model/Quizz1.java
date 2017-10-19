package com.mathseiw.quizz.model;

import java.util.ArrayList;
import java.util.List;

public class Quizz1 extends Quizz {

    Quizz1(){
        List<String> questions = new ArrayList<String>();
        questions.add( "question 1" );
        questions.add( "question 2" );
        this.setQuestions( questions );
    }
}
