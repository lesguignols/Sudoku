package sudoku.controller;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sudoku.Programme;
import sudoku.Grille.Grille;

public class controllerGrille9x9 {

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
	private TextField case16;

	@FXML
	private TextField case17;

	@FXML
	private TextField case18;

	@FXML
	private TextField case19;

	@FXML
	private TextField case20;

	@FXML
	private TextField case21;

	@FXML
	private TextField case22;

	@FXML
	private TextField case23;

	@FXML
	private TextField case24;

	@FXML
	private TextField case25;

	@FXML
	private TextField case26;

	@FXML
	private TextField case27;

	@FXML
	private TextField case28;

	@FXML
	private TextField case29;

	@FXML
	private TextField case30;

	@FXML
	private TextField case31;

	@FXML
	private TextField case32;

	@FXML
	private TextField case33;

	@FXML
	private TextField case34;

	@FXML
	private TextField case35;

	@FXML
	private TextField case36;

	@FXML
	private TextField case37;

	@FXML
	private TextField case38;

	@FXML
	private TextField case39;

	@FXML
	private TextField case40;

	@FXML
	private TextField case41;

	@FXML
	private TextField case42;

	@FXML
	private TextField case43;

	@FXML
	private TextField case44;

	@FXML
	private TextField case45;

	@FXML
	private TextField case46;

	@FXML
	private TextField case47;

	@FXML
	private TextField case48;

	@FXML
	private TextField case49;

	@FXML
	private TextField case50;

	@FXML
	private TextField case51;

	@FXML
	private TextField case52;

	@FXML
	private TextField case53;

	@FXML
	private TextField case54;

	@FXML
	private TextField case55;

	@FXML
	private TextField case56;

	@FXML
	private TextField case57;

	@FXML
	private TextField case58;

	@FXML
	private TextField case59;

	@FXML
	private TextField case60;

	@FXML
	private TextField case61;

	@FXML
	private TextField case62;

	@FXML
	private TextField case63;

	@FXML
	private TextField case64;

	@FXML
	private TextField case65;

	@FXML
	private TextField case66;

	@FXML
	private TextField case67;

	@FXML
	private TextField case68;

	@FXML
	private TextField case69;

	@FXML
	private TextField case70;

	@FXML
	private TextField case71;

	@FXML
	private TextField case72;

	@FXML
	private TextField case73;

	@FXML
	private TextField case74;

	@FXML
	private TextField case75;

	@FXML
	private TextField case76;

	@FXML
	private TextField case77;

	@FXML
	private TextField case78;

	@FXML
	private TextField case79;

	@FXML
	private TextField case80;

	@FXML
	private TextField score;

	@FXML
	private Button init;

	@FXML
	private Button verifier;

	@FXML
	private Button retour;

	@FXML
	private Button aide;

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
							((TextField) node3).setEditable(false);
							Programme.getGrille().revele(y, x, valeur);
							((TextField) node3).setStyle("-fx-text-fill: white; -fx-background-color: green");
						}
					}
				}
				revele++;
			}
		}
		verifier.setDisable(false);

		//debut = System.currentTimeMillis();
	}

	@FXML
	void clickOnaide(ActionEvent event) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(Programme.class.getResource("ressource/Aide.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("Aide");
			stage.setResizable(false);
			controllerAide ca = new controllerAide();
			ca.setTexteListe();
			stage.show();

		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

	@FXML
	void clickOnReset(ActionEvent event) {
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
				System.out.println("La grille est complete, vous avez gagne!");
			}
			else {
				System.out.println("La grille comporte une ou des erreurs!");
			}
		}
	}

}
