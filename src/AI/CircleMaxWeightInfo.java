package AI;

public class CircleMaxWeightInfo {

	public int i;
	public int j;
	public int distance;
	public String type;
	public int circleCount;
	public int rd_i = 0;
	public int rd_j = 0;
	public int ld_i = 0;
	public int ld_j = 0;

	public CircleMaxWeightInfo(int i, int j, int distance, String type, int circleCount, int rd_i, int rd_j, int ld_i,
			int ld_j) {

		this.i = i;
		this.j = j;
		this.distance = distance;
		this.type = type;
		this.circleCount = circleCount;
		this.rd_i = rd_i;
		this.rd_j = rd_j;
		this.ld_i = ld_i;
		this.ld_j = ld_j;

	}
}
