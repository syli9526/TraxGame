package AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Engine.Buttons;

import GUI.GameStatusBar;


public class AIRun implements ActionListener {
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Timer ai_timer = new Timer();

		TimerTask ai_task = new TimerTask() {

			@Override
			public void run() {
				
				
				System.out.println("gamestart : " + Buttons.gameStart);
				System.out.println("user : " + Buttons.user);
				if (Buttons.gameStart == false) {
					if (Buttons.user == false) {
						System.out.println("Buttons.user : " + Buttons.user);
						if (new Random().nextInt(2) == 0) {
							Buttons.ai.fix_type = "EastSouth";
						}
						else {
							Buttons.ai.fix_type = "EastWest";
						}
						Buttons.ai.autoAI();
						Buttons.gameStart = true;
						Buttons.saveButtonStatus();
						new GameStatusBar();
					} else {
						ai_timer.cancel();

					}
				} else {

					if (Buttons.autoAi == false && Buttons.user == false) {
						System.out.println("Buttons.user : " + Buttons.user);
						Buttons.ai.whiteTileAI();
						Buttons.ai.autoAI();
						Buttons.saveButtonStatus();
						new GameStatusBar();
					} else if (Buttons.autoAi == false && Buttons.user == true) {
						System.out.println("Buttons.user : " + Buttons.user);
						Buttons.ai.blackTileAI();
						Buttons.ai.autoAI();
						Buttons.saveButtonStatus();
						new GameStatusBar();
					} else {
						ai_timer.cancel();
					}
				}
			}
		};

		ai_timer.schedule(ai_task, 1000);

	}
}
