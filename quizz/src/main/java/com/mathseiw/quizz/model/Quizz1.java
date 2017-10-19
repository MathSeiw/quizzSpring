package com.mathseiw.quizz.model;

import java.util.ArrayList;
import java.util.List;

public class Quizz1 extends Quizz {

    Quizz1(){
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("question 1","1") );
        questions.add(new Question("question 2","2") );
        this.setlistquestions( questions );
    }
}
