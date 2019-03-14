package AI;

import Engine.Buttons;
import GUI.TextBox;

public class EngineAI {

	public WeightBlackTile black = new WeightBlackTile();
	public WeightWhiteTile white = new WeightWhiteTile();

	private TempTileRules tempTileRules = new TempTileRules();

	private TextBox textBox;
	private String str;

	public int temp_i;
	public int temp_j;
	public String temp_type;

	public int temp_distance;

	public int fix_i = 64;
	public int fix_j = 64;
	public String fix_type;

	private int whiteLengthWinWeight;
	private int whiteLengthDangerWeight;
	private int whiteCircleWinWeight;
	private int whiteCircleDangerWeight;

	private int blackLengthWinWeight;
	private int blackLengthDangerWeight;
	private int blackCircleWinWeight;
	private int blackCircleDangerWeight;

	public EngineAI() {
		textBox = TextBox.GetInstance();
	}

	public void whiteWeightCalculator() {

		if (WeightWhiteTile.whiteLengthMax.get(0).distance >= 10) {
			whiteLengthWinWeight = 120;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 9) {
			whiteLengthWinWeight = 80;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 8) {
			whiteLengthWinWeight = 60;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 7) {
			whiteLengthWinWeight = 40;

		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 6) {
			whiteLengthWinWeight = 20;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 5) {
			whiteLengthWinWeight = 10;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance <= 4) {
			whiteLengthWinWeight = 10;
		}

		if (WeightWhiteTile.whiteCircleMax.get(0).distance == 0) {
			whiteCircleWinWeight = 110;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 1) {
			whiteCircleWinWeight = 90;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 2) {
			whiteCircleWinWeight = 70;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 3) {
			whiteCircleWinWeight = 50;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 4) {
			whiteCircleWinWeight = 30;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 5) {
			whiteCircleWinWeight = 10;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance >= 6) {
			whiteCircleWinWeight = 0;
		}

		if (WeightBlackTile.blackLengthMax.get(0).distance >= 8) {
			whiteLengthDangerWeight = 95;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 7) {
			whiteLengthDangerWeight = 75;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 6) {
			whiteLengthDangerWeight = 55;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 5) {
			whiteLengthDangerWeight = 35;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 4) {
			whiteLengthDangerWeight = 15;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance <= 3) {
			whiteLengthDangerWeight = 5;
		}

		if (WeightBlackTile.blackCircleMax.get(0).distance == 0) {
			whiteCircleDangerWeight = 105;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 1) {
			whiteCircleDangerWeight = 85;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 2) {
//			if (WeightBlackTile.blackCircleMax.get(0).ld_i == WeightBlackTile.blackCircleMax.get(0).rd_i
//					|| WeightBlackTile.blackCircleMax.get(0).ld_j == WeightBlackTile.blackCircleMax.get(0).rd_j) {
//				whiteCircleDangerWeight = 105;
//			} else
			whiteCircleDangerWeight = 65;

		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 3) {
			if (WeightBlackTile.blackCircleMax.get(0).ld_i == WeightBlackTile.blackCircleMax.get(0).rd_i
					|| WeightBlackTile.blackCircleMax.get(0).ld_j == WeightBlackTile.blackCircleMax.get(0).rd_j) {
				whiteCircleDangerWeight = 105;
			} else
				whiteCircleDangerWeight = 45;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 4) {
			whiteCircleDangerWeight = 25;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 5) {
			whiteCircleDangerWeight = 5;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance >= 6) {
			whiteCircleDangerWeight = 5;
		}

	}

