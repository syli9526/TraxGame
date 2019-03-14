package Engine;

public class WinningAlgorithm {

	public WinningAlgorithm() {
	}

	public int CheckWhite_8tileEnd(int i, int j, int prev_i, int prev_j) {

		while (Buttons.type[i][j] != "Empty") {
			if (Buttons.type[i][j] == "NorthWest") {

				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;

				} else {
					prev_i = i;
					prev_j = j;
					i = i + 1;

				}
			} else if (Buttons.type[i][j] == "NorthEast") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				}
			}

			else if (Buttons.type[i][j] == "EastSouth") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			}

			else if (Buttons.type[i][j] == "SouthWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			} else if (Buttons.type[i][j] == "EastWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i + 1;

				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			} else if (Buttons.type[i][j] == "NorthSouth") {
				if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				}
			} else {
			}
		}
		return 128 * prev_i + prev_j;
	}

	public int CheckBlack_8tileEnd(int i, int j, int prev_i, int prev_j) {
		
	
		while (Buttons.type[i][j] != "Empty") {
			if (Buttons.type[i][j] == "NorthWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			} else if (Buttons.type[i][j] == "NorthEast") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			} else if (Buttons.type[i][j] == "EastSouth") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				}
			} else if (Buttons.type[i][j] == "SouthWest") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;

				} else {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				}
			}

			else if (Buttons.type[i][j] == "EastWest") {
				if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				}
			}

			else if (Buttons.type[i][j] == "NorthSouth") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				}
			}

			else {
			}
		}
		return 128 * prev_i + prev_j;
	}

	public boolean checkWinWhite_8tile(int i_idx, int j_idx) {
		int rd_i = 0, rd_j = 0;
		int ld_i = 0, ld_j = 0;
		int endRd_i = 0, endRd_j = 0;
		int endLd_i = 0, endLd_j = 0;
		int xDistance = 0, yDistance = 0;

		if (Buttons.type[i_idx][j_idx] == "NorthWest") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (Buttons.type[i_idx][j_idx] == "NorthEast") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (Buttons.type[i_idx][j_idx] == "EastSouth") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (Buttons.type[i_idx][j_idx] == "SouthWest") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (Buttons.type[i_idx][j_idx] == "EastWest") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx + 1;
			rd_j = j_idx;

		} else if (Buttons.type[i_idx][j_idx] == "NorthSouth") {
			ld_i = i_idx;
			ld_j = j_idx - 1;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else {
			return false;
		}

		endLd_i = CheckWhite_8tileEnd(ld_i, ld_j, i_idx, j_idx) / 128;
		endLd_j = CheckWhite_8tileEnd(ld_i, ld_j, i_idx, j_idx) % 128;
		endRd_i = CheckWhite_8tileEnd(rd_i, rd_j, i_idx, j_idx) / 128;
		endRd_j = CheckWhite_8tileEnd(rd_i, rd_j, i_idx, j_idx) % 128;

		xDistance = endRd_j - endLd_j;
		yDistance = endRd_i - endLd_i;

		// System.out.println("white_xDistance : " + xDistance);
		// System.out.println("white_yDistance : " + yDistance);
		// System.out.println("white_endLd_type:"+ Buttons.type[endLd_i][endLd_j]);
		// System.out.println("white_endRd_type:"+ Buttons.type[endRd_i][endRd_j]);

		if (xDistance >= 7) {
			if ((Buttons.type[endLd_i][endLd_j] == "NorthEast" || Buttons.type[endLd_i][endLd_j] == "EastSouth"
					|| Buttons.type[endLd_i][endLd_j] == "NorthSouth")
					&& (Buttons.type[endRd_i][endRd_j] == "NorthWest" || Buttons.type[endRd_i][endRd_j] == "SouthWest"
							|| Buttons.type[endRd_i][endRd_j] == "NorthSouth"))
				return true;
		} else if (xDistance <= -7) {
			if ((Buttons.type[endRd_i][endRd_j] == "NorthEast" || Buttons.type[endRd_i][endRd_j] == "EastSouth"
					|| Buttons.type[endRd_i][endRd_j] == "NorthSouth")
					&& (Buttons.type[endLd_i][endLd_j] == "NorthWest" || Buttons.type[endLd_i][endLd_j] == "SouthWest"
							|| Buttons.type[endLd_i][endLd_j] == "NorthSouth"))
				return true;

		}
		if (yDistance >= 7) {
			if ((Buttons.type[endLd_i][endLd_j] == "EastSouth" || Buttons.type[endLd_i][endLd_j] == "SouthWest"
					|| Buttons.type[endLd_i][endLd_j] == "EastWest")
					&& (Buttons.type[endRd_i][endRd_j] == "NorthWest" || Buttons.type[endRd_i][endRd_j] == "NorthEast"
							|| Buttons.type[endRd_i][endRd_j] == "EastWest"))
				return true;
		} else if (yDistance <= -7) {
			if ((Buttons.type[endRd_i][endRd_j] == "EastSouth" || Buttons.type[endRd_i][endRd_j] == "SouthWest"
					|| Buttons.type[endRd_i][endRd_j] == "EastWest")
					&& (Buttons.type[endLd_i][endLd_j] == "NorthWest" || Buttons.type[endLd_i][endLd_j] == "NorthEast"
							|| Buttons.type[endLd_i][endLd_j] == "EastWest"))
				return true;
		}

		return false;
	}

	public boolean checkWinBlack_8tile(int i_idx, int j_idx) {
		int rd_i = 0, rd_j = 0;
		int ld_i = 0, ld_j = 0;
		int endRd_i = 0, endRd_j = 0;
		int endLd_i = 0, endLd_j = 0;
		int xDistance = 0, yDistance = 0;

		if (Buttons.type[i_idx][j_idx] == "NorthWest") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (Buttons.type[i_idx][j_idx] == "NorthEast") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (Buttons.type[i_idx][j_idx] == "EastSouth") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (Buttons.type[i_idx][j_idx] == "SouthWest") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (Buttons.type[i_idx][j_idx] == "EastWest") {
			ld_i = i_idx;
			ld_j = j_idx - 1;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (Buttons.type[i_idx][j_idx] == "NorthSouth") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx + 1;
			rd_j = j_idx;
		} else {
			return false;
		}

		endLd_i = CheckBlack_8tileEnd(ld_i, ld_j, i_idx, j_idx) / 128;
		endLd_j = CheckBlack_8tileEnd(ld_i, ld_j, i_idx, j_idx) % 128;
		endRd_i = CheckBlack_8tileEnd(rd_i, rd_j, i_idx, j_idx) / 128;
		endRd_j = CheckBlack_8tileEnd(rd_i, rd_j, i_idx, j_idx) % 128;

		xDistance = endRd_j - endLd_j;
		yDistance = endRd_i - endLd_i;

		// System.out.println("black_xDistance : " + xDistance);
		// System.out.println("black_yDistance : " + yDistance);
		// System.out.println("black_endLd_type:"+ Buttons.type[endLd_i][endLd_j]);
		// System.out.println("black_endRd_type:"+ Buttons.type[endRd_i][endRd_j]);

		if (xDistance >= 7) {
			if ((Buttons.type[endLd_i][endLd_j] == "NorthWest" || Buttons.type[endLd_i][endLd_j] == "SouthWest"
					|| Buttons.type[endLd_i][endLd_j] == "EastWest")
					&& (Buttons.type[endRd_i][endRd_j] == "NorthEast" || Buttons.type[endRd_i][endRd_j] == "EastSouth"
							|| Buttons.type[endRd_i][endRd_j] == "EastWest"))
				return true;
		} else if (xDistance <= -7) {
			if ((Buttons.type[endRd_i][endRd_j] == "NorthWest" || Buttons.type[endRd_i][endRd_j] == "SouthWest"
					|| Buttons.type[endRd_i][endRd_j] == "EastWest")
					&& (Buttons.type[endLd_i][endLd_j] == "NorthEast" || Buttons.type[endLd_i][endLd_j] == "EastSouth"
							|| Buttons.type[endLd_i][endLd_j] == "EastWest"))
				return true;
		}

		if (yDistance >= 7) {
			if ((Buttons.type[endLd_i][endLd_j] == "NorthWest" || Buttons.type[endLd_i][endLd_j] == "NorthEast"
					|| Buttons.type[endLd_i][endLd_j] == "NorthSouth")
					&& (Buttons.type[endRd_i][endRd_j] == "EastSouth" || Buttons.type[endRd_i][endRd_j] == "SouthWest"
							|| Buttons.type[endRd_i][endRd_j] == "NorthSouth"))
				return true;
		} else if (yDistance <= -7) {
			if ((Buttons.type[endRd_i][endRd_j] == "NorthWest" || Buttons.type[endRd_i][endRd_j] == "NorthEast"
					|| Buttons.type[endRd_i][endRd_j] == "NorthSouth")
					&& (Buttons.type[endLd_i][endLd_j] == "EastSouth" || Buttons.type[endLd_i][endLd_j] == "SouthWest"
							|| Buttons.type[endLd_i][endLd_j] == "NorthSouth"))
				return true;
		}

		return false;
	}

	public boolean checkWinWhite_circle(int i_idx, int j_idx) {

		int i = 0, prev_i = 0;
		int j = 0, prev_j = 0;

		if (Buttons.type[i_idx][j_idx] == "NorthWest") {
			if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}
		}

		else if (Buttons.type[i_idx][j_idx] == "NorthEast") {
			if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;
			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "EastSouth") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;
			} else {
				return false;
			}
		}

		else if (Buttons.type[i_idx][j_idx] == "SouthWest") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "EastWest") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "NorthSouth") {
			if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;
			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}
		} else {
			return false;
		}

		prev_i = i_idx;
		prev_j = j_idx;

		while (i_idx != i || j_idx != j) {
			if (Buttons.type[i][j] == "NorthWest") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else {
					return false;
				}
			} else if (Buttons.type[i][j] == "NorthEast") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else {
					return false;
				}
			}

			else if (Buttons.type[i][j] == "EastSouth") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					i = i - 1;

				} else {
					return false;
				}
			} else if (Buttons.type[i][j] == "SouthWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				} else {
					return false;
				}

			} else if (Buttons.type[i][j] == "EastWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				} else {
					return false;
				}
			}

			else if (Buttons.type[i][j] == "NorthSouth") {
				if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else {
					return false;
				}
			} else {
				return false;
			}
			// if (Buttons.btn[i][j].isEnabled()) {
			// System.out.println("circle_White_i : " + i);
			// System.out.println("circle_White_j : " + j);
			// System.out.println("circle_white_fix_i : " + i_idx);
			// System.out.println("circle_white_fix_j : " + j_idx);
			// }

		}

		return true;
	}

	public boolean checkWinBlack_circle(int i_idx, int j_idx) {
		int i = 0, prev_i = 0;
		int j = 0, prev_j = 0;

		if (Buttons.type[i_idx][j_idx] == "NorthWest") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;

			} else {
				return false;
			}

		} else if (Buttons.type[i_idx][j_idx] == "NorthEast") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}

		} else if (Buttons.type[i_idx][j_idx] == "EastSouth") {
			if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "SouthWest") {
			if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;

			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "EastWest") {
			if (!Buttons.btn[i_idx][j_idx - 1].isEnabled()) {
				if (j_idx - 1 < 0) {
					return false;
				}
				i = i_idx;
				j = j_idx - 1;

			} else if (!Buttons.btn[i_idx][j_idx + 1].isEnabled()) {
				if (j_idx + 1 > 128) {
					return false;
				}
				i = i_idx;
				j = j_idx + 1;
			} else {
				return false;
			}
		} else if (Buttons.type[i_idx][j_idx] == "NorthSouth") {
			if (!Buttons.btn[i_idx - 1][j_idx].isEnabled()) {
				if (i_idx - 1 < 0) {
					return false;
				}
				i = i_idx - 1;
				j = j_idx;
			} else if (!Buttons.btn[i_idx + 1][j_idx].isEnabled()) {
				if (i_idx + 1 > 128) {
					return false;
				}
				i = i_idx + 1;
				j = j_idx;
			} else {
				return false;
			}

		} else {
			return false;
		}
		prev_i = i_idx;
		prev_j = j_idx;

		while (i_idx != i || j_idx != j) {

			if (Buttons.type[i][j] == "NorthWest") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				} else {
					return false;
				}

			} else if (Buttons.type[i][j] == "NorthEast") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				} else {
					return false;
				}

			} else if (Buttons.type[i][j] == "EastSouth") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else {
					return false;
				}
			}

			else if (Buttons.type[i][j] == "SouthWest") {
				if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else {
					return false;
				}

			}

			else if (Buttons.type[i][j] == "EastWest") {

				if (prev_i == i && prev_j == j - 1) {
					prev_i = i;
					prev_j = j;
					j = j + 1;
				} else if (prev_i == i && prev_j == j + 1) {
					prev_i = i;
					prev_j = j;
					j = j - 1;
				} else {
					return false;
				}
			} else if (Buttons.type[i][j] == "NorthSouth") {
				if (prev_i == i - 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i + 1;
				} else if (prev_i == i + 1 && prev_j == j) {
					prev_i = i;
					prev_j = j;
					i = i - 1;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;

	}
}
