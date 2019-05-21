/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import ui.ErrorDialog;

/**
 *
 * @author Neil
 */
public class Quiz {
    private final AppData appData;
    private final Question[] questions;
    private int currentQuestion;
    
    public Quiz(AppData appData) {
        this.appData = appData;
        questions = appData.getQuestions(2);
        if (questions == null) {
            new ErrorDialog("Failed to load questions from the database").setVisible(true);
            return;
        }
        currentQuestion = -1;
    }

    public Question getNextQuestion() {
        currentQuestion++;
        
        if (currentQuestion >= questions.length) {
            return null;
        }
        
        return questions[currentQuestion];
    }
    
    public Question getCurrentQuestion() {
        if (currentQuestion >= questions.length) {
            return null;
        }
        
        return questions[currentQuestion];
    }
}