	public void blackWeightCalculator() {

		if (WeightBlackTile.blackLengthMax.get(0).distance >= 10) {
			blackLengthWinWeight = 120;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 9) {
			blackLengthWinWeight = 80;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 8) {
			blackLengthWinWeight = 60;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 7) {
			blackLengthWinWeight = 40;

		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 6) {
			blackLengthWinWeight = 20;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance == 5) {
			blackLengthWinWeight = 10;
		} else if (WeightBlackTile.blackLengthMax.get(0).distance <= 4) {
			blackLengthWinWeight = 0;
		}

		if (WeightBlackTile.blackCircleMax.get(0).distance == 0) {
			blackCircleWinWeight = 110;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 1) {
			blackCircleWinWeight = 90;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 2) {
			blackCircleWinWeight = 70;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 3) {
			blackCircleWinWeight = 50;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 4) {
			blackCircleWinWeight = 30;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance == 5) {
			blackCircleWinWeight = 10;
		} else if (WeightBlackTile.blackCircleMax.get(0).distance >= 6) {
			blackCircleWinWeight = 0;
		}
		if (WeightWhiteTile.whiteLengthMax.get(0).distance >= 7) {
			blackLengthDangerWeight = 95;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 6) {
			blackLengthDangerWeight = 75;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 5) {
			blackLengthDangerWeight = 55;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 4) {
			blackLengthDangerWeight = 35;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance == 3) {
			blackLengthDangerWeight = 15;
		} else if (WeightWhiteTile.whiteLengthMax.get(0).distance <= 2) {
			blackLengthDangerWeight = 5;
		}

		if (WeightWhiteTile.whiteCircleMax.get(0).distance < 1) {
			blackCircleDangerWeight = 105;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 1) {
			blackCircleDangerWeight = 85;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 2) {
			blackCircleDangerWeight = 65;

		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 3) {
			if (WeightBlackTile.blackCircleMax.get(0).ld_i == WeightBlackTile.blackCircleMax.get(0).rd_i
					|| WeightBlackTile.blackCircleMax.get(0).ld_j == WeightBlackTile.blackCircleMax.get(0).rd_j) {
				whiteCircleDangerWeight = 105;
			} else
				blackCircleDangerWeight = 45;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 4) {
			blackCircleDangerWeight = 25;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance == 5) {
			blackCircleDangerWeight = 5;
		} else if (WeightWhiteTile.whiteCircleMax.get(0).distance >= 6) {
			blackCircleDangerWeight = 0;
		}

	}

