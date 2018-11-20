package sudoku.Grille;

public class Case {

	private int cooX; //colonne
	private int cooY; //ligne
	private String valeur;
	private boolean initialise;
	
	protected Case() {
		this.cooX = -1;
		this.cooY = -1;
		this.valeur = "";
		this.initialise = false;
	}
	
	/**
	 * Cr�er la case de coordonn�e [y][x].
	 * @param y
	 * 		La ligne o� se situe la case.
	 * @param x
	 * 		La colonne o� se situe la case.
	 */
	public Case(int y, int x) {
		this.cooX = x;
		this.cooY = y;
		this.valeur = "";
		this.initialise = false;
	}
	
	protected int getcooX() {
		return this.cooX;
	}
	
	protected int getCooY() {
		return this.cooY;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public boolean getInitialise() {
		return this.initialise;
	}
	
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	protected void setInitialise(boolean initialise) {
		this.initialise = initialise;
	}
	
	public String afficheCase() {
		String str = "x: " + getcooX() + ", y: " + getCooY() + ", val" + getValeur() + ", init? " + getInitialise();
		return str;
	}
}
