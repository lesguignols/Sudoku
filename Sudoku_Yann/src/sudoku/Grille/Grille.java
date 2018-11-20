package sudoku.Grille;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sudoku.Enum.Lettre;
import sudoku.Enum.Nombre;

public class Grille {

	private int taille;
	private String score;
	private Case[][] tab_Case;
	private Sous_Grille[][] tab_Sous_Grille;
	private String type;
	private List<String> listeChoix = new ArrayList<String>();

	public Grille() {
		this.taille = 0;
		this.score = "";
		this.type = "";
		this.tab_Case = new Case[0][0];
		this.tab_Sous_Grille = new Sous_Grille[0][0];
		this.listeChoix = new ArrayList<String>();
	}

	public Grille(int taille, String type) {

		this.taille = taille;
		this.score = "0";
		this.type = type;
		this.tab_Case = new Case[this.taille][this.taille];
		this.tab_Sous_Grille = new Sous_Grille[(int)Math.sqrt(this.taille)][(int)Math.sqrt(this.taille)];

		//Cr�ation des sous-grilles
		for (int y = 0; y < Math.sqrt(this.taille); y++) {	//y => ligne
			for (int x = 0; x < Math.sqrt(this.taille); x++) { //x => colonne
				this.tab_Sous_Grille[y][x] = new Sous_Grille(this.taille);
			}
		}

		//Cr�ation des cases
		for (int y = 0; y < this.taille; y++) { //y => ligne
			for (int x = 0; x < this.taille; x++) { //x => colonne
				int iterateur = 1; //sert � savoir � quelle sous-grille la case appartient
				int SGx = -1; //colonne de la sous-grille dans la grille
				int SGy = -1; //ligne de la sous-grille dans la grille

				//permet de connaitre la coordonnee y de la sous-grille dans laquelle se situe la case
				while (iterateur <= Math.sqrt(this.taille)) {
					if ((y+1) / (iterateur * Math.sqrt(this.taille)) <= 1 && SGy == -1) {
						SGy = iterateur-1;
					}
					iterateur++;
				}

				iterateur = 1;
				//permet de conna�tre la coordonn�e x de la sous-grille dans laquelle se situe la case
				while (iterateur <= Math.sqrt(this.taille)) {
					if ((x+1) / (iterateur * Math.sqrt(this.taille)) <= 1  && SGx == -1) {
						SGx = iterateur-1;
					}
					iterateur++;
				}
				this.tab_Case[y][x] = new Case(y,x);
			}
		}

		this.listeChoix = listePossible(1,1);
	}

	private boolean verifCase(Case c) {
		if (c.getInitialise()) {
			return false;
		}
		else {
			return true;
		}
	}

	private boolean verifLigne(int ligne, String valeur) {
		for (int x = 0; x < this.taille; x++) {
			if (this.tab_Case[ligne][x].getValeur().equals(valeur)) {
				return false;
			}
		}
		return true;
	}

	private boolean verifColonne(int colonne, String valeur) {
		for (int y = 0; y < this.taille; y++) {
			if (this.tab_Case[y][colonne].getValeur().equals(valeur)) {
				return false;
			}
		}
		return true;
	}

	private boolean verifSous_Grille(int SGy, int SGx, String valeur) {
		for (Case c: this.tab_Sous_Grille[SGy][SGx].getliste_Case()) {
			if (c.getValeur().equals(valeur)) {
				return false;
			}
		}
		return true;
	}
	
	public int chercheSGy(int y) {
		int SGy = -1;
		int iterateur = 1;

		while (iterateur <= Math.sqrt(this.taille)) {
			if ((y) / (iterateur * Math.sqrt(this.taille)) <= 1 && SGy == -1) {
				SGy = iterateur-1;
			}
			iterateur++;
		}
		
		return SGy;
	}
	
	public int chercheSGx(int x) {
		int SGx = -1;
		int iterateur = 1;

		while (iterateur <= Math.sqrt(this.taille)) {
			if ((x) / (iterateur * Math.sqrt(this.taille)) <= 1 && SGx == -1) {
				SGx = iterateur-1;
			}
			iterateur++;
		}
		
		return SGx;
	}

