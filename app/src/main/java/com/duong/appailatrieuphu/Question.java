package com.duong.appailatrieuphu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duong on 29/08/2016.
 */
public class Question {
    private int trueCase, level;
    private String caseA, caseB, caseC, caseD, question;
    private List<String> cases;

    public Question(int trueCase, int level, String caseA, String caseB, String caseC, String caseD, String question) {
        this.trueCase = trueCase;
        this.level = level;
        this.caseA = caseA;
        this.caseB = caseB;
        this.caseC = caseC;
        this.caseD = caseD;
        this.question = question;
        init();
    }

    private void init(){
        cases = new ArrayList<>();
        cases.add(caseA);
        cases.add(caseB);
        cases.add(caseC);
        cases.add(caseD);
    }

    public List<String> getCases() {
        return cases;
    }

    public int getTrueCase() {
        return trueCase;
    }

    public int getLevel() {
        return level;
    }

    public String getCaseA() {
        return caseA;
    }

    public String getCaseB() {
        return caseB;
    }

    public String getCaseC() {
        return caseC;
    }

    public String getCaseD() {
        return caseD;
    }

    public String getQuestion() {
        return question;
    }
}
