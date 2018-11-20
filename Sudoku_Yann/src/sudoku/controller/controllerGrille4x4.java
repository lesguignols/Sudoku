package sudoku.controller;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sudoku.Programme;
import sudoku.Grille.Grille;

public class controllerGrille4x4 {
	
	@FXML
	private static BorderPane borderpane;

	@FXML
	private TextField case0;

	@FXML
	private TextField case1;

	@FXML
	private TextField case2;

	@FXML
	private TextField case3;

	@FXML
	private TextField case4;

	@FXML
	private TextField case5;

	@FXML
	private TextField case6;

	@FXML
	private TextField case7;

	@FXML
	private TextField case8;

	@FXML
	private TextField case9;

	@FXML
	private TextField case10;

	@FXML
	private TextField case11;

	@FXML
	private TextField case12;

	@FXML
	private TextField case13;

	@FXML
	private TextField case14;

	@FXML
	private TextField case15;

	@FXML
	private TextField score;

	@FXML
	private TextArea listePossible;

	@FXML
	private Button init;

	@FXML
	private Button retour;

	@FXML
	private Button verifier;

	@FXML
	private Button Reset;
	
	private long debut, tempsJeu, nbHeure, nbMin, nbSec;
	
	public static void setBorderpane(BorderPane _borderpane) {
		borderpane = _borderpane;
	}

	private Pane getPane() {
		AnchorPane anchorpane = null;
		for (Node node : borderpane.getChildren()) {
			if (node instanceof AnchorPane) {
				anchorpane = ((AnchorPane) node);
			}
		}

		// get Pane from AnchorPane
		Pane p = null;
		for (Node node2 : anchorpane.getChildren()) {
			if (node2 instanceof Pane) {
				p = ((Pane) node2);
			}

		}
		return p;
	}

	@FXML
	void clickOnQuitter(ActionEvent event) {
		Stage stage = (Stage) retour.getScene().getWindow();
		stage.close();
	}

	@FXML
	void clickOnInit(ActionEvent event) {
		if (!Programme.getGrille().grilleEgale(new Grille(Programme.getGrille().getTaille(), Programme.getGrille().getType()))) {
			Pane p = getPane();

			for (Node node3 : p.getChildren()) {
				if (node3 instanceof TextField) {
					// clear
					if (!node3.getId().equals("score")) {
						((TextField) node3).setText("");
						((TextField) node3).setEditable(true);
						((TextField) node3).setStyle(null);
					}
				}
				if (node3 instanceof TextArea) {
					((TextArea) node3).setText("Liste des valeurs possibles:");
				}
			}

			Programme.setGrille(new Grille(Programme.getGrille().getTaille(),Programme.getGrille().getType()));
			verifier.setDisable(true);
		}
		
		int revele = 0;
		Pane p = getPane();

		for (Node node3 : p.getChildren()) {
			if (node3 instanceof TextArea) {
				if (node3.getId().equals("listePossible")) {
					((TextArea) node3).setText("Liste des valeurs possibles:" + "\n" + Programme.getGrille().afficheListeChoix());
				}
			}
		}

		while (revele < 4) {
			Random ran = new Random();
			int x = ran.nextInt(Programme.getGrille().getTaille()) + 1;
			int y = ran.nextInt(Programme.getGrille().getTaille()) + 1;

			while (Programme.getGrille().listePossible(y,x).size() == 0) {
				x = ran.nextInt(Programme.getGrille().getTaille()) + 1;
				y = ran.nextInt(Programme.getGrille().getTaille()) + 1;
			}
			int place = ran.nextInt(Programme.getGrille().listePossible(y,x).size());
			String valeur = Programme.getGrille().listePossible(y,x).get(place);

			if (!valeur.equals(null)  && !Programme.getGrille().getTab_Case()[y-1][x-1].getInitialise()) {
				int numCase = (y-1)*Programme.getGrille().getTaille() + x-1;
				String casenb = "case" + Integer.toString(numCase);	
				for (Node node3 : p.getChildren()) {
					if (node3 instanceof TextField) {
						// clear
						if (node3.getId().equals(casenb)) {
							((TextField) node3).setText(valeur);
							Programme.getGrille().revele(y, x, valeur);
							((TextField) node3).setStyle("-fx-text-fill: white; -fx-background-color: green");
						}
					}
				}
				revele++;
			}
		}
		for (Node node3 : p.getChildren()) {
			if (node3 instanceof TextField) {
				// clear
				if (!node3.getId().equals("score") && ((TextField) node3).getText().equals("")) {
					((TextField) node3).setEditable(true);
				}
			}
		}
		
		verifier.setDisable(false);
		
		debut = System.currentTimeMillis();
	}

