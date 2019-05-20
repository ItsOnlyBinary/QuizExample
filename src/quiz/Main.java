/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import ui.Welcome;

/**
 *
 * @author Neil
 */
public class Main {

    
    public static void main(String[] args) {
        AppData appData = new AppData();
        if (appData.hasDB()) {
            new Welcome(appData).setVisible(true);
        }
    }
}