	public void blackTileAI() {

		black.checkEnabledTile();
		white.checkEnabledTile();

		blackWeightCalculator();

		tempTileRules.reset();

		if (blackLengthWinWeight > blackCircleWinWeight) {

			if ((blackLengthWinWeight > blackLengthDangerWeight) && (blackLengthWinWeight > blackCircleDangerWeight)) {
				int gapDistance = 20;
				for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {
					temp_i = WeightBlackTile.blackLengthMax.get(i).i;
					temp_j = WeightBlackTile.blackLengthMax.get(i).j;
					temp_type = WeightBlackTile.blackLengthMax.get(i).type;

					tempTileRules.reset();
					Buttons.tempType[temp_i][temp_j] = temp_type;
					white.checkTempEnabledTile();
					tempTileRules.reset();

					if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
						continue;
					} else {
						if (gapDistance > getGap(WeightWhiteTile.tempWhiteCircleMax.get(0).distance)
								+ getGap(WeightWhiteTile.tempWhiteLengthMax.get(0).distance)) {
							gapDistance = getGap(WeightWhiteTile.tempWhiteCircleMax.get(0).distance)
									+ getGap(WeightWhiteTile.tempWhiteLengthMax.get(0).distance);
							fix_i = temp_i;
							fix_j = temp_j;
							fix_type = temp_type;
						} else {
							continue;
						}
						tempTileRules.reset();
					}
				}

			}

			else {
				if (blackLengthDangerWeight > blackCircleDangerWeight) {

					if (blackLengthDangerWeight >= 60) {
						temp_distance = 100;
						tempTileRules.reset();
						int temp_fix_i = 0;
						int temp_fix_j = 0;

						for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {

							temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
							temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
							temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

							tempTileRules.reset();

							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType1[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType3[temp_i][temp_j];
								}

							} else {
								continue;
							}
							tempTileRules.reset();

						}

						if (temp_distance < WeightWhiteTile.whiteLengthMax.get(0).distance - 2) {
							fix_i = temp_fix_i;
							fix_j = temp_fix_j;
							fix_type = temp_type;

						} else {

							if (blackCircleWinWeight >= blackLengthWinWeight) {

								int gapDistance = 20;
								for (int i = 0; i < WeightBlackTile.blackCircleMax.size(); i++) {
									temp_i = WeightBlackTile.blackCircleMax.get(i).i;
									temp_j = WeightBlackTile.blackCircleMax.get(i).j;
									temp_type = WeightBlackTile.blackCircleMax.get(i).type;

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = temp_type;
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										tempTileRules.reset();
										if (gapDistance > getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
												+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
											gapDistance = getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
											fix_i = temp_i;
											fix_j = temp_j;
											fix_type = temp_type;
										} else {
											continue;
										}
									}
									tempTileRules.reset();

								}

							} else if (blackLengthWinWeight > blackCircleWinWeight) {

								int gapDistance = 20;
								for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {
									temp_i = WeightBlackTile.blackLengthMax.get(i).i;
									temp_j = WeightBlackTile.blackLengthMax.get(i).j;
									temp_type = WeightBlackTile.blackLengthMax.get(i).type;

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = temp_type;
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										if (gapDistance > getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
												+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
											gapDistance = getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
											fix_i = temp_i;
											fix_j = temp_j;
											fix_type = temp_type;
										} else {
											continue;
										}
									}
									tempTileRules.reset();
								}

							}

						}

					} else {
						temp_distance = 100;
						tempTileRules.reset();
						for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {

							temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
							temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
							temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

							tempTileRules.reset();

							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType1[temp_i][temp_j];
								}

							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > white.lengthWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = white.lengthWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType3[temp_i][temp_j];
								}
							} else {
								continue;
							}

						}
					}

				} else if (blackLengthDangerWeight <= blackCircleDangerWeight) {
					temp_distance = 0;

					for (int i = 0; i < WeightWhiteTile.whiteCircleMax.size(); i++) {

						temp_i = WeightWhiteTile.whiteCircleMax.get(i).i;
						temp_j = WeightWhiteTile.whiteCircleMax.get(i).j;
						temp_type = WeightWhiteTile.whiteCircleMax.get(i).type;

						tempTileRules.reset();
						if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
								1)[0]) {
							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
							white.checkTempEnabledTile();
							tempTileRules.reset();
							if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
								continue;
							} else {
								temp_distance = white.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
										1)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType1[temp_i][temp_j];
							}
						} else {
							continue;
						}
						tempTileRules.reset();
						if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
								2)[0]) {
							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
							white.checkTempEnabledTile();
							tempTileRules.reset();
							if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
								continue;
							} else {
								temp_distance = white.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
										2)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType2[temp_i][temp_j];
							}
						} else {
							continue;
						}
						tempTileRules.reset();
						if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
								3)[0]) {
							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
							white.checkTempEnabledTile();
							tempTileRules.reset();
							if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
								continue;
							} else {
								temp_distance = white.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
										3)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType3[temp_i][temp_j];
							}
						} else {
							continue;
						}

					}
				}
			}
		}

		else if (blackLengthWinWeight <= blackCircleWinWeight)

		{

			if (blackCircleWinWeight == 110) {

				fix_i = WeightBlackTile.blackCircleMax.get(0).i;
				fix_j = WeightBlackTile.blackCircleMax.get(0).j;
				fix_type = WeightBlackTile.blackCircleMax.get(0).type;

			} else {
				if ((blackCircleWinWeight > blackLengthDangerWeight)
						&& (blackCircleWinWeight > blackCircleDangerWeight)) {
					int gapDistance = 20;
					for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {
						temp_i = WeightBlackTile.blackLengthMax.get(i).i;
						temp_j = WeightBlackTile.blackLengthMax.get(i).j;
						temp_type = WeightBlackTile.blackLengthMax.get(i).type;

						tempTileRules.reset();
						Buttons.tempType[temp_i][temp_j] = temp_type;
						white.checkTempEnabledTile();

						tempTileRules.reset();
						if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
							continue;
						} else {

							if (gapDistance > getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
									+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
								gapDistance = getGap(white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
										+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = temp_type;
							} else {
								continue;
							}
						}
						tempTileRules.reset();
					}
				}

				else {

					if (blackLengthDangerWeight > blackCircleDangerWeight) {

						if (blackLengthDangerWeight >= 60) {
							temp_distance = 100;
							tempTileRules.reset();
							int temp_fix_i = 0;
							int temp_fix_j = 0;
							for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {

								temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
								temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
								temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType1[temp_i][temp_j], 1)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {

										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType1[temp_i][temp_j], 1)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType1[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType2[temp_i][temp_j], 2)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType2[temp_i][temp_j], 2)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType2[temp_i][temp_j];
									}

								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType3[temp_i][temp_j], 3)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType3[temp_i][temp_j], 3)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType3[temp_i][temp_j];
									}
								} else {
									continue;
								}

							}

							if (temp_distance < WeightWhiteTile.whiteLengthMax.get(0).distance - 2) {
								fix_i = temp_fix_i;
								fix_j = temp_fix_j;
								fix_type = temp_type;

							} else {

								if (blackCircleWinWeight >= blackLengthWinWeight) {

									int gapDistance = 20;
									for (int i = 0; i < WeightBlackTile.blackCircleMax.size(); i++) {
										temp_i = WeightBlackTile.blackCircleMax.get(i).i;
										temp_j = WeightBlackTile.blackCircleMax.get(i).j;
										temp_type = WeightBlackTile.blackCircleMax.get(i).type;

										tempTileRules.reset();
										Buttons.tempType[temp_i][temp_j] = temp_type;
										white.checkTempEnabledTile();
										tempTileRules.reset();
										if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
											continue;
										} else {
											if (gapDistance > getGap(
													white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
												gapDistance = getGap(
														white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
														+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
												fix_i = temp_i;
												fix_j = temp_j;
												fix_type = temp_type;
											} else {
												continue;
											}
										}
										tempTileRules.reset();

									}

								} else if (blackLengthWinWeight > blackCircleWinWeight) {

									int gapDistance = 20;
									for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {
										temp_i = WeightBlackTile.blackLengthMax.get(i).i;
										temp_j = WeightBlackTile.blackLengthMax.get(i).j;
										temp_type = WeightBlackTile.blackLengthMax.get(i).type;

										tempTileRules.reset();
										Buttons.tempType[temp_i][temp_j] = temp_type;
										white.checkTempEnabledTile();

										tempTileRules.reset();
										if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
											continue;
										} else {
											if (gapDistance > getGap(
													white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
												gapDistance = getGap(
														white.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
														+ getGap(white.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
												fix_i = temp_i;
												fix_j = temp_j;
												fix_type = temp_type;
											} else {
												continue;
											}
										}
										tempTileRules.reset();
									}

								}

							}

						} else {
							temp_distance = 100;
							tempTileRules.reset();
							for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {

								temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
								temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;

								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType1[temp_i][temp_j], 1)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType1[temp_i][temp_j], 1)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType1[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType2[temp_i][temp_j], 2)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
									} else {
										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType2[temp_i][temp_j], 2)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType2[temp_i][temp_j];
									}

								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > white.lengthWeight(temp_i, temp_j,
										Buttons.tempType3[temp_i][temp_j], 3)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
									white.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightWhiteTile.tempWhiteCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = white.lengthWeight(temp_i, temp_j,
												Buttons.tempType3[temp_i][temp_j], 3)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType3[temp_i][temp_j];
									}
								} else {
									continue;
								}

							}
						}

					} else if (blackLengthDangerWeight <= blackCircleDangerWeight) {
						temp_distance = 0;

						for (int i = 0; i < WeightWhiteTile.whiteCircleMax.size(); i++) {

							temp_i = WeightWhiteTile.whiteCircleMax.get(i).i;
							temp_j = WeightWhiteTile.whiteCircleMax.get(i).j;
							tempTileRules.reset();
							if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
									continue;
								} else {
									temp_distance = white.circleWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType1[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
								} else {
									temp_distance = white.circleWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}

							tempTileRules.reset();
							if (temp_distance <= white.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								white.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightWhiteTile.tempWhiteLengthMax.get(0).distance > 9) {
								} else {
									temp_distance = white.circleWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType3[temp_i][temp_j];
								}
							} else {
								continue;
							}

						}

					}
				}
			}

		}
		WeightBlackTile.blackCircleMax.clear();
		WeightBlackTile.blackLengthMax.clear();
		WeightWhiteTile.whiteCircleMax.clear();
		WeightWhiteTile.whiteLengthMax.clear();

		System.out.println("fix_i :" + fix_i);
		System.out.println("fix_j :" + fix_j);
		System.out.println("fix_type :" + fix_type);

	}

	public void whiteTileAI() {

		tempTileRules.reset();
		black.checkEnabledTile();
		white.checkEnabledTile();

		whiteWeightCalculator();

		if (whiteLengthWinWeight > whiteCircleWinWeight) {

			if ((whiteLengthWinWeight > whiteLengthDangerWeight) && (whiteLengthWinWeight > whiteCircleDangerWeight)) {
				int gapDistance = 20;
				for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {
					temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
					temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
					temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

					tempTileRules.reset();
					Buttons.tempType[temp_i][temp_j] = temp_type;
					black.checkTempEnabledTile();
					tempTileRules.reset();
					if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
						continue;
					} else {
						if (gapDistance > getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
								+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
							gapDistance = getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
									+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
							fix_i = temp_i;
							fix_j = temp_j;
							fix_type = temp_type;
						} else {
							continue;
						}
					}
					tempTileRules.reset();

				}

			} else {
				if (whiteLengthDangerWeight > whiteCircleDangerWeight) {

					if (whiteLengthDangerWeight >= 60) {
						temp_distance = 100;
						tempTileRules.reset();
						int temp_fix_i = 0;
						int temp_fix_j = 0;

						for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {

							temp_i = WeightBlackTile.blackLengthMax.get(i).i;
							temp_j = WeightBlackTile.blackLengthMax.get(i).j;
							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType1[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									temp_fix_i = temp_i;
									temp_fix_j = temp_j;
									temp_type = Buttons.tempType3[temp_i][temp_j];
								}

							} else {
								continue;
							}
							tempTileRules.reset();

						}

						if (temp_distance < WeightBlackTile.blackLengthMax.get(0).distance - 2) {
							fix_i = temp_fix_i;
							fix_j = temp_fix_j;
							fix_type = temp_type;

						} else {

							if (whiteCircleWinWeight >= whiteLengthWinWeight) {

								int gapDistance = 20;
								for (int i = 0; i < WeightWhiteTile.whiteCircleMax.size(); i++) {
									temp_i = WeightWhiteTile.whiteCircleMax.get(i).i;
									temp_j = WeightWhiteTile.whiteCircleMax.get(i).j;
									temp_type = WeightWhiteTile.whiteCircleMax.get(i).type;

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = temp_type;
									black.checkTempEnabledTile();
									tempTileRules.reset();

									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										tempTileRules.reset();
										if (gapDistance > getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
												+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
											gapDistance = getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
											fix_i = temp_i;
											fix_j = temp_j;
											fix_type = temp_type;
										} else {
											continue;
										}
									}
									tempTileRules.reset();

								}

							} else if (whiteLengthWinWeight > whiteCircleWinWeight) {

								int gapDistance = 20;
								for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {
									temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
									temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
									temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

									tempTileRules.reset();

									Buttons.tempType[temp_i][temp_j] = temp_type;
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										if (gapDistance > getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
												+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
											gapDistance = getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
											fix_i = temp_i;
											fix_j = temp_j;
											fix_type = temp_type;
										} else {
											continue;
										}
									}
									tempTileRules.reset();
								}

							}

						}

					} else {
						temp_distance = 100;
						tempTileRules.reset();
						for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {

							temp_i = WeightBlackTile.blackLengthMax.get(i).i;
							temp_j = WeightBlackTile.blackLengthMax.get(i).j;

							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType1[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {

								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance > black.lengthWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();

								if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.lengthWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType3[temp_i][temp_j];
								}
							} else {
								continue;
							}

						}
					}

				} else if (whiteLengthDangerWeight <= whiteCircleDangerWeight) {
					temp_distance = 0;

					for (int i = 0; i < WeightBlackTile.blackCircleMax.size(); i++) {

						temp_i = WeightBlackTile.blackCircleMax.get(i).i;
						temp_j = WeightBlackTile.blackCircleMax.get(i).j;
						tempTileRules.reset();
						if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
								1)[0]) {
							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
							black.checkTempEnabledTile();
							tempTileRules.reset();

							if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
									&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
								continue;
							} else {
								temp_distance = black.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
										1)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType1[temp_i][temp_j];
							}
						} else {
							continue;
						}
						tempTileRules.reset();
						if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
								2)[0]) {
							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
							black.checkTempEnabledTile();
							tempTileRules.reset();
							if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
									&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
								continue;
							} else {
								temp_distance = black.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
										2)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType2[temp_i][temp_j];
							}
						} else {
							continue;
						}
						tempTileRules.reset();
						if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
								3)[0]) {

							tempTileRules.reset();
							Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
							black.checkTempEnabledTile();
							tempTileRules.reset();

							if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
									&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
								continue;
							} else {
								temp_distance = black.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
										3)[0];
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = Buttons.tempType3[temp_i][temp_j];
							}
						} else {
							continue;
						}

					}
				}
			}
		}

		else if (whiteLengthWinWeight <= whiteCircleWinWeight) {

			if (whiteCircleWinWeight == 110) {

				fix_i = WeightWhiteTile.whiteCircleMax.get(0).i;
				fix_j = WeightWhiteTile.whiteCircleMax.get(0).j;
				fix_type = WeightWhiteTile.whiteCircleMax.get(0).type;

			} else {
				if ((whiteCircleWinWeight > whiteLengthDangerWeight)
						&& (whiteCircleWinWeight > whiteCircleDangerWeight)) {
					int gapDistance = 20;

					for (int i = 0; i < WeightWhiteTile.whiteCircleMax.size(); i++) {
						temp_i = WeightWhiteTile.whiteCircleMax.get(i).i;
						temp_j = WeightWhiteTile.whiteCircleMax.get(i).j;
						temp_type = WeightWhiteTile.whiteCircleMax.get(i).type;

						tempTileRules.reset();
						Buttons.tempType[temp_i][temp_j] = temp_type;
						black.checkTempEnabledTile();

						tempTileRules.reset();

						if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
							continue;
						} else {
							if (gapDistance > getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
									+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
								gapDistance = getGap(black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
										+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
								fix_i = temp_i;
								fix_j = temp_j;
								fix_type = temp_type;
							} else {
								continue;
							}
						}
						tempTileRules.reset();
					}
				}

				else {
					if (whiteLengthDangerWeight > whiteCircleDangerWeight) {

						if (whiteLengthDangerWeight >= 60) {
							temp_distance = 100;
							tempTileRules.reset();
							int temp_fix_i = 0;
							int temp_fix_j = 0;
							for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {

								temp_i = WeightBlackTile.blackLengthMax.get(i).i;
								temp_j = WeightBlackTile.blackLengthMax.get(i).j;
								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType1[temp_i][temp_j], 1)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType1[temp_i][temp_j], 1)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType1[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType2[temp_i][temp_j], 2)[0]) {
									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType2[temp_i][temp_j], 2)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType2[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType3[temp_i][temp_j], 3)[0]) {
									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType3[temp_i][temp_j], 3)[0];
										temp_fix_i = temp_i;
										temp_fix_j = temp_j;
										temp_type = Buttons.tempType3[temp_i][temp_j];
									}
								} else {
									continue;
								}

							}

							if (temp_distance < WeightBlackTile.blackLengthMax.get(0).distance - 2) {
								fix_i = temp_fix_i;
								fix_j = temp_fix_j;
								fix_type = temp_type;

							} else {

								if (whiteCircleWinWeight >= whiteLengthWinWeight) {

									int gapDistance = 20;
									for (int i = 0; i < WeightWhiteTile.whiteCircleMax.size(); i++) {
										temp_i = WeightWhiteTile.whiteCircleMax.get(i).i;
										temp_j = WeightWhiteTile.whiteCircleMax.get(i).j;
										temp_type = WeightWhiteTile.whiteCircleMax.get(i).type;

										tempTileRules.reset();
										Buttons.tempType[temp_i][temp_j] = temp_type;
										black.checkTempEnabledTile();
										tempTileRules.reset();

										if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
											continue;
										} else {
											if (gapDistance > getGap(
													black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
												gapDistance = getGap(
														black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
														+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
												fix_i = temp_i;
												fix_j = temp_j;
												fix_type = temp_type;
											} else {
												continue;
											}
										}
										tempTileRules.reset();

									}

								} else if (whiteLengthWinWeight > whiteCircleWinWeight) {

									int gapDistance = 20;
									for (int i = 0; i < WeightWhiteTile.whiteLengthMax.size(); i++) {
										temp_i = WeightWhiteTile.whiteLengthMax.get(i).i;
										temp_j = WeightWhiteTile.whiteLengthMax.get(i).j;
										temp_type = WeightWhiteTile.whiteLengthMax.get(i).type;

										tempTileRules.reset();
										Buttons.tempType[temp_i][temp_j] = temp_type;
										black.checkTempEnabledTile();
										tempTileRules.reset();

										if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
											continue;
										} else {
											if (gapDistance > getGap(
													black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
													+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0])) {
												gapDistance = getGap(
														black.lengthWeight(temp_i, temp_j, temp_type, 1)[0])
														+ getGap(black.circleWeight(temp_i, temp_j, temp_type, 1)[0]);
												fix_i = temp_i;
												fix_j = temp_j;
												fix_type = temp_type;
											} else {
												continue;
											}
										}
										tempTileRules.reset();
									}

								}

							}

						} else {
							temp_distance = 100;
							tempTileRules.reset();
							for (int i = 0; i < WeightBlackTile.blackLengthMax.size(); i++) {

								temp_i = WeightBlackTile.blackLengthMax.get(i).i;
								temp_j = WeightBlackTile.blackLengthMax.get(i).j;

								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType1[temp_i][temp_j], 1)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType1[temp_i][temp_j], 1)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType1[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType2[temp_i][temp_j], 2)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType2[temp_i][temp_j], 2)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType2[temp_i][temp_j];
									}
								} else {
									continue;
								}
								tempTileRules.reset();
								if (temp_distance > black.lengthWeight(temp_i, temp_j,
										Buttons.tempType3[temp_i][temp_j], 3)[0]) {

									tempTileRules.reset();
									Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
									black.checkTempEnabledTile();
									tempTileRules.reset();
									if (WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
										continue;
									} else {
										temp_distance = black.lengthWeight(temp_i, temp_j,
												Buttons.tempType3[temp_i][temp_j], 3)[0];
										fix_i = temp_i;
										fix_j = temp_j;
										fix_type = Buttons.tempType3[temp_i][temp_j];
									}
								} else {
									continue;
								}

							}
						}

					} else if (whiteLengthDangerWeight <= whiteCircleDangerWeight) {
						temp_distance = 0;

						for (int i = 0; i < WeightBlackTile.blackCircleMax.size(); i++) {

							temp_i = WeightBlackTile.blackCircleMax.get(i).i;
							temp_j = WeightBlackTile.blackCircleMax.get(i).j;
							tempTileRules.reset();
							if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType1[temp_i][temp_j],
									1)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType1[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
										&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.circleWeight(temp_i, temp_j,
											Buttons.tempType1[temp_i][temp_j], 1)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType1[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType2[temp_i][temp_j],
									2)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType2[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
										&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.circleWeight(temp_i, temp_j,
											Buttons.tempType2[temp_i][temp_j], 2)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType2[temp_i][temp_j];
								}
							} else {
								continue;
							}
							tempTileRules.reset();
							if (temp_distance <= black.circleWeight(temp_i, temp_j, Buttons.tempType3[temp_i][temp_j],
									3)[0]) {
								tempTileRules.reset();
								Buttons.tempType[temp_i][temp_j] = Buttons.tempType3[temp_i][temp_j];
								black.checkTempEnabledTile();
								tempTileRules.reset();
								if (WeightBlackTile.tempBlackLengthMax.get(0).distance > 9
										&& WeightBlackTile.tempBlackCircleMax.get(0).distance == 0) {
									continue;
								} else {
									temp_distance = black.circleWeight(temp_i, temp_j,
											Buttons.tempType3[temp_i][temp_j], 3)[0];
									fix_i = temp_i;
									fix_j = temp_j;
									fix_type = Buttons.tempType3[temp_i][temp_j];
								}
							} else {
								continue;
							}

						}

					}
				}
			}
		}

		WeightWhiteTile.whiteCircleMax.clear();
		WeightWhiteTile.whiteLengthMax.clear();
		WeightBlackTile.blackCircleMax.clear();
		WeightBlackTile.blackLengthMax.clear();

		System.out.println("fix_i :" + fix_i);
		System.out.println("fix_j :" + fix_j);
		System.out.println("fix_type :" + fix_type);

	}

	public void autoAI() {

		Buttons.type[fix_i][fix_j] = fix_type;
		Buttons.btnCnt[fix_i][fix_j]++;
		Buttons.fixTile(fix_i, fix_j);

		if (Buttons.user == true) {
			if (fix_type == "NorthWest" || fix_type == "EastSouth") {
				str = "White_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "/" + " )\n";
				textBox.setTextArea(str);
			} else if (fix_type == "SouthWest" || fix_type == "NorthEast") {
				str = "White_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "\\" + " )\n";
				textBox.setTextArea(str);
			} else if (fix_type == "EastWest" || fix_type == "NorthSouth") {
				str = "White_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "+" + " )\n";
				textBox.setTextArea(str);
			}
		} else if (Buttons.user == false) {
			if (fix_type == "NorthWest" || fix_type == "EastSouth") {
				str = "Black_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "/" + " )\n";
				textBox.setTextArea(str);
			} else if (fix_type == "SouthWest" || fix_type == "NorthEast") {
				str = "Black_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "\\" + " )\n";
				textBox.setTextArea(str);
			} else if (fix_type == "EastWest" || fix_type == "NorthSouth") {
				str = "Black_AI_tile: ( " + fix_i + ", " + fix_j + ", " + "+" + " )\n";
				textBox.setTextArea(str);
			}
		}
	}

	public int getGap(int i) {

		if (5 > i) {
			return 5 - i;
		} else {
			return i - 5;
		}
	}

	public void resetAI() {
		fix_i = 64;
		fix_j = 64;
		fix_type = "EastSouth";
	}
}
