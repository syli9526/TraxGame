package Main;

import GUI.GameGUI;

import java.awt.*;
import javax.swing.*;

class TraxWindow {
    /**
     * @ Main frame of Trax. Other class will be added to this class.
     */
    // Window size
    private Dimension WINDOW_SIZE = new Dimension(800, 600);
    // Frame
    private static JFrame windowFrame = new JFrame();

    private GameGUI gui = new GameGUI();

    TraxWindow(){

        //1. Frame Setting

        // For Window icon
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image winIcon = toolkit.getImage("Img/en.gif");
        windowFrame.setIconImage(winIcon);
        // Console naming
        windowFrame.setTitle("Traxggg");
        // Set size
        windowFrame.setSize(WINDOW_SIZE);

        // 2. setting adapt
        gui.setGUI(windowFrame);
    }

    void gameRun(){
        /**
         * @ make window to visible
         */
    	windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setVisible(true);
    }
}
