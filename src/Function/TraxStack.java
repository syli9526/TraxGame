package Function;

public class TraxStack {


	public int ruleS[][] = new int[128][128];
	public String typeS[][] = new String[128][128];
	public int btncntS[][] = new int[128][128];
	public String tempTypeS[][] = new String[128][128];
	
	public void stack(int[][] r, String[][] t, int[][] b, String[][] tt) {
		for(int i=0;i<128;i++) {
			for(int j=0;j<128;j++) {
				ruleS[i][j] = r[i][j];
				typeS[i][j] = t[i][j];
				btncntS[i][j] = b[i][j];
				tempTypeS[i][j] = tt[i][j];
			}
		}
	}
	
	public int[][] getRule(){
		return ruleS;
	}
	public String[][] getType(){
		return typeS;
	}
	public int[][] getBtncnt(){
		return btncntS;
	}
	public String[][] getTempType() {
		return tempTypeS;
	}
}