	public List<String> listePossible(int y, int x) {
		List<String> liste = new ArrayList<String>();

		int SGx = chercheSGx(x);
		int SGy = chercheSGy(y);

		if (this.type.equals("Chiffre")) {
			for (Nombre n: Nombre.values()) {
				if (this.verifCase(this.tab_Case[y-1][x-1]) 
						&& this.verifLigne(y-1, n.getValeur()) 
						&& this.verifColonne(x-1, n.getValeur()) 
						&& this.verifSous_Grille(SGy,SGx, n.getValeur())
						&& n.ordinal() < this.taille) {
					liste.add(n.getValeur());
				}
			}
		}
		else {
			if (this.type.equals("Lettre")) {
				for (Lettre l: Lettre.values()) {
					if (this.verifCase(this.tab_Case[y-1][x-1]) 
							&& this.verifLigne(y-1, l.getValeur()) 
							&& this.verifColonne(x-1, l.getValeur()) 
							&& this.verifSous_Grille(SGy,SGx, l.getValeur())
							&& l.ordinal() < this.taille) {
						liste.add(l.getValeur());
					}
				}
			}

		}

		return liste;
	}

	public boolean verifValCase(int y, int x, String val) {
		if (!this.tab_Case[y][x].getValeur().equals(val)) {
			return false;
		}
		for (int _y = 0; _y < this.getTaille(); _y++) {
			if (this.getTab_Case()[_y][x].getValeur().equals(val) && _y != y) {
				return false;
			}
		}
		for (int _x = 0; _x < this.getTaille(); _x++) {
			if (this.getTab_Case()[y][_x].getValeur().equals(val) && _x != x) {
				return false;
			}
		}
		return true;
	}
	
	public void initRevele(int nbRevele) {
		int revele = 0;

		while (revele < nbRevele) {
			Random ran = new Random();
			int x = ran.nextInt(taille) + 1;
			int y = ran.nextInt(taille) + 1;
			
			while (listePossible(y,x).size() == 0) {
				x = ran.nextInt(taille) + 1;
				y = ran.nextInt(taille) + 1;
			}
			int place = ran.nextInt(listePossible(y,x).size());
			String valeur = listePossible(y,x).get(place);

			int SGx = chercheSGx(x);
			int SGy = chercheSGy(y);
			
			//System.out.println("\tx= " + x + "\ty= " + y + "\tvaleur= " + valeur);
			if (!valeur.equals(null) && !this.tab_Case[y-1][x-1].getInitialise()) {
				revele++;
				this.tab_Case[y-1][x-1].setValeur(valeur);
				this.tab_Case[y-1][x-1].setInitialise(true);
				this.tab_Sous_Grille[SGy][SGx].ajouteCase(this.tab_Case[y-1][x-1]);
				//this.printGrille();
			}
		}
	}
	
	public void revele(int y, int x, String val) {
		int SGx = chercheSGx(x);
		int SGy = chercheSGy(y);
		
		//System.out.println("\tx= " + x + "\ty= " + y + "\tvaleur= " + valeur);
		if (!val.equals(null)  && !this.tab_Case[y-1][x-1].getInitialise()) {
			this.tab_Case[y-1][x-1].setValeur(val);
			this.tab_Case[y-1][x-1].setInitialise(true);
			this.tab_Sous_Grille[SGy][SGx].ajouteCase(this.tab_Case[y-1][x-1]);
			//this.printGrille();
		}
	}

	private String printLine(int ligne) {
		String str = "";
		for (int i = 0; i< this.taille; i++) {
			if (i == 0 || i % Math.sqrt(taille) == 0) {
				if (this.tab_Case[ligne][i].getValeur().equals("")) {
					str = str + "\t||\t";
				}
				else {
					str = str + "\t||\t" + this.tab_Case[ligne][i].getValeur();
				}
			}
			else {
				if (this.tab_Case[ligne][i].getValeur().equals("")) {
					str = str + "\t";
				}
				else {
					str = str + "\t" + this.tab_Case[ligne][i].getValeur();
				}
			}
		}
		return str + "\t||";
	}

	public void printGrille() {
		for (int i = 0; i < this.taille; i++) {
			if (i == 0 || i % Math.sqrt(this.taille) == 0) {
				String str = "\t";
				for (int j = 0; j < Math.sqrt(this.taille); j++) {
					str = str + "||";
					for (int nb = 0; nb <= Math.sqrt(this.taille); nb++) {
						if (nb == Math.sqrt(this.taille)) {
							str = str + "======";
						}
						else {
							str = str + "========";
						}
					}
				}
				System.out.println(str + "||");
			}
			System.out.println(this.printLine(i));
			if (i == this.taille-1) {
				String str = "\t";
				for (int j = 0; j < Math.sqrt(this.taille); j++) {
					str = str + "||";
					for (int nb = 0; nb <= Math.sqrt(this.taille); nb++) {
						if (nb == Math.sqrt(this.taille)) {
							str = str + "======";
						}
						else {
							str = str + "========";
						}
					}
				}
				System.out.println(str + "||");
			}
		}
	}
	
