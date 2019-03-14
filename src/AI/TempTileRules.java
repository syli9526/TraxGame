package AI;

import Engine.Buttons;

public class TempTileRules {
	
	public void tempTileRule(int i, int j) {
		// If there is a single tile around the center tile

		// up : black
		if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth") && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j - 1] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {

			Buttons.tempType1[i][j] ="NorthWest";
			Buttons.tempType2[i][j] ="NorthEast";
			Buttons.tempType3[i][j] ="NorthSouth";
		}
		// up :white
		else if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest") && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j - 1] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {
			Buttons.tempType1[i][j] ="EastSouth";
			Buttons.tempType2[i][j] ="SouthWest";
			Buttons.tempType3[i][j] ="EastWest";
		}
		// right : black
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j - 1] == "Empty" && (Buttons.tempType[i][j + 1] == "NorthWest"
						|| Buttons.tempType[i][j + 1] == "SouthWest" || Buttons.tempType[i][j + 1] == "EastWest")) {
			
			Buttons.tempType1[i][j] ="NorthEast";
			Buttons.tempType2[i][j] ="EastSouth";
			Buttons.tempType3[i][j] ="EastWest";
		}
		// right : white
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j - 1] == "Empty" && (Buttons.tempType[i][j + 1] == "NorthEast"
						|| Buttons.tempType[i][j + 1] == "EastSouth" || Buttons.tempType[i][j + 1] == "NorthSouth")) {
			Buttons.tempType1[i][j] ="SouthWest";
			Buttons.tempType2[i][j] ="NorthWest";
			Buttons.tempType3[i][j] ="NorthSouth";
		}
		// down :black
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty"
				&& Buttons.tempType[i][j + 1] == "Empty" && (Buttons.tempType[i + 1][j] == "NorthWest"
						|| Buttons.tempType[i + 1][j] == "NorthEast" || Buttons.tempType[i + 1][j] == "NorthSouth")) {
			Buttons.tempType1[i][j] ="EastSouth";
			Buttons.tempType2[i][j] ="SouthWest";
			Buttons.tempType3[i][j] ="NorthSouth";
		}
		// down : white
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty"
				&& Buttons.tempType[i][j + 1] == "Empty" && (Buttons.tempType[i + 1][j] == "EastSouth"
						|| Buttons.tempType[i + 1][j] == "SouthWest" || Buttons.tempType[i + 1][j] == "EastWest")) {
			Buttons.tempType1[i][j] ="NorthWest";
			Buttons.tempType2[i][j] ="NorthEast";
			Buttons.tempType3[i][j] ="EastWest";
		}

		// left : black
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j + 1] == "Empty" && (Buttons.tempType[i][j - 1] == "NorthEast"
						|| Buttons.tempType[i][j - 1] == "EastSouth" || Buttons.tempType[i][j - 1] == "EastWest")) {
			Buttons.tempType1[i][j] ="NorthWest";
			Buttons.tempType2[i][j] ="SouthWest";
			Buttons.tempType3[i][j] ="EastWest";
		}

		// left : white
		else if (Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i + 1][j] == "Empty"
				&& Buttons.tempType[i][j + 1] == "Empty" && (Buttons.tempType[i][j - 1] == "NorthWest"
						|| Buttons.tempType[i][j - 1] == "SouthWest" || Buttons.tempType[i][j - 1] == "NorthSouth")) {
			Buttons.tempType1[i][j] ="EastSouth";
			Buttons.tempType2[i][j] ="NorthEast";
			Buttons.tempType3[i][j] ="NorthSouth";
		}

		// If there is two tile around the center tile

		// up :white , right : black
		else if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest")
				&& (Buttons.tempType[i][j + 1] == "NorthWest" || Buttons.tempType[i][j + 1] == "SouthWest"
						|| Buttons.tempType[i][j + 1] == "EastWest")
				&& Buttons.tempType[i + 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty") {
		
			Buttons.tempType1[i][j] ="EastSouth";
			Buttons.tempType2[i][j] ="EastWest";
			Buttons.tempType3[i][j] ="EastWest";
		}

		// up : black , right :white
		else if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j + 1] == "NorthEast" || Buttons.tempType[i][j + 1] == "EastSouth"
						|| Buttons.tempType[i][j + 1] == "NorthSouth")
				&& Buttons.tempType[i + 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty") {
		
			Buttons.tempType1[i][j] ="NorthWest";
			Buttons.tempType2[i][j] ="NorthSouth";
			Buttons.tempType3[i][j] ="NorthSouth";
		}

		// right : white , down : black
		else if ((Buttons.tempType[i + 1][j] == "EastSouth" || Buttons.tempType[i + 1][j] == "SouthWest"
				|| Buttons.tempType[i + 1][j] == "EastWest")
				&& (Buttons.tempType[i][j - 1] == "NorthEast" || Buttons.tempType[i][j - 1] == "EastSouth"
						|| Buttons.tempType[i][j - 1] == "EastWest")
				&& Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {
		
			Buttons.tempType1[i][j] ="NorthWest";
			Buttons.tempType2[i][j] ="EastWest";
			Buttons.tempType3[i][j] ="EastWest";
		}

		// right : black, down : white
		else if ((Buttons.tempType[i + 1][j] == "NorthWest" || Buttons.tempType[i + 1][j] == "NorthEast"
				|| Buttons.tempType[i + 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j - 1] == "NorthWest" || Buttons.tempType[i][j - 1] == "SouthWest"
						|| Buttons.tempType[i][j - 1] == "NorthSouth")
				&& Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {
		
			Buttons.tempType1[i][j] ="EastSouth";
			Buttons.tempType2[i][j] ="NorthSouth";
			Buttons.tempType3[i][j] ="NorthSouth";
		}
		// down : white , left : black
		else if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j - 1] == "NorthWest" || Buttons.tempType[i][j - 1] == "SouthWest"
						|| Buttons.tempType[i][j - 1] == "NorthSouth")
				&& Buttons.tempType[i + 1][j] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {
		
			Buttons.tempType1[i][j] ="NorthEast";
			Buttons.tempType2[i][j] ="NorthSouth";
			Buttons.tempType3[i][j] ="NorthSouth";
		}

		// down : black , left : white
		else if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest")
				&& (Buttons.tempType[i][j - 1] == "NorthEast" || Buttons.tempType[i][j - 1] == "EastSouth"
						|| Buttons.tempType[i][j - 1] == "EastWest")
				&& Buttons.tempType[i + 1][j] == "Empty" && Buttons.tempType[i][j + 1] == "Empty") {
			Buttons.tempType1[i][j] ="SouthWest";
			Buttons.tempType2[i][j] ="EastWest";
			Buttons.tempType3[i][j] ="EastWest";
		}

		// left : white , up : black
		else if ((Buttons.type[i + 1][j] == "NorthWest" || Buttons.tempType[i + 1][j] == "NorthEast"
				|| Buttons.tempType[i + 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j + 1] == "NorthEast" || Buttons.tempType[i][j + 1] == "EastSouth"
						|| Buttons.tempType[i][j + 1] == "NorthSouth")
				&& Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty") {

			Buttons.tempType1[i][j] ="SouthWest";
			Buttons.tempType2[i][j] ="NorthSouth";
			Buttons.tempType3[i][j] ="NorthSouth";
		}

		// left : black , up : white
		else if ((Buttons.tempType[i + 1][j] == "EastSouth" || Buttons.tempType[i + 1][j] == "SouthWest"
				|| Buttons.tempType[i + 1][j] == "EastWest")
				&& (Buttons.tempType[i][j + 1] == "NorthWest" || Buttons.tempType[i][j + 1] == "SouthWest"
						|| Buttons.tempType[i][j + 1] == "EastWest")
				&& Buttons.tempType[i - 1][j] == "Empty" && Buttons.tempType[i][j - 1] == "Empty") {

			Buttons.tempType1[i][j] ="NorthEast";
			Buttons.tempType2[i][j] ="EastWest";
			Buttons.tempType3[i][j] ="EastWest";
		}
	}
	public void tempAutoTileRule(int i, int j) {

		
		if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest")
				&& (Buttons.tempType[i][j + 1] == "NorthEast" || Buttons.tempType[i][j + 1] == "EastSouth"
						|| Buttons.tempType[i][j + 1] == "NorthSouth")) {
			Buttons.tempType[i][j] = "SouthWest";

		}

		else if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest")
				&& (Buttons.tempType[i][j - 1] == "NorthWest" || Buttons.tempType[i][j - 1] == "SouthWest"
						|| Buttons.tempType[i][j - 1] == "NorthSouth")) {

			Buttons.tempType[i][j] = "EastSouth";

		}

		else if ((Buttons.tempType[i + 1][j] == "EastSouth" || Buttons.tempType[i + 1][j] == "SouthWest"
				|| Buttons.tempType[i + 1][j] == "EastWest")
				&& (Buttons.tempType[i][j + 1] == "NorthEast" || Buttons.tempType[i][j + 1] == "EastSouth"
						|| Buttons.tempType[i][j + 1] == "NorthSouth")) {
			Buttons.tempType[i][j] = "NorthWest";

		} else if ((Buttons.tempType[i + 1][j] == "EastSouth" || Buttons.tempType[i + 1][j] == "SouthWest"
				|| Buttons.tempType[i + 1][j] == "EastWest")
				&& (Buttons.tempType[i][j - 1] == "NorthWest" || Buttons.tempType[i][j - 1] == "SouthWest"
						|| Buttons.tempType[i][j - 1] == "NorthSouth")) {

			Buttons.tempType[i][j] = "NorthEast";

		} else if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j + 1] == "NorthWest" || Buttons.tempType[i][j + 1] == "SouthWest"
						|| Buttons.tempType[i][j + 1] == "EastWest")) {

			Buttons.tempType[i][j] = "NorthEast";

		} else if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j - 1] == "NorthEast" || Buttons.tempType[i][j - 1] == "EastSouth"
						|| Buttons.tempType[i][j - 1] == "EastWest")) {

			Buttons.tempType[i][j] = "NorthWest";

		}

		else if ((Buttons.tempType[i + 1][j] == "NorthWest" || Buttons.tempType[i + 1][j] == "NorthEast"
				|| Buttons.tempType[i + 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j + 1] == "NorthWest" || Buttons.tempType[i][j + 1] == "SouthWest"
						|| Buttons.tempType[i][j + 1] == "EastWest")) {

			Buttons.tempType[i][j] = "EastSouth";

		}

		else if ((Buttons.tempType[i + 1][j] == "NorthWest" || Buttons.tempType[i + 1][j] == "NorthEast"
				|| Buttons.tempType[i + 1][j] == "NorthSouth")
				&& (Buttons.tempType[i][j - 1] == "NorthEast" || Buttons.tempType[i][j - 1] == "EastSouth"
						|| Buttons.tempType[i][j - 1] == "EastWest")) {

			Buttons.tempType[i][j] = "SouthWest";

		}

		else if ((Buttons.tempType[i - 1][j] == "NorthWest" || Buttons.tempType[i - 1][j] == "NorthEast"
				|| Buttons.tempType[i - 1][j] == "EastWest")
				&& (Buttons.tempType[i + 1][j] == "EastSouth" || Buttons.tempType[i + 1][j] == "SouthWest"
						|| Buttons.tempType[i + 1][j] == "EastWest")) {

			Buttons.tempType[i][j] = "EastWest";

		} else if ((Buttons.tempType[i][j + 1] == "NorthEast" || Buttons.tempType[i][j + 1] == "EastSouth"
				|| Buttons.tempType[i][j + 1] == "NorthSouth")
				&& (Buttons.tempType[i][j - 1] == "NorthWest" || Buttons.tempType[i][j - 1] == "SouthWest"
						|| Buttons.tempType[i][j - 1] == "NorthSouth")) {

			Buttons.tempType[i][j] = "NorthSouth";

		}

		else if ((Buttons.tempType[i - 1][j] == "EastSouth" || Buttons.tempType[i - 1][j] == "SouthWest"
				|| Buttons.tempType[i - 1][j] == "NorthSouth")
				&& (Buttons.tempType[i + 1][j] == "NorthWest" || Buttons.tempType[i + 1][j] == "NorthEast"
						|| Buttons.tempType[i + 1][j] == "NorthSouth")) {

			Buttons.tempType[i][j] = "NorthSouth";

		}

		else if ((Buttons.tempType[i][j + 1] == "NorthWest" || Buttons.tempType[i][j + 1] == "SouthWest"
				|| Buttons.tempType[i][j + 1] == "EastWest")
				&& (Buttons.tempType[i][j - 1] == "NorthEast" || Buttons.tempType[i][j - 1] == "EastSouth"
						|| Buttons.tempType[i][j - 1] == "EastWest")) {

			Buttons.tempType[i][j] = "EastWest";

		}
	}
	


	public void reset() {

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				Buttons.tempType[i][j] = Buttons.type[i][j];
			}
		}
	}

}
