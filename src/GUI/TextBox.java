package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import AI.AIRun;
import AI.EngineAI;
import Engine.Buttons;

public class TextBox extends JFrame implements ActionListener {
	private JButton swapButton = new JButton("<->");
	private JButton aiButton = new JButton("Ai");
	private JPanel buttonPanel = new JPanel();
	private JPanel basePanel = new JPanel();
	private JPanel textPanel = new JPanel();
	public JTextArea textArea = new JTextArea();
	private JScrollPane Tscpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	private static TextBox textBox;

	//private EngineAI ai = new EngineAI();

	public TextBox() {
		this.textArea.append("Start Game\n");

		// set listener
		swapButton.addActionListener(this);
		swapButton.setActionCommand("Swap");
		aiButton.addActionListener(new AIRun());
		aiButton.setActionCommand("Ai");

	}

	public void setTextArea(String s) {
		this.textArea.append(s);
	}

	public void resetTextArea() {
		this.textArea.setText(" ");
		this.textArea.append("Start Game\n");
	}

	public static TextBox GetInstance() {
		if (textBox == null)
			textBox = new TextBox();
		return textBox;
	}

	public void setText(JFrame frame) {
		buttonPanel.setPreferredSize(new Dimension(250, 30));
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(swapButton);
		buttonPanel.add(aiButton);

		Tscpane.setPreferredSize(new Dimension(250, 400));
		textPanel.add(Tscpane);
		textArea.setEditable(false);

		basePanel.setPreferredSize(new Dimension(250, 600));
		basePanel.add(buttonPanel, BorderLayout.SOUTH);
		basePanel.add(textPanel, BorderLayout.CENTER);

		frame.add(basePanel, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Swap") {
			if (Buttons.user == false) {
				textBox.setTextArea("==White's turn -> Black's turn==\n");
				Buttons.user = true;
			} else {
				textBox.setTextArea("==Black's turn -> White's turn==\n");
				Buttons.user = false;
			}
			new GameStatusBar();
		}

	}
}