	@FXML
	void clickOnVerifier(ActionEvent event) {
		Pane p = getPane();

		for (Node node: p.getChildren()) {
			if (node instanceof TextField) {
				if (!node.getId().equals("score")) {
					if (!((TextField) node).getText().equals("")) {
						String nom = node.getId();
						nom = nom.replaceAll("case", "");
						int num = Integer.parseInt(nom);
						int x = num%Programme.getGrille().getTaille();
						int y = (num - x) / Programme.getGrille().getTaille();
						String val = ((TextField) node).getText();
						Programme.getGrille().saisie(y+1, x+1, val.toUpperCase());
						if (!val.equals(val.toUpperCase())) {
							((TextField) node).setText(val.toUpperCase());
						}
						//Programme.getGrille().getTab_Case()[y][x].setValeur(((TextField) node).getText());
						if (!Programme.getGrille().getTab_Case()[y][x].getValeur().equals(((TextField) node).getText())) {
							((TextField) node).setStyle("-fx-text-fill: white; -fx-background-color: red");
						}
					}
					else {
						((TextField) node).setStyle(null);
					}
				}
				else {
					
				}
			}
		}

		Programme.getGrille().printGrille();

		int nbTextField = 0;
		int nbTextFieldInit = 0;
		for (Node node: p.getChildren()) {
			if (node instanceof TextField) {
				if (!node.getId().equals("score")) {
					nbTextField++;
					if (!((TextField) node).getText().equals("")) {
						nbTextFieldInit++;
						String nom = node.getId();
						nom = nom.replaceAll("case", "");
						int num = Integer.parseInt(nom);
						int x = num%Programme.getGrille().getTaille();
						int y = (num - x) / Programme.getGrille().getTaille();

						int SGx = Programme.getGrille().chercheSGx(x+1);
						int SGy = Programme.getGrille().chercheSGy(y+1);
						System.out.println("case: " + num + 
								" ,x: " + x + 
								" ,y: " + y + 
								" ,val: " + ((TextField) node).getText() + 
								" ,SGx: " + SGx +
								" ,SGy: " + SGy);

						if (Programme.getGrille().verifValCase(y, x, ((TextField) node).getText())) {
							((TextField) node).setStyle("-fx-text-fill: white; -fx-background-color: green");
						}
						else {
							((TextField) node).setStyle("-fx-text-fill: white; -fx-background-color: red");
						}
					}
				}
			}
		}
		if (nbTextField == nbTextFieldInit) {
			if (Programme.getGrille().verifGrille(Programme.getGrille().getTab_Sous_Grille())) {
				tempsJeu = (System.currentTimeMillis() - debut) / 1000;
				nbHeure = (tempsJeu - (tempsJeu % 3600))/ 3600;
				nbMin = (((tempsJeu - nbHeure*3600) - (tempsJeu % 60)) / 60);
				nbSec = (tempsJeu - nbHeure*3600 - nbMin*60);
				System.out.println("Vous avez joue " + nbHeure + " heure(s), " + nbMin + " minute(s) et " + nbSec + " seconde(s).");
				System.out.println("La grille est complete, vous avez gagne!");
			}
			else {
				System.out.println("La grille comporte une ou des erreurs!");
			}
		}
	}


}
