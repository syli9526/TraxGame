package AI;

import java.util.ArrayList;

import Engine.Buttons;

public class WeightBlackTile {

	public int Black_length_maxWeight;
	public String Black_length_maxType;
	public int Black_length_count;

	public int Black_circle_rd_i;
	public int Black_circle_rd_j;
	public int Black_circle_ld_i;
	public int Black_circle_ld_j;
	public int Black_circle_maxWeight = 100;
	public String Black_circle_maxType;
	public int Black_circle_count;

	private TempTileRules tempTileRules = new TempTileRules();

	public static ArrayList<CircleMaxWeightInfo> blackCircleMax = new ArrayList<CircleMaxWeightInfo>();
	public static ArrayList<LengthMaxWeightInfo> blackLengthMax = new ArrayList<LengthMaxWeightInfo>();
	
	public static ArrayList<CircleMaxWeightInfo> tempBlackCircleMax = new ArrayList<CircleMaxWeightInfo>();
	public static ArrayList<LengthMaxWeightInfo> tempBlackLengthMax = new ArrayList<LengthMaxWeightInfo>();
	
	
	public void max_checkReset() {

		Black_length_maxWeight = 0;
		Black_circle_maxWeight = 100;

	}

	public void checkTempEnabledTile() {
		
		tempBlackCircleMax.add(new CircleMaxWeightInfo(0, 0, 0, "Empty", 0, 0, 0, 0, 0));
		tempBlackLengthMax.add(new LengthMaxWeightInfo(0, 0, 0, "Empty", 0));

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (Buttons.btn[i][j].isEnabled() == false)
					continue;
				else {
					tempTileRules.reset();
					tempTileRules.tempTileRule(i, j);

					if (checkTileType(i, j, Buttons.tempType1[i][j], 1)) {

						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
								tempTileRules.reset();
								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0];
								Black_length_maxType = Buttons.tempType1[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[7];

								tempBlackLengthMax.clear();
								tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));
							}

