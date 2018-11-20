package sudoku.Enum;

public enum Nombre {

	Un("1"),
	Deux("2"),
	Trois("3"),
	Quatre("4"),
	Cinq("5"),
	Six("6"),
	Sept("7"),
	Huit("8"),
	Neuf("9"),
	Dix("10"),
	Onze("11"),
	Douze("12"),
	Treize("13"),
	Quatorze("14"),
	Quinze("15"),
	Seize("16"),
	DixSept("17"),
	DixHuit("18"),
	DixNeuf("19"),
	Vingt("20"),
	VingtEtUn("21"),
	VingtDeux("22"),
	VingtTrois("23"),
	VingtQuatre("24"),
	VingtCinq("25");
	
	private String valeur;
	
	private Nombre(String valeur) {
		this.valeur = valeur;
	}
	
	public String getValeur() {
		return this.valeur;
	}
}
