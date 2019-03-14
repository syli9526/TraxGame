package GUI;

import javax.swing.*;

import Engine.Buttons;

import java.awt.*;

public class GameStatusBar {

	static JLabel gameStatusBar = new JLabel();

	public GameStatusBar() {

		if (Buttons.user == false) {
			gameStatusBar.setText("              사용자 : White     타일갯수  :  " + (Buttons.turnCount - 1) + "    클릭횟수 : "
					+ (Buttons.turnCount - 1 - Buttons.autoTurnCount));
		} else {
			gameStatusBar.setText("              사용자: Black    타일갯수  :  " + (Buttons.turnCount - 1) + "    클릭횟수   :  "
					+ (Buttons.turnCount - 1 - Buttons.autoTurnCount));
		}

	}

	void setGameStatusBar(JFrame frame) {
		/**
		 * @ @ param: frame (JFrame) @ return:
		 */
		frame.add(gameStatusBar, BorderLayout.SOUTH);
	}
}
