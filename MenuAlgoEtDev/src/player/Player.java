package player;

public class Player 
{
	public static String id;
	public static String password;
	public int scoreGeneral;
	public int scoreMotus;
	public int scorePendu;
	public int scoreMotsMeles;
	public int scoreSudokuLettres;
	public int scoreSudokuChiffres;
	
	public int getScoreGeneral() {
		return scoreGeneral;
	}

	public void setScoreGeneral(int scoreGeneral) {
		this.scoreGeneral = scoreGeneral;
	}

	public int getScoreMotus() {
		return scoreMotus;
	}

	public void setScoreMotus(int scoreMotus) {
		this.scoreMotus = scoreMotus;
	}

	public int getScorePendu() {
		return scorePendu;
	}

	public void setScorePendu(int scorePendu) {
		this.scorePendu = scorePendu;
	}

	public int getScoreMotsMeles() {
		return scoreMotsMeles;
	}

	public void setScoreMotsMeles(int scoreMotsMeles) {
		this.scoreMotsMeles = scoreMotsMeles;
	}

	public int getScoreSudokuLettres() {
		return scoreSudokuLettres;
	}

	public void setScoreSudokuLettres(int scoreSudokuLettres) {
		this.scoreSudokuLettres = scoreSudokuLettres;
	}

	public int getScoreSudokuChiffres() {
		return scoreSudokuChiffres;
	}

	public void setScoreSudokuChiffres(int scoreSudokuChiffres) {
		this.scoreSudokuChiffres = scoreSudokuChiffres;
	}

	public Player()	{}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		Player.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		Player.password = password;
	}
	
	public boolean ControlAccess(String _id, String _password)
	{
		if(equals(_id, id) && equals(_password, password))
			return true;
		return false;
	}
	
	public boolean equals(String a, String b)
	{
		boolean result = false;
		if(a.length() < b.length() || a.length() > b.length())
			result = false;
		else
		{
			for(int i=0; i<a.length(); i++)
			{
				if(a.charAt(i) == b.charAt(i))
					result = true;
				else 
					return false;
			}
		}
		return result;
	}
	
}
