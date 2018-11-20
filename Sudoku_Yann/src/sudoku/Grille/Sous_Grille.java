package sudoku.Grille;

import java.util.ArrayList;
import java.util.List;

public class Sous_Grille {

	private List<Case> liste_Case;
	private int taille;
	
	protected Sous_Grille() {
		this.liste_Case = new ArrayList<Case>();
		this.taille = 0;
	}
	
	protected Sous_Grille(int taille) {
		this.liste_Case = new ArrayList<Case>();
		this.taille = taille;
	}
	
	public void ajouteCase(Case c) {
		this.liste_Case.add(c);
	}
	
	protected void supprCase(Case c) {
		this.liste_Case.remove(c);
	}
	
	protected List<Case> getliste_Case() {
		return this.liste_Case;
	}
	
	protected int getTaille() {
		return this.taille;
	}
	
	public String afficheSousGrille() {
		String str = "";
		for (Case c: liste_Case) {
			str = str + "\t" + c.afficheCase();
		}
		return str;
	}
}
