package Engine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import AI.EngineAI;
import AI.TempTileRules;
import Engine.WinningAlgorithm;
import Function.NewGame;
import Function.TraxStack;
import GUI.FinishPopup;
import GUI.GameStatusBar;
import GUI.TextBox;

public class Buttons implements ActionListener, MouseListener, KeyListener {

	public static int turnCount = 1;
	public static int autoTurnCount = 0;
	public static int aiTurnCount = 0;
	public static boolean autoAi = false;
	public static boolean fixEnd = false;
	public static int stackCnt = -1;

	public static JButton[][] btn = new JButton[128][128];
	public static String[][] type = new String[128][128];
	public static int[][] rule = new int[128][128];
	public static int[][] btnCnt = new int[128][128];

	public static String[][] tempType = new String[128][128];
	public static String[][] tempType1 = new String[128][128];
	public static String[][] tempType2 = new String[128][128];
	public static String[][] tempType3 = new String[128][128];

	private String sessionActionCommand;
	private static boolean sessionBtnFix = true;

	public static boolean gameStart = false;
	public static boolean user;
	public static boolean selectUser;
	
	private static TempTileRules tempTileRules = new TempTileRules();

	// tile icon

	private ImageIcon tmp_tile1 = new ImageIcon("Img/1_tmp.png");
	private ImageIcon tmp_tile2 = new ImageIcon("Img/2_tmp.png");
	private ImageIcon tmp_tile3 = new ImageIcon("Img/3_tmp.png");
	private ImageIcon tmp_tile4 = new ImageIcon("Img/4_tmp.png");
	private ImageIcon tmp_tile5 = new ImageIcon("Img/5_tmp.png");
	private ImageIcon tmp_tile6 = new ImageIcon("Img/6_tmp.png");

	private static ImageIcon tile0 = new ImageIcon("Img/0.png");
	private static ImageIcon tile1 = new ImageIcon("Img/1.png");
	private static ImageIcon tile2 = new ImageIcon("Img/2.png");
	private static ImageIcon tile3 = new ImageIcon("Img/3.png");
	private static ImageIcon tile4 = new ImageIcon("Img/4.png");
	private static ImageIcon tile5 = new ImageIcon("Img/5.png");
	private static ImageIcon tile6 = new ImageIcon("Img/6.png");

	private static FinishPopup finishPop = new FinishPopup();
	private static TileRules tileRules = new TileRules();
	private static WinningAlgorithm winAl = new WinningAlgorithm();
	public static EngineAI ai = new EngineAI();

	// stack
	private static TraxStack stack[] = new TraxStack[100];

	// TextBox
	private static TextBox textBox;
	static String str;

	public Buttons() {

		textBox = TextBox.GetInstance();
	}

