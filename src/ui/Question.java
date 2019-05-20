/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import org.json.JSONObject;

/**
 *
 * @author Neil
 */
public class Question extends javax.swing.JFrame {
    private quiz.Quiz quiz;
    private quiz.Question question;
    /**
     * Creates new form Question
     */
    public Question(quiz.Quiz quiz) {
        this.quiz = quiz;
        question = quiz.getNextQuestion();
        initComponents();
        updateQuestion();
    }
    
    private void updateQuestion() {
        Question.setText(question.getQuestion());
        AnswerButton1.setText(question.getOption(1));
        AnswerButton2.setText(question.getOption(2));
        AnswerButton3.setText(question.getOption(3));
        AnswerButton4.setText(question.getOption(4));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnswerGroup = new javax.swing.ButtonGroup();
        Question = new javax.swing.JLabel();
        AnswerButton1 = new javax.swing.JRadioButton();
        AnswerButton2 = new javax.swing.JRadioButton();
        AnswerButton3 = new javax.swing.JRadioButton();
        AnswerButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Clue = new javax.swing.JTextPane();
        ButtonClue = new javax.swing.JToggleButton();
        ButtonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Question.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        AnswerGroup.add(AnswerButton1);

        AnswerGroup.add(AnswerButton2);

        AnswerGroup.add(AnswerButton3);

        AnswerGroup.add(AnswerButton4);

        jScrollPane1.setViewportView(Clue);

        ButtonClue.setText("ShowClue");
        ButtonClue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClueActionPerformed(evt);
            }
        });

        ButtonNext.setText("Next Question");
        ButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonClue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(ButtonNext)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AnswerButton1)
                    .addComponent(AnswerButton2)
                    .addComponent(AnswerButton3)
                    .addComponent(AnswerButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Question)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(AnswerButton1)
                .addGap(18, 18, 18)
                .addComponent(AnswerButton2)
                .addGap(18, 18, 18)
                .addComponent(AnswerButton3)
                .addGap(18, 18, 18)
                .addComponent(AnswerButton4)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonClue)
                    .addComponent(ButtonNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonClueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClueActionPerformed
        if (ButtonClue.isSelected()) {
            Clue.setText(question.getClue());
            question.setUserShowClue();
        } else {
            Clue.setText("");
        }
    }//GEN-LAST:event_ButtonClueActionPerformed

    private void ButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNextActionPerformed
        ButtonModel selection = AnswerGroup.getSelection();
        int answer;
        if (selection == AnswerButton1.getModel()) {
            answer = 0;
        } else if (selection == AnswerButton2.getModel()) {
            answer = 1;
        } else if (selection == AnswerButton3.getModel()) {
            answer = 2;
        } else {
            answer = 3;
        }
        
        question.setUserAnswer(answer);
        JSONObject jsonQuestion = new JSONObject(question);
        System.out.println(jsonQuestion.toString());
        //question.setUserAnswer();
        quiz.Question nextQuestion = quiz.getNextQuestion();
        if (nextQuestion == null) {
            System.exit(0);
        }
        question = nextQuestion;
        
        updateQuestion();
    }//GEN-LAST:event_ButtonNextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AnswerButton1;
    private javax.swing.JRadioButton AnswerButton2;
    private javax.swing.JRadioButton AnswerButton3;
    private javax.swing.JRadioButton AnswerButton4;
    private javax.swing.ButtonGroup AnswerGroup;
    private javax.swing.JToggleButton ButtonClue;
    private javax.swing.JButton ButtonNext;
    private javax.swing.JTextPane Clue;
    private javax.swing.JLabel Question;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}