	private void setScore(int score) {
		this.score = Integer.toString(score);
	}
	
	private String getScore() {
		return this.score;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public String getType() {
		return this.type;
	}
	
	public List<String> getListeChoix(){
		return this.listeChoix;
	}
	
	public String afficheListeChoix() {
		String str = "\t";
		for (String s: this.listeChoix) {
			str = str + s + "\t";
		}
		return str;
	}
	
	public void saisie(int y, int x, String valeur) {
		if (listePossible(y,x).contains(valeur)) {
			int SGy = chercheSGy(y);
			int SGx = chercheSGx(x);
			this.tab_Sous_Grille[SGy][SGx].supprCase(this.tab_Case[y-1][x-1]);
			this.tab_Case[y-1][x-1].setValeur(valeur);
			this.tab_Sous_Grille[SGy][SGx].ajouteCase(this.tab_Case[y-1][x-1]);
			System.out.println(this.tab_Sous_Grille[SGy][SGx].afficheSousGrille());
			this.setScore(Integer.parseInt(this.score) + 50);
			System.out.println("La valeur a bien ete saisie: vous avez " + this.getScore() + " points!");
		}
		else {
			this.setScore(Integer.parseInt(this.score) - 25);
			System.out.println("La valeur n'a pas ete saisie: vous avez " + this.getScore() + " points!");
		}
	}
	
	public boolean verifGrille(Sous_Grille[][] sg) {
		for (int y = 0; y < this.taille; y++) {
			if (this.verifLigne(y) == false) {
				return false;
			}
		}
		System.out.println("Mes lignes sont valides!");
		
		for (int x = 0; x <this.getTaille(); x++) {
			if (this.verifCol(x) == false) {
				return false;
			}
		}
		System.out.println("Mes colonnes sont valides!");
		
		for (int y = 0; y < Math.sqrt(this.taille); y++) {	//y => ligne
			for (int x = 0; x < Math.sqrt(this.taille); x++) { //x => colonne
				if (verif_Sous_Grille(this.tab_Sous_Grille[y][x]) == false) {
					return false;
				}
			}
		}
		System.out.println("Mes sous grilles sont valides!");
		
		return true;
	}

	public boolean verifLigne(int y) {
		List<String> valeurLigne = new ArrayList<String>();
		for (int x = 0; x < this.taille; x++) {
			if (valeurLigne.contains(this.tab_Case[y][x].getValeur())) {
				return false;
			}
			else {
				String valeur = this.tab_Case[y][x].getValeur();
				valeurLigne.add(valeur);
			}
		}
		return true;
	}
	
	public boolean verifCol(int x) {
		List<String> valeurCol = new ArrayList<String>();
		for (int y = 0; y < this.taille; y++) {
			if (valeurCol.contains(this.tab_Case[y][x].getValeur())) {
				return false;
			}
			else {
				String valeur = this.tab_Case[y][x].getValeur();
				valeurCol.add(valeur);
			}
		}
		return true;
	}
	 
	public boolean verif_Sous_Grille(Sous_Grille sg) {
		List<String> valeurSG = new ArrayList<String>();
		for (Case c: sg.getliste_Case()) {
			if (valeurSG.contains(c.getValeur())) {
				return false;
			}
			else {
				String valeur = c.getValeur();
				valeurSG.add(valeur);
			}
		}
		return true;
	}
	
	public Case[][] getTab_Case(){
		return this.tab_Case;
	}
	
	public Sous_Grille[][] getTab_Sous_Grille() {
		return this.tab_Sous_Grille;
	}
	
	public boolean grilleEgale (Grille g) {
		if (this.getTaille() != g.getTaille()) {
			return false;
		}
		
		if (!this.getType().equals(g.getType())) {
			return false;
		}
		
		for (int y = 0; y < this.taille; y++) { //y => ligne
			for (int x = 0; x < this.taille; x++) { //x => colonne
				if (!this.tab_Case[y][x].getValeur().equals(g.tab_Case[y][x].getValeur())) {
					return false;
				}
			}
		}
		
		return true;
	}
}
