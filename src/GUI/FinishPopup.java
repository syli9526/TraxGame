package GUI;

import javax.swing.JOptionPane;

public class FinishPopup {

	public void whiteWin(int i) {

		if (i == 0) {
			JOptionPane.showMessageDialog(null, " Win White ", " More than 8 Tile ", JOptionPane.PLAIN_MESSAGE);
		}
		
		if(i ==1) {
			JOptionPane.showMessageDialog(null, " Win White ", " Make Circle ", JOptionPane.PLAIN_MESSAGE);

		}
	}
	
	public void blackWin(int i) {

		if (i == 0) {
			JOptionPane.showMessageDialog(null, " Win Black ", " More than 8 Tile ", JOptionPane.PLAIN_MESSAGE);
		}
		
		if(i ==1) {
			JOptionPane.showMessageDialog(null, " Win Black ", " Make Circle ", JOptionPane.PLAIN_MESSAGE);

		}
	}
}
