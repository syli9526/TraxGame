package Engine;

import GUI.TextBox;

public class TileRules {

	private TextBox textBox;
	private String str;

	public TileRules() {
		textBox = TextBox.GetInstance();
	}

	public void tileRule(int i, int j) {
		// If there is a single tile around the center tile

		// up : black
		if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth") && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j - 1] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 1;
		}
		// up :white
		else if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest") && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j - 1] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 2;

		}
		// right : black
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j - 1] == "Empty" && (Buttons.type[i][j + 1] == "NorthWest"
						|| Buttons.type[i][j + 1] == "SouthWest" || Buttons.type[i][j + 1] == "EastWest")) {
			Buttons.rule[i][j] = 3;

		}
		// right : white
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j - 1] == "Empty" && (Buttons.type[i][j + 1] == "NorthEast"
						|| Buttons.type[i][j + 1] == "EastSouth" || Buttons.type[i][j + 1] == "NorthSouth")) {
			Buttons.rule[i][j] = 4;

		}
		// down :black
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty"
				&& Buttons.type[i][j + 1] == "Empty" && (Buttons.type[i + 1][j] == "NorthWest"
						|| Buttons.type[i + 1][j] == "NorthEast" || Buttons.type[i + 1][j] == "NorthSouth")) {
			Buttons.rule[i][j] = 5;

		}
		// down : white
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty"
				&& Buttons.type[i][j + 1] == "Empty" && (Buttons.type[i + 1][j] == "EastSouth"
						|| Buttons.type[i + 1][j] == "SouthWest" || Buttons.type[i + 1][j] == "EastWest")) {
			Buttons.rule[i][j] = 6;

		}

		// left : black
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j + 1] == "Empty" && (Buttons.type[i][j - 1] == "NorthEast"
						|| Buttons.type[i][j - 1] == "EastSouth" || Buttons.type[i][j - 1] == "EastWest")) {

			Buttons.rule[i][j] = 7;

		}

		// left : white
		else if (Buttons.type[i - 1][j] == "Empty" && Buttons.type[i + 1][j] == "Empty"
				&& Buttons.type[i][j + 1] == "Empty" && (Buttons.type[i][j - 1] == "NorthWest"
						|| Buttons.type[i][j - 1] == "SouthWest" || Buttons.type[i][j - 1] == "NorthSouth")) {
			Buttons.rule[i][j] = 8;

		}

		// If there is two tile around the center tile

		// up :white , right : black
		else if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest")
				&& (Buttons.type[i][j + 1] == "NorthWest" || Buttons.type[i][j + 1] == "SouthWest"
						|| Buttons.type[i][j + 1] == "EastWest")
				&& Buttons.type[i + 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty") {
			Buttons.rule[i][j] = 9;

		}

		// up : black , right :white
		else if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth")
				&& (Buttons.type[i][j + 1] == "NorthEast" || Buttons.type[i][j + 1] == "EastSouth"
						|| Buttons.type[i][j + 1] == "NorthSouth")
				&& Buttons.type[i + 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty") {
			Buttons.rule[i][j] = 10;

		}

		// right : white , down : black
		else if ((Buttons.type[i + 1][j] == "EastSouth" || Buttons.type[i + 1][j] == "SouthWest"
				|| Buttons.type[i + 1][j] == "EastWest")
				&& (Buttons.type[i][j - 1] == "NorthEast" || Buttons.type[i][j - 1] == "EastSouth"
						|| Buttons.type[i][j - 1] == "EastWest")
				&& Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 11;

		}

		// right : black, down : white
		else if ((Buttons.type[i + 1][j] == "NorthWest" || Buttons.type[i + 1][j] == "NorthEast"
				|| Buttons.type[i + 1][j] == "NorthSouth")
				&& (Buttons.type[i][j - 1] == "NorthWest" || Buttons.type[i][j - 1] == "SouthWest"
						|| Buttons.type[i][j - 1] == "NorthSouth")
				&& Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 12;

		}
		// down : white , left : black
		else if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth")
				&& (Buttons.type[i][j - 1] == "NorthWest" || Buttons.type[i][j - 1] == "SouthWest"
						|| Buttons.type[i][j - 1] == "NorthSouth")
				&& Buttons.type[i + 1][j] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 13;

		}

		// down : black , left : white
		else if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest")
				&& (Buttons.type[i][j - 1] == "NorthEast" || Buttons.type[i][j - 1] == "EastSouth"
						|| Buttons.type[i][j - 1] == "EastWest")
				&& Buttons.type[i + 1][j] == "Empty" && Buttons.type[i][j + 1] == "Empty") {
			Buttons.rule[i][j] = 14;

		}

		// left : white , up : black
		else if ((Buttons.type[i + 1][j] == "NorthWest" || Buttons.type[i + 1][j] == "NorthEast"
				|| Buttons.type[i + 1][j] == "NorthSouth")
				&& (Buttons.type[i][j + 1] == "NorthEast" || Buttons.type[i][j + 1] == "EastSouth"
						|| Buttons.type[i][j + 1] == "NorthSouth")
				&& Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty") {
			Buttons.rule[i][j] = 15;

		}

		// left : black , up : white
		else if ((Buttons.type[i + 1][j] == "EastSouth" || Buttons.type[i + 1][j] == "SouthWest"
				|| Buttons.type[i + 1][j] == "EastWest")
				&& (Buttons.type[i][j + 1] == "NorthWest" || Buttons.type[i][j + 1] == "SouthWest"
						|| Buttons.type[i][j + 1] == "EastWest")
				&& Buttons.type[i - 1][j] == "Empty" && Buttons.type[i][j - 1] == "Empty") {
			Buttons.rule[i][j] = 16;

		}
	}

	public void autoTile() {
		for (int j = 0; j < 128; j++) {
			for (int i = 0; i < 128; i++) {
				if (Buttons.btn[i][j].isEnabled() == false)
					continue;
				else {
					autoTileRule(i, j);
				}
			}
		}
	}

	public void autoTileRule(int i, int j) {

		if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest")
				&& (Buttons.type[i][j + 1] == "NorthEast" || Buttons.type[i][j + 1] == "EastSouth"
						|| Buttons.type[i][j + 1] == "NorthSouth")) {
			Buttons.type[i][j] = "SouthWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "\\" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		}

		else if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest")
				&& (Buttons.type[i][j - 1] == "NorthWest" || Buttons.type[i][j - 1] == "SouthWest"
						|| Buttons.type[i][j - 1] == "NorthSouth")) {
			Buttons.type[i][j] = "EastSouth";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "/" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;
		}

		else if ((Buttons.type[i + 1][j] == "EastSouth" || Buttons.type[i + 1][j] == "SouthWest"
				|| Buttons.type[i + 1][j] == "EastWest")
				&& (Buttons.type[i][j + 1] == "NorthEast" || Buttons.type[i][j + 1] == "EastSouth"
						|| Buttons.type[i][j + 1] == "NorthSouth")) {
			Buttons.type[i][j] = "NorthWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "/" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;
		} else if ((Buttons.type[i + 1][j] == "EastSouth" || Buttons.type[i + 1][j] == "SouthWest"
				|| Buttons.type[i + 1][j] == "EastWest")
				&& (Buttons.type[i][j - 1] == "NorthWest" || Buttons.type[i][j - 1] == "SouthWest"
						|| Buttons.type[i][j - 1] == "NorthSouth")) {
			Buttons.type[i][j] = "NorthEast";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "\\" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		} else if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth")
				&& (Buttons.type[i][j + 1] == "NorthWest" || Buttons.type[i][j + 1] == "SouthWest"
						|| Buttons.type[i][j + 1] == "EastWest")) {
			Buttons.type[i][j] = "NorthEast";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "\\" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		} else if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth")
				&& (Buttons.type[i][j - 1] == "NorthEast" || Buttons.type[i][j - 1] == "EastSouth"
						|| Buttons.type[i][j - 1] == "EastWest")) {
			Buttons.type[i][j] = "NorthWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "/" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		}

		else if ((Buttons.type[i + 1][j] == "NorthWest" || Buttons.type[i + 1][j] == "NorthEast"
				|| Buttons.type[i + 1][j] == "NorthSouth")
				&& (Buttons.type[i][j + 1] == "NorthWest" || Buttons.type[i][j + 1] == "SouthWest"
						|| Buttons.type[i][j + 1] == "EastWest")) {
			Buttons.type[i][j] = "EastSouth";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "/" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;
		}

		else if ((Buttons.type[i + 1][j] == "NorthWest" || Buttons.type[i + 1][j] == "NorthEast"
				|| Buttons.type[i + 1][j] == "NorthSouth")
				&& (Buttons.type[i][j - 1] == "NorthEast" || Buttons.type[i][j - 1] == "EastSouth"
						|| Buttons.type[i][j - 1] == "EastWest")) {
			Buttons.type[i][j] = "SouthWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "\\" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		}

		else if ((Buttons.type[i - 1][j] == "NorthWest" || Buttons.type[i - 1][j] == "NorthEast"
				|| Buttons.type[i - 1][j] == "EastWest")
				&& (Buttons.type[i + 1][j] == "EastSouth" || Buttons.type[i + 1][j] == "SouthWest"
						|| Buttons.type[i + 1][j] == "EastWest")) {
			Buttons.type[i][j] = "EastWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "+" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;
		} else if ((Buttons.type[i][j + 1] == "NorthEast" || Buttons.type[i][j + 1] == "EastSouth"
				|| Buttons.type[i][j + 1] == "NorthSouth")
				&& (Buttons.type[i][j - 1] == "NorthWest" || Buttons.type[i][j - 1] == "SouthWest"
						|| Buttons.type[i][j - 1] == "NorthSouth")) {
			Buttons.type[i][j] = "NorthSouth";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "+" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;
		}

		else if ((Buttons.type[i - 1][j] == "EastSouth" || Buttons.type[i - 1][j] == "SouthWest"
				|| Buttons.type[i - 1][j] == "NorthSouth")
				&& (Buttons.type[i + 1][j] == "NorthWest" || Buttons.type[i + 1][j] == "NorthEast"
						|| Buttons.type[i + 1][j] == "NorthSouth")) {
			Buttons.type[i][j] = "NorthSouth";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "+" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		}

		else if ((Buttons.type[i][j + 1] == "NorthWest" || Buttons.type[i][j + 1] == "SouthWest"
				|| Buttons.type[i][j + 1] == "EastWest")
				&& (Buttons.type[i][j - 1] == "NorthEast" || Buttons.type[i][j - 1] == "EastSouth"
						|| Buttons.type[i][j - 1] == "EastWest")) {
			Buttons.type[i][j] = "EastWest";
			Buttons.btnCnt[i][j]++;
			Buttons.fixTile(i, j);
			str = "AutoTile: ( " + i + ", " + j + ", " + "+" + " )\n";
			textBox.setTextArea(str);
			Buttons.autoTurnCount++;

		}

	}
}
