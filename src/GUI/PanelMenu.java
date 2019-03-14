package GUI;

import javax.swing.*;

import Engine.Buttons;
import Function.NewGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelMenu implements ActionListener {
	// panel size
	private Dimension PANEL_SIZE = new Dimension(25, 25); // dimension has two field height, width data structure

	private JPanel panelMenu = new JPanel(); // Btn grid

	// btn image
	private JButton btnNew = new JButton(new ImageIcon("Img/new.png"));
	private JButton btnLoad = new JButton(new ImageIcon("Img/load.png"));
	private JButton btnSave = new JButton(new ImageIcon("Img/save.png"));
	private JButton btnOption = new JButton(new ImageIcon("Img/help.png"));
	private JButton btnUndo = new JButton(new ImageIcon("Img/undo.png"));
	private JButton btnRecord = new JButton(new ImageIcon("Img/record.png"));

	private TextBox textBox;

	PanelMenu() {
		textBox = TextBox.GetInstance();
		
		// set size
		btnNew.setPreferredSize(PANEL_SIZE);
		btnLoad.setPreferredSize(PANEL_SIZE);
		btnSave.setPreferredSize(PANEL_SIZE);
		btnOption.setPreferredSize(PANEL_SIZE);
		btnUndo.setPreferredSize(PANEL_SIZE);
		btnRecord.setPreferredSize(PANEL_SIZE);

		// set listener
		btnUndo.addActionListener(this);
		btnUndo.setActionCommand("Undo");
		btnNew.addActionListener(this);
		btnNew.setActionCommand("New");

		// set tool tip
		btnRecord.setToolTipText("Record");
		btnUndo.setToolTipText("Undo");
		btnNew.setToolTipText("New");
		btnSave.setToolTipText("Save");
		btnLoad.setToolTipText("Load"); // add text at frame button

		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

		panelMenu.add(btnNew);
		panelMenu.add(btnSave);
		panelMenu.add(btnLoad);
		panelMenu.add(btnOption);
		panelMenu.add(btnUndo);
		panelMenu.add(btnRecord);

		panelMenu.setBackground(Color.white);
	}

	void setPanelMenu(JFrame frame) {
		/**
		 * @ add panel at frame @ param: frame (JFrame) @ return: none
		 */
		frame.add(panelMenu, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Undo") {
			 Buttons.unDO();
			 if (Buttons.user == false) {
					textBox.setTextArea("==White's turn undo==\n");
			 } else {
					textBox.setTextArea("==Black's turn undo==\n");
			 }
			 new GameStatusBar();
		}
		if(e.getActionCommand() == "New") {
			new NewGame();
		}
	}
}
