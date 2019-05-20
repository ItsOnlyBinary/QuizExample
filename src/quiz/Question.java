/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Neil
 */
public class Question {
    private final String question;
    private final String clue;
    private final String[] options;
    private final int answer;
    private boolean userShownClue;
    private int userAnswer;
    
    public Question(String question, String clue, String[] options, int answer) {
        this.question = question;
        this.clue = clue;
        this.options = options;
        this.answer = answer;
        userShownClue = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption(int i) {
        return options[i-1];
    }

    public String getClue() {
        return clue;
    }

    public void setUserShowClue() {
        userShownClue = true;
    }

    public void setUserAnswer(int answer) {
        userAnswer = answer;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isUserShownClue() {
        return userShownClue;
    }

    public int getUserAnswer() {
        return userAnswer;
    }
    
}
