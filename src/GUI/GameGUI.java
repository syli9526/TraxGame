package GUI;

import javax.swing.*;

import Engine.Buttons;

import java.awt.*;

public class GameGUI {
    private static JPanel backPanel = new JPanel();
    private Dimension PANEL_SIZE = new Dimension(5632, 5632);

    private GUI.SysMenu sysMenuBar = new GUI.SysMenu();
    private GUI.PanelMenu panelMenu = new GUI.PanelMenu();
    private GUI.ScrollBar scrollBar = new GUI.ScrollBar();
    private GUI.GameStatusBar gameStatusBar = new GUI.GameStatusBar();
    private TextBox textBox;
    
    private Buttons buttons = new Buttons();

    public GameGUI(){
    	textBox = TextBox.GetInstance();
        backPanel.setLayout(new GridLayout(128, 128));
        backPanel.setPreferredSize(PANEL_SIZE);
    }

    public void setGUI(JFrame frame){
        /**
         * @ set GUI to frame
         * @ param: frame(JFrame)
         * @ return: none
         */
        sysMenuBar.setSysMenu(frame);
        gameStatusBar.setGameStatusBar(frame);
        panelMenu.setPanelMenu(frame);
        scrollBar.setScrollBar(frame ,backPanel);
        buttons.setBtn(backPanel);
        textBox.setText(frame);
    }

}