	public void setBtn(JPanel panel) {

		for (int i_idx = 0; i_idx < 128; i_idx++) {
			for (int j_idx = 0; j_idx < 128; j_idx++) {

				// init each button
				btn[i_idx][j_idx] = new JButton(new ImageIcon("Img/0.png"));

				// access at idx with division by 128
				int idxConst = 128 * i_idx + j_idx;
				String command = Integer.toString(idxConst);
				// add action listener(-> actionPerformed)
				btn[i_idx][j_idx].setActionCommand(command);
				btn[i_idx][j_idx].setToolTipText("(" + i_idx + "," + j_idx + ")");

				btn[i_idx][j_idx].setPreferredSize(new Dimension(46, 46));
				btn[i_idx][j_idx].addActionListener(this);

				rule[i_idx][j_idx] = 0;
				type[i_idx][j_idx] = "Empty";
				btnCnt[i_idx][j_idx] = 0;

				panel.add(btn[i_idx][j_idx]);

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		fixEnd = false;

		if (!gameStart) {

			if (e.getSource() instanceof JButton) {

				int x = 64;
				int y = 64;

				btn[x][y].addKeyListener(this);
				btn[x][y].addMouseListener(this);

				tileRules.tileRule(x, y);
				setTile(x, y, rule[x][y]);
				btnCnt[x][y]++;

				sessionBtnFix = false;
			}

		} else {

			if (e.getSource() instanceof JButton) {
				if (sessionBtnFix == false && sessionActionCommand != e.getActionCommand()) {

					btn[Integer.parseInt(sessionActionCommand) / 128][Integer.parseInt(sessionActionCommand) % 128]
							.setIcon(new ImageIcon("Img/0.png"));
					btnCnt[Integer.parseInt(sessionActionCommand) / 128][Integer.parseInt(sessionActionCommand)
							% 128] = 0;
					type[Integer.parseInt(sessionActionCommand) / 128][Integer.parseInt(sessionActionCommand)
							% 128] = "Empty";
					rule[Integer.parseInt(sessionActionCommand) / 128][Integer.parseInt(sessionActionCommand)
							% 128] = 0;

				}

				sessionActionCommand = e.getActionCommand(); // getActionCommand return the each command, so we can calc
																// idx decode to access at index
				int x = Integer.parseInt(sessionActionCommand) / 128;
				int y = Integer.parseInt(sessionActionCommand) % 128;

				btn[x][y].addKeyListener(this);
				btn[x][y].addMouseListener(this);

				tileRules.tileRule(x, y);
				setTile(x, y, rule[x][y]);
				btnCnt[x][y]++;

				sessionBtnFix = false;

			}
		}
	}

	public String whatTile(int x, int y) {
		if (type[x][y] == "NorthWest") {
			return "/";
		} else if (type[x][y] == "NorthEast") {
			return "\\";
		} else if (type[x][y] == "EastSouth") {
			return "/";
		} else if (type[x][y] == "SouthWest") {
			return "\\";
		} else if (type[x][y] == "EastWest") {
			return "+";
		} else if (type[x][y] == "NorthSouth") {
			return "+";
		}
		return "";
	}

	public static void fixTile(int x, int y) {

		turnCount++;
		System.out.println(turnCount);
		btn[x][y].removeKeyListener(null);
		btn[x][y].setEnabled(false);

		if (type[x][y] == "NorthWest") {
			btn[x][y].setDisabledIcon(tile1);
		} else if (type[x][y] == "NorthEast") {
			btn[x][y].setDisabledIcon(tile2);
		} else if (type[x][y] == "EastSouth") {
			btn[x][y].setDisabledIcon(tile3);
		} else if (type[x][y] == "SouthWest") {
			btn[x][y].setDisabledIcon(tile4);
		} else if (type[x][y] == "EastWest") {
			btn[x][y].setDisabledIcon(tile5);
		} else if (type[x][y] == "NorthSouth") {
			btn[x][y].setDisabledIcon(tile6);
		}

		if (turnCount == 2) {

			for (int j = 0; j < 128; j++) {
				for (int i = 0; i < 128; i++) {
					if (i == x && j == y)
						continue;

					btn[i][j].setEnabled(false);
					btn[i][j].setDisabledIcon(new ImageIcon("Img/0.png"));

				}
			}
		}
		// Button available (up, down, left , right)
		if (btnCnt[x - 1][y] == 0)
			btn[x - 1][y].setEnabled(true);
		if (btnCnt[x + 1][y] == 0)
			btn[x + 1][y].setEnabled(true);
		if (btnCnt[x][y - 1] == 0)
			btn[x][y - 1].setEnabled(true);
		if (btnCnt[x][y + 1] == 0)
			btn[x][y + 1].setEnabled(true);

		try {
			tileRules.autoTile();
		} catch (Exception e) {
			autoTurnCount = 0;
		}

		sessionBtnFix = true;

		if ((turnCount - autoTurnCount ) % 2 == 0) {
			user = true;
		} else if ((turnCount - autoTurnCount ) % 2 == 1) {
			user = false;
		}

		if (winAl.checkWinWhite_circle(x, y)) {
			finishPop.whiteWin(1);
			new NewGame();
			ai.resetAI();
		} else if (winAl.checkWinWhite_8tile(x, y)) {
			finishPop.whiteWin(0);
			new NewGame();
			ai.resetAI();
		} else if (winAl.checkWinBlack_circle(x, y)) {
			finishPop.blackWin(1);
			new NewGame();
			ai.resetAI();
		} else if (winAl.checkWinBlack_8tile(x, y)) {
			finishPop.blackWin(0);
			new NewGame();
			ai.resetAI();
		}
		autoAi = false;
		fixEnd = true;
	}

	// click button -> view tempTile
	private void setTile(int i, int j, int r) {

		if (rule[i][j] == 0) {

			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			}
		} else if (rule[i][j] == 1) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;
			}

		} else if (rule[i][j] == 2) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;
			}

		} else if (rule[i][j] == 3) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;
			}

		} else if (rule[i][j] == 4) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;
			}

		} else if (rule[i][j] == 5) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;
			}

		} else if (rule[i][j] == 6) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;
			}

		} else if (rule[i][j] == 7) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;
			}

		} else if (rule[i][j] == 8) {
			switch (btnCnt[i][j] % 3) {
			case 0:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 2:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;
			}

		} else if (rule[i][j] == 9) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;

			}

		} else if (rule[i][j] == 10) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;

			}

		} else if (rule[i][j] == 11) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile1);
				type[i][j] = "NorthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;

			}

		} else if (rule[i][j] == 12) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile3);
				type[i][j] = "EastSouth";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;

			}

		} else if (rule[i][j] == 13) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;

			}

		} else if (rule[i][j] == 14) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;

			}

		} else if (rule[i][j] == 15) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile4);
				type[i][j] = "SouthWest";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile6);
				type[i][j] = "NorthSouth";
				break;

			}

		} else if (rule[i][j] == 16) {
			switch (btnCnt[i][j] % 2) {
			case 0:
				btn[i][j].setIcon(tmp_tile2);
				type[i][j] = "NorthEast";
				break;
			case 1:
				btn[i][j].setIcon(tmp_tile5);
				type[i][j] = "EastWest";
				break;

			}

		}
	}

	public static void saveButtonStatus() {
		stackCnt++;
		stack[stackCnt] = new TraxStack();
		stack[stackCnt].stack(rule, type, btnCnt, tempType);
	}

	public static void unDO() {

		stackCnt--;

		if (stackCnt < 0) {
			JOptionPane.showMessageDialog(null, "Undo를 할 수 없습니다.", "Warning", JOptionPane.PLAIN_MESSAGE);
			stackCnt = 0;
			return;
		}
		turnCount--;

		rule = stack[stackCnt].getRule();
		type = stack[stackCnt].getType();
		btnCnt = stack[stackCnt].getBtncnt();
		//tempType = stack[stackCnt].getTempType();
		
		tempTileRules.reset();

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (type[i][j] == "Empty") {
					btn[i][j].setEnabled(false);
					btn[i][j].setDisabledIcon(tile0);
				}
			}
		}
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (type[i][j] == "NorthWest") {
					btn[i][j].setIcon(tile1);
					set4tile(i, j);
				} else if (type[i][j] == "NorthEast") {
					btn[i][j].setIcon(tile2);
					set4tile(i, j);
				} else if (type[i][j] == "EastSouth") {
					btn[i][j].setIcon(tile3);
					set4tile(i, j);
				} else if (type[i][j] == "SouthWest") {
					btn[i][j].setIcon(tile4);
					set4tile(i, j);
				} else if (type[i][j] == "EastWest") {
					btn[i][j].setDisabledIcon(tile5);
					set4tile(i, j);
				} else if (type[i][j] == "NorthSouth") {
					btn[i][j].setIcon(tile6);
					set4tile(i, j);
				}
			}
		}
		stack[stackCnt] = new TraxStack();
		stack[stackCnt].stack(rule, type, btnCnt, tempType);

		if (Buttons.user == false) {
			Buttons.user = true;
		} else {
			Buttons.user = false;
		}
	}

	public static void set4tile(int i, int j) {
		if (btnCnt[i + 1][j] == 0) {
			btn[i + 1][j].setEnabled(true);
			btn[i + 1][j].setIcon(tile0);
		}
		if (btnCnt[i - 1][j] == 0) {
			btn[i - 1][j].setEnabled(true);
			btn[i - 1][j].setIcon(tile0);
		}
		if (btnCnt[i][j + 1] == 0) {
			btn[i][j + 1].setEnabled(true);
			btn[i][j + 1].setIcon(tile0);
		}
		if (btnCnt[i][j - 1] == 0) {
			btn[i][j - 1].setEnabled(true);
			btn[i][j - 1].setIcon(tile0);
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (fixEnd == false && gameStart == false) {
				saveButtonStatus();
				if (Buttons.user == false) {
					str = "White: ( 64, 64, " + whatTile(64, 64) + " )\n";
				} else {
					str = "Black: ( 64, 64, " + whatTile(64, 64) + " )\n";
				}
				textBox.setTextArea(str);
				fixTile(64, 64);
				new GameStatusBar();
				gameStart = true;
			} else if (fixEnd == false && gameStart == true) {
				saveButtonStatus();
				if (Buttons.user == false) {
					str = "White: ( " + Integer.parseInt(sessionActionCommand) / 128 + ", "
							+ Integer.parseInt(sessionActionCommand) % 128 + ", "
							+ whatTile(Integer.parseInt(sessionActionCommand) / 128,
									Integer.parseInt(sessionActionCommand) % 128)
							+ " )\n";
				} else {
					str = "Black: ( " + Integer.parseInt(sessionActionCommand) / 128 + ", "
							+ Integer.parseInt(sessionActionCommand) % 128 + ", "
							+ whatTile(Integer.parseInt(sessionActionCommand) / 128,
									Integer.parseInt(sessionActionCommand) % 128)
							+ " )\n";
				}
				textBox.setTextArea(str);
				fixTile(Integer.parseInt(sessionActionCommand) / 128, Integer.parseInt(sessionActionCommand) % 128);
				new GameStatusBar();
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			if (fixEnd == false && gameStart == false) {
				if (Buttons.user == false) {
					str = "White: ( 64, 64, " + whatTile(64, 64) + " )\n  ";
				} else {
					str = "Black: ( 64, 64, " + whatTile(64, 64) + " )\n  ";
				}
				textBox.setTextArea(str);
				fixTile(64, 64);
				new GameStatusBar();
				gameStart = true;
				saveButtonStatus();
			} else if (fixEnd == false && gameStart == true) {
				if (Buttons.user == false) {
					str = "White: ( " + Integer.parseInt(sessionActionCommand) / 128 + ", "
							+ Integer.parseInt(sessionActionCommand) % 128 + ", "
							+ whatTile(Integer.parseInt(sessionActionCommand) / 128,
									Integer.parseInt(sessionActionCommand) % 128)
							+ " )\n";
				} else {
					str = "Black: ( " + Integer.parseInt(sessionActionCommand) / 128 + ", "
							+ Integer.parseInt(sessionActionCommand) % 128 + ", "
							+ whatTile(Integer.parseInt(sessionActionCommand) / 128,
									Integer.parseInt(sessionActionCommand) % 128)
							+ " )\n";
				}
				textBox.setTextArea(str);
				fixTile(Integer.parseInt(sessionActionCommand) / 128, Integer.parseInt(sessionActionCommand) % 128);
				new GameStatusBar();
				saveButtonStatus();
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
