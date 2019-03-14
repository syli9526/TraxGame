package Function;


import javax.swing.ImageIcon;

import AI.EngineAI;
import Engine.Buttons;
import GUI.GameStatusBar;
import GUI.TextBox;

public class NewGame {
	private TextBox textBox;

	public NewGame() {
		Buttons.turnCount =1;
		Buttons.autoTurnCount =0;
		Buttons.aiTurnCount = 0;
		Buttons.autoAi = false;
		Buttons.fixEnd = false;
		Buttons.gameStart = false;
		Buttons.stackCnt = -1;
		Buttons.ai.resetAI();
		textBox = TextBox.GetInstance();
		
		if ((Buttons.turnCount - Buttons.autoTurnCount ) % 2 == 0) {
			Buttons.user = true;
		} else if ((Buttons.turnCount - Buttons.autoTurnCount ) % 2 == 1) {
			Buttons.user = false;
		}
		
		for(int j = 0 ; j <128 ; j++) {
			for(int i =0; i <128 ; i ++) {
				Buttons.type[i][j] = "Empty";
				Buttons.tempType[i][j] = "Empty";
				Buttons.tempType1[i][j] = "Empty";
				Buttons.tempType2[i][j] = "Empty";
				Buttons.tempType3[i][j] = "Empty";
				Buttons.rule[i][j] = 0;
				Buttons.btnCnt[i][j] = 0;
				Buttons.btn[i][j].setEnabled(true);
				Buttons.btn[i][j].setIcon(new ImageIcon("Img/0.png"));
				textBox.resetTextArea();
			}
		}
		
		new GameStatusBar();

	}

}