							else {
								tempTileRules.reset();
								if (checkTileType(i, j, Buttons.tempType1[i][j], 1)) {
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0];

									Black_length_maxType = Buttons.tempType1[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[7];
									tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {

									continue;
								}
							}

						}

					} else {
						continue;
					}
					tempTileRules.reset();
					if (checkTileType(i, j, Buttons.tempType2[i][j], 2)) {
						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0];

								Black_length_maxType = Buttons.tempType2[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[7];
								tempBlackLengthMax.clear();
								tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));

							} else {
								tempTileRules.reset();
								if (checkTileType(i, j, Buttons.tempType2[i][j], 2)) {
									tempTileRules.reset();
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0];

									Black_length_maxType = Buttons.tempType2[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[7];
									tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {

									continue;
								}

							}

						}
					} else {
						continue;
					}
					tempTileRules.reset();
					if (checkTileType(i, j, Buttons.tempType3[i][j], 3)) {
						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
								tempTileRules.reset();
								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0];

								Black_length_maxType = Buttons.tempType3[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[7];
								tempBlackLengthMax.clear();
								tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));

							} else {

								if (checkTileType(i, j, Buttons.tempType3[i][j], 3)) {
									tempTileRules.reset();
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0];

									Black_length_maxType = Buttons.tempType3[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[7];
									tempBlackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {
									continue;
								}
							}

						}
					} else {
						continue;
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType1[i][j], 1)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[5];

							Black_circle_maxType = Buttons.tempType1[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType1[i][j], 1)[1];
							tempBlackCircleMax.clear();
							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType1[i][j], 1)[0];

							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[5];

							Black_circle_maxType = Buttons.tempType1[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType1[i][j], 1)[1];
							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType2[i][j], 2)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[5];
							Black_circle_maxType = Buttons.tempType2[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType2[i][j], 2)[1];
							tempBlackCircleMax.clear();
							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType2[i][j], 2)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[5];
							Black_circle_maxType = Buttons.tempType2[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType2[i][j], 2)[1];

							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType3[i][j], 3)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[5];
							Black_circle_maxType = Buttons.tempType3[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType3[i][j], 3)[1];
							tempBlackCircleMax.clear();
							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType3[i][j], 3)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[5];
							Black_circle_maxType = Buttons.tempType3[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType3[i][j], 3)[1];

							tempBlackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}

				}

			}
		}

		max_checkReset();
		
	}

	public void checkEnabledTile() {

		blackCircleMax.add(new CircleMaxWeightInfo(0, 0, 0, "Empty", 0, 0, 0, 0, 0));
		blackLengthMax.add(new LengthMaxWeightInfo(0, 0, 0, "Empty", 0));

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (Buttons.btn[i][j].isEnabled() == false)
					continue;
				else {
					tempTileRules.reset();
					tempTileRules.tempTileRule(i, j);

					if (checkTileType(i, j, Buttons.tempType1[i][j], 1)) {

						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
								tempTileRules.reset();
								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0];
								Black_length_maxType = Buttons.tempType1[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[7];

								blackLengthMax.clear();
								blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));
							}

							else {
								tempTileRules.reset();
								if (checkTileType(i, j, Buttons.tempType1[i][j], 1)) {
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[0];

									Black_length_maxType = Buttons.tempType1[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType1[i][j], 1)[7];
									blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {

									continue;
								}
							}

						}

					} else {
						continue;
					}
					tempTileRules.reset();
					if (checkTileType(i, j, Buttons.tempType2[i][j], 2)) {
						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0];

								Black_length_maxType = Buttons.tempType2[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[7];
								blackLengthMax.clear();
								blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));

							} else {
								tempTileRules.reset();
								if (checkTileType(i, j, Buttons.tempType2[i][j], 2)) {
									tempTileRules.reset();
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[0];

									Black_length_maxType = Buttons.tempType2[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType2[i][j], 2)[7];
									blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {

									continue;
								}

							}

						}
					} else {
						continue;
					}
					tempTileRules.reset();
					if (checkTileType(i, j, Buttons.tempType3[i][j], 3)) {
						if (Black_length_maxWeight <= lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {

							if (Black_length_maxWeight != lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
								tempTileRules.reset();
								Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0];

								Black_length_maxType = Buttons.tempType3[i][j];
								Black_length_count = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[7];
								blackLengthMax.clear();
								blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
										Black_length_maxType, Black_length_count));

							} else {

								if (checkTileType(i, j, Buttons.tempType3[i][j], 3)) {
									tempTileRules.reset();
									Black_length_maxWeight = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[0];

									Black_length_maxType = Buttons.tempType3[i][j];
									Black_length_count = lengthWeight(i, j, Buttons.tempType3[i][j], 3)[7];
									blackLengthMax.add(new LengthMaxWeightInfo(i, j, Black_length_maxWeight,
											Black_length_maxType, Black_length_count));

								} else {
									continue;
								}
							}

						}
					} else {
						continue;
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType1[i][j], 1)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType1[i][j], 1)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[5];

							Black_circle_maxType = Buttons.tempType1[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType1[i][j], 1)[1];
							blackCircleMax.clear();
							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType1[i][j], 1)[0];

							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType1[i][j], 1)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType1[i][j], 1)[5];

							Black_circle_maxType = Buttons.tempType1[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType1[i][j], 1)[1];
							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {

						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType2[i][j], 2)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType2[i][j], 2)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[5];
							Black_circle_maxType = Buttons.tempType2[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType2[i][j], 2)[1];
							blackCircleMax.clear();
							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType2[i][j], 2)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType2[i][j], 2)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType2[i][j], 2)[5];
							Black_circle_maxType = Buttons.tempType2[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType2[i][j], 2)[1];

							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}
					tempTileRules.reset();
					if (Black_circle_maxWeight >= circleWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
						if (Black_circle_maxWeight != circleWeight(i, j, Buttons.tempType3[i][j], 3)[0]) {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType3[i][j], 3)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[5];
							Black_circle_maxType = Buttons.tempType3[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType3[i][j], 3)[1];
							blackCircleMax.clear();
							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						} else {
							tempTileRules.reset();
							Black_circle_maxWeight = circleWeight(i, j, Buttons.tempType3[i][j], 3)[0];
							Black_circle_ld_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[2];
							Black_circle_ld_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[3];
							Black_circle_rd_i = circleWeight(i, j, Buttons.tempType3[i][j], 3)[4];
							Black_circle_rd_j = circleWeight(i, j, Buttons.tempType3[i][j], 3)[5];
							Black_circle_maxType = Buttons.tempType3[i][j];
							Black_circle_count = circleWeight(i, j, Buttons.tempType3[i][j], 3)[1];

							blackCircleMax.add(new CircleMaxWeightInfo(i, j, Black_circle_maxWeight,
									Black_circle_maxType, Black_circle_count, Black_circle_ld_i, Black_circle_ld_j,
									Black_circle_rd_i, Black_circle_rd_j));

						}
					}

				}

			}
		}

		max_checkReset();
	}

	public int checkBlack_tileEnd(int i, int j, int prev_i, int prev_j) {

		int check_i, check_j;
		check_i = prev_i;
		check_j = prev_j;

		while (Buttons.tempType[i][j] != "Empty") {

			if (check_i != i || check_j != j) {

				if (Buttons.tempType[i][j] == "NorthWest") {
					if (prev_i == i - 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j - 1;
					} else {
						prev_i = i;
						prev_j = j;
						i = i - 1;
					}
				} else if (Buttons.tempType[i][j] == "NorthEast") {
					if (prev_i == i - 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j + 1;
					} else {
						prev_i = i;
						prev_j = j;
						i = i - 1;
					}
				} else if (Buttons.tempType[i][j] == "EastSouth") {
					if (prev_i == i + 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j + 1;
					} else {
						prev_i = i;
						prev_j = j;
						i = i + 1;
					}
				} else if (Buttons.tempType[i][j] == "SouthWest") {
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

				else if (Buttons.tempType[i][j] == "EastWest") {
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

				else if (Buttons.tempType[i][j] == "NorthSouth") {
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

			} else {
				break;
			}
		}

		return (128 * i) + j;
	}

	public int[] checkBlack_8tileEnd(int i, int j, int prev_i, int prev_j) {

		int check_i, check_j;
		check_i = prev_i;
		check_j = prev_j;

		int count = 0;

		int[] returnArr = new int[2];

		while (Buttons.tempType[i][j] != "Empty") {
			if (check_i != i || check_j != j) {
				if (Buttons.tempType[i][j] == "NorthWest") {
					if (prev_i == i - 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j - 1;
						count++;
					} else {
						prev_i = i;
						prev_j = j;
						i = i - 1;
						count++;
					}
				} else if (Buttons.tempType[i][j] == "NorthEast") {
					if (prev_i == i - 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j + 1;
						count++;
					} else {
						prev_i = i;
						prev_j = j;
						i = i - 1;
						count++;
					}
				} else if (Buttons.tempType[i][j] == "EastSouth") {
					if (prev_i == i + 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j + 1;
						count++;
					} else {
						prev_i = i;
						prev_j = j;
						i = i + 1;
						count++;
					}
				} else if (Buttons.tempType[i][j] == "SouthWest") {
					if (prev_i == i + 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						j = j - 1;
						count++;

					} else {
						prev_i = i;
						prev_j = j;
						i = i + 1;
						count++;
					}
				}

				else if (Buttons.tempType[i][j] == "EastWest") {
					if (prev_i == i && prev_j == j - 1) {
						prev_i = i;
						prev_j = j;
						j = j + 1;
						count++;
					} else {
						prev_i = i;
						prev_j = j;
						j = j - 1;
						count++;
					}
				}

				else if (Buttons.tempType[i][j] == "NorthSouth") {
					if (prev_i == i - 1 && prev_j == j) {
						prev_i = i;
						prev_j = j;
						i = i + 1;
						count++;
					} else {
						prev_i = i;
						prev_j = j;
						i = i - 1;
						count++;
					}
				}

				else {
				}
			} else {
				break;
			}

		}

		returnArr[0] = 128 * prev_i + prev_j;
		returnArr[1] = count;

		return returnArr;
	}

	public int[] checkBlackAI_tempTile(int i_idx, int j_idx, String tempType, int tempTypeNum) {

		int rd_i = 0, rd_j = 0;
		int ld_i = 0, ld_j = 0;
		int endRd_i = 0, endRd_j = 0;
		int endLd_i = 0, endLd_j = 0;

		// check prev

		int prevEndRd_i = 0, prevEndRd_j = 0;
		int prevEndLd_i = 0, prevEndLd_j = 0;

		int totalCount;

		int[] ENDCOORDI = new int[9];

		Buttons.tempType[i_idx][j_idx] = tempType;

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (Buttons.btn[i][j].isEnabled() == false)
					continue;
				else
					tempTileRules.tempAutoTileRule(i, j);
			}
		}

		if (tempType == "NorthWest") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (tempType == "NorthEast") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (tempType == "EastSouth") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (tempType == "SouthWest") {
			ld_i = i_idx + 1;
			ld_j = j_idx;
			rd_i = i_idx;
			rd_j = j_idx - 1;
		} else if (tempType == "EastWest") {
			ld_i = i_idx;
			ld_j = j_idx - 1;
			rd_i = i_idx;
			rd_j = j_idx + 1;
		} else if (tempType == "NorthSouth") {
			ld_i = i_idx - 1;
			ld_j = j_idx;
			rd_i = i_idx + 1;
			rd_j = j_idx;
		} else {

		}

		endLd_i = checkBlack_tileEnd(ld_i, ld_j, i_idx, j_idx) / 128;
		endLd_j = checkBlack_tileEnd(ld_i, ld_j, i_idx, j_idx) % 128;
		endRd_i = checkBlack_tileEnd(rd_i, rd_j, i_idx, j_idx) / 128;
		endRd_j = checkBlack_tileEnd(rd_i, rd_j, i_idx, j_idx) % 128;

		prevEndLd_i = checkBlack_8tileEnd(ld_i, ld_j, i_idx, j_idx)[0] / 128;
		prevEndLd_j = checkBlack_8tileEnd(ld_i, ld_j, i_idx, j_idx)[0] % 128;
		prevEndRd_i = checkBlack_8tileEnd(rd_i, rd_j, i_idx, j_idx)[0] / 128;
		prevEndRd_j = checkBlack_8tileEnd(rd_i, rd_j, i_idx, j_idx)[0] % 128;

		totalCount = checkBlack_8tileEnd(ld_i, ld_j, i_idx, j_idx)[1]
				+ checkBlack_8tileEnd(rd_i, rd_j, i_idx, j_idx)[1];

		ENDCOORDI[0] = endLd_i;
		ENDCOORDI[1] = endLd_j;
		ENDCOORDI[2] = endRd_i;
		ENDCOORDI[3] = endRd_j;

		ENDCOORDI[4] = prevEndLd_i;
		ENDCOORDI[5] = prevEndLd_j;
		ENDCOORDI[6] = prevEndRd_i;
		ENDCOORDI[7] = prevEndRd_j;

		ENDCOORDI[8] = totalCount;

		return ENDCOORDI;

	}

	public boolean checkTileType(int i_idx, int j_idx, String tempType, int tempTypeNum) {

		int endLd_i, endLd_j, endRd_i, endRd_j;
		int xDistance, yDistance;
		String type = tempType;

		endLd_i = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[1];
		endLd_j = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[2];
		endRd_i = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[3];
		endRd_j = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[4];
		xDistance = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[5];
		yDistance = lengthWeight(i_idx, j_idx, tempType, tempTypeNum)[6];

		if (xDistance >= 7) {

			if (i_idx == endLd_i && j_idx == endLd_j) {
				if ((type == "NorthWest" || type == "SouthWest" || type == "EastWest")
						&& (Buttons.tempType[endRd_i][endRd_j] == "NorthWest"
								|| Buttons.tempType[endRd_i][endRd_j] == "SouthWest"
								|| Buttons.tempType[endRd_i][endRd_j] == "NorthSouth")) {
					return false;
				}
			} else if (i_idx == endRd_i && j_idx == endRd_j) {

				if ((type == "NorthEast" || type == "EastSouth" || type == "EastWest")
						&& (Buttons.tempType[endLd_i][endLd_j] == "NorthEast"
								|| Buttons.tempType[endLd_i][endLd_j] == "EastSouth"
								|| Buttons.tempType[endLd_i][endLd_j] == "NorthSouth")) {
					return false;
				}
			}

		}
		if (xDistance <= -7) {

			if (i_idx == endLd_i && j_idx == endLd_j) {
				if ((type == "NorthEast" || type == "EastSouth" || type == "EastWest")
						&& (Buttons.tempType[endRd_i][endRd_j] == "NorthEast"
								|| Buttons.tempType[endRd_i][endRd_j] == "EastSouth"
								|| Buttons.tempType[endRd_i][endRd_j] == "NorthSouth")) {

					return false;
				}
			} else if (i_idx == endRd_i && j_idx == endRd_j) {

				if ((type == "NorthWest" || type == "SouthWest" || type == "EastWest")
						&& (Buttons.tempType[endLd_i][endLd_j] == "NorthWest"
								|| Buttons.tempType[endLd_i][endLd_j] == "SouthWest"
								|| Buttons.tempType[endLd_i][endLd_j] == "NorthSouth")) {
					return false;
				}
			}

		}
		if (yDistance >= 7) {
			if (i_idx == endLd_i && j_idx == endLd_j) {
				if ((type == "NorthWest" || type == "NorthEast" || type == "NorthSouth")
						&& (Buttons.tempType[endRd_i][endRd_j] != "EastSouth"
								&& Buttons.tempType[endRd_i][endRd_j] != "SouthWest"
								&& Buttons.tempType[endRd_i][endRd_j] != "EastWest")) {
					return false;
				}
			} else if (i_idx == endRd_i && j_idx == endRd_j) {
				if ((type == "EastSouth" || type == "SouthWest" || type == "NorthSouth")
						&& (Buttons.tempType[endLd_i][endLd_j] != "NorthWest"
								&& Buttons.tempType[endLd_i][endLd_j] != "NorthEast"
								&& Buttons.tempType[endLd_i][endLd_j] != "EastWest")) {
					return false;
				}
			}
		}
		if (yDistance <= -7) {
			if (i_idx == endLd_i && j_idx == endLd_j) {
				if ((type == "EastSouth" || type == "SouthWest" || type == "NorthSouth")
						&& (Buttons.tempType[endRd_i][endRd_j] != "NorthWest"
								&& Buttons.tempType[endRd_i][endRd_j] != "NorthEast"
								&& Buttons.tempType[endRd_i][endRd_j] != "EastWest")) {
					return false;
				}
			} else if (i_idx == endRd_i && j_idx == endRd_j) {
				if ((type == "NorthWest" || type == "NorthEast" || type == "NorthSouth")
						&& (Buttons.tempType[endLd_i][endLd_j] != "EastSouth"
								&& Buttons.tempType[endLd_i][endLd_j] != "SouthWest"
								&& Buttons.tempType[endLd_i][endLd_j] != "EastWest")) {

					return false;
				}
			}

		}

		return true;
	}

	public int[] lengthWeight(int i_idx, int j_idx, String tempType, int tempTypeNum) {

		int endLd_i, endLd_j, endRd_i, endRd_j;
		int lengthWeight;
		int prevEndRd_i, prevEndRd_j, prevEndLd_i, prevEndLd_j;
		int xDistance = 0, yDistance = 0;

		int lengthCount;

		int[] returnArr = new int[8];

		endLd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[0];
		endLd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[1];
		endRd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[2];
		endRd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[3];

		prevEndLd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[4];
		prevEndLd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[5];
		prevEndRd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[6];
		prevEndRd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[7];

		lengthCount = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[8];

		xDistance = endRd_j - endLd_j;
		yDistance = endRd_i - endLd_i;

		if (Math.abs(xDistance) < Math.abs(yDistance)) {
			lengthWeight = Math.abs(yDistance);

		} else {
			lengthWeight = Math.abs(xDistance);

		}

		returnArr[0] = lengthWeight;
		returnArr[1] = prevEndLd_i;
		returnArr[2] = prevEndLd_j;
		returnArr[3] = prevEndRd_i;
		returnArr[4] = prevEndRd_j;
		returnArr[5] = xDistance;
		returnArr[6] = yDistance;
		returnArr[7] = lengthCount;

		return returnArr;

	}

	public int[] circleWeight(int i_idx, int j_idx, String tempType, int tempTypeNum) {

		int endLd_i, endLd_j, endRd_i, endRd_j;
		int circleWeight;
		int xDistance = 0, yDistance = 0;
		int circleCount;

		int[] returnArr = new int[6];
		// int pre_xDistance =0, pre_yDistance =0;
		// int prevEndRd_i, prevEndRd_j, prevEndLd_i, prevEndLd_j;

		endLd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[0];
		endLd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[1];
		endRd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[2];
		endRd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[3];

		// prevEndLd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[4];
		// prevEndLd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[5];
		// prevEndRd_i = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[6];
		// prevEndRd_j = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[7];

		circleCount = checkBlackAI_tempTile(i_idx, j_idx, tempType, tempTypeNum)[8];

		xDistance = endRd_j - endLd_j;
		yDistance = endRd_i - endLd_i;

		xDistance = Math.abs(xDistance);
		yDistance = Math.abs(yDistance);

		//
		// pre_xDistance = prevEndRd_i - prevEndLd_i;
		// pre_yDistance = prevEndRd_j - prevEndLd_j;
		//
		// pre_xDistance = Math.abs(pre_xDistance);
		// pre_yDistance = Math.abs(pre_yDistance);

		circleWeight = xDistance + yDistance;

		returnArr[0] = circleWeight;
		returnArr[1] = circleCount;
		returnArr[2] = endLd_i;
		returnArr[3] = endLd_j;
		returnArr[4] = endRd_i;
		returnArr[5] = endRd_j;

		return returnArr;
	}

}