package TPPROBSOLV;

public class Pieceor {

	private double poids;
	private int num;

	public Pieceor(double poids, int num) {
		super();
		this.poids = poids;
		this.num = num;
	}

	public Pieceor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "" + getNum() + "**";
	}

}