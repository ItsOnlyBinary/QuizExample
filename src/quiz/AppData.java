/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.ErrorDialog;
import org.json.JSONArray;

/**
 *
 * @author Neil
 */
public class AppData {
    private String username;
    private Connection db;

    public AppData() {
        try {
            Class.forName("org.sqlite.JDBC");
            db = DriverManager.getConnection("jdbc:sqlite:quiz.db");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AppData.class.getName()).log(Level.SEVERE, null, ex);
            db = null;
            new ErrorDialog(ex.getMessage()).setVisible(true);
        }
        createTables();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean hasDB() {
        return !(db == null);
    }

    private void createTables() {
        try {
            Statement stmt = db.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS questions (" +
                            " question       TEXT    NOT NULL, " +
                            " clue           TEXT    NOT NULL, " +
                            " options        TEXT    NOT NULL, " +
                            " answer         INT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppData.class.getName()).log(Level.SEVERE, null, ex);
            db = null;
            new ErrorDialog(ex.getMessage()).setVisible(true);
        }
    }

    Question[] getQuestions(int limit) {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            String sql = "SELECT question, clue, options, answer " +
                         " FROM questions " +
                         " ORDER BY RANDOM() LIMIT 0,?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, limit);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JSONArray options = new JSONArray(rs.getString("options"));
                Iterator<Object> optionsIterator = options.iterator();
                ArrayList<String> optionsList = new ArrayList<>();
                while (optionsIterator.hasNext()) {
                    String option = (String) optionsIterator.next();
                    optionsList.add(option);
                }
                Question question = new Question(
                    rs.getString("question"),
                    rs.getString("clue"), 
                    optionsList.toArray(new String[optionsList.size()]),
                    rs.getInt("answer")
                );
                questions.add(question);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return questions.toArray(new Question[questions.size()]);
    }
}
