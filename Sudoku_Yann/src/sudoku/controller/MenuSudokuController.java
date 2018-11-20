package sudoku.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sudoku.Programme;
import sudoku.Grille.Grille;

public class MenuSudokuController {
	
	@FXML
	private BorderPane borderpan;
	
	@FXML
    private Button retour;

    @FXML
    private CheckBox nxn;

    @FXML
    private ImageView sxsL;

    @FXML
    private CheckBox qxq;

    @FXML
    private CheckBox sxs;

    @FXML
    private CheckBox chiffre;

    @FXML
    private ImageView qxqN;

    @FXML
    private ImageView sxsN;

    @FXML
    private ImageView qxqL;

    @FXML
    private Button commencer;

    @FXML
    private ImageView nxnN;

    @FXML
    private ImageView nxnL;

    @FXML
    private CheckBox lettre;

    @FXML
    void clickOnRetour(ActionEvent event) {
    	Stage stage = (Stage) retour.getScene().getWindow();
    	stage.close();
    }
    
    @FXML
    void clickOnCommencer(ActionEvent event) throws IOException {
    	AnchorPane anchorpane = null;
		FXMLLoader loader = new FXMLLoader();
		
		int taille = 0;
		if (qxq.isSelected()) {
			taille = 4;
			loader.setLocation(Programme.class.getResource("ressource/grille4x4.fxml"));
		}
		else if (nxn.isSelected()) {
			taille = 9;
			loader.setLocation(Programme.class.getResource("ressource/grille9x9.fxml"));
		}
		else if (sxs.isSelected()) {
			taille = 16;
		}
		
		String type = "";
		
		if (chiffre.isSelected()) {
			type = "Chiffre";
		}
		else if (lettre.isSelected()) {
			type = "Lettre";
		}
		
		Programme.setGrille(new Grille(taille,type));
		anchorpane = (AnchorPane) loader.load();
		borderpan = Programme.getRootLayout();
		borderpan.setCenter(anchorpane);
		borderpan.setBorder(null);
		borderpan.setBottom(null);
		borderpan.setTop(null);
		Programme.getPrimaryStage().setTitle("Sudoku " + Programme.getGrille().getTaille() + "x" + Programme.getGrille().getTaille());
		if (taille == 4) {
			controllerGrille4x4.setBorderpane(borderpan);
		}
		else if (taille == 9) {
			controllerGrille9x9.setBorderpane(borderpan);
		}
		/*Programme.getPrimaryStage().setHeight(717);
		Programme.getPrimaryStage().setWidth(768);*/
    }

    @FXML
    void choixQxQ(ActionEvent event) {
    	if (!sxs.isSelected() && !nxn.isSelected() && qxq.isSelected()) {
			commencer.setDisable(false);
		}
		else {
			if (!qxq.isSelected()) {
				commencer.setDisable(true);
			}
		}
		sxs.setSelected(false);
		nxn.setSelected(false);
    }

    @FXML
    void choixNxN(ActionEvent event) {
    	if (!sxs.isSelected() && nxn.isSelected() && !qxq.isSelected()) {
			commencer.setDisable(false);
		}
		else {
			if (!nxn.isSelected()) {
				commencer.setDisable(true);
			}
		}
		qxq.setSelected(false);
		sxs.setSelected(false);
    }

    @FXML
    void choixSxS(ActionEvent event) {
    	if (sxs.isSelected() && !nxn.isSelected() && !qxq.isSelected()) {
			commencer.setDisable(false);
		}
		else {
			if (!sxs.isSelected()) {
				commencer.setDisable(true);
			}
		}
		qxq.setSelected(false);
		nxn.setSelected(false);
    }

    @FXML
    void choixChiffre(ActionEvent event) {
    	lettre.setSelected(false);
		if (qxqN.isVisible() &&
				nxnN.isVisible() &&
				sxsN.isVisible()) {
			qxq.setVisible(false);
			qxq.setSelected(false);
			qxqN.setVisible(false);
			nxn.setVisible(false);
			nxn.setSelected(false);
			nxnN.setVisible(false);
			//sxs.setVisible(false);
			//sxs.setSelected(false);
			sxsN.setVisible(false);
			commencer.setDisable(true);
		}
		else {
			qxqL.setVisible(false);
			nxnL.setVisible(false);
			sxsL.setVisible(false);
			qxq.setVisible(true);
			qxqN.setVisible(true);
			nxn.setVisible(true);
			nxnN.setVisible(true);
			//sxs.setVisible(true);
			sxsN.setVisible(true);
		}
    }

    @FXML
    void choixLettre(ActionEvent event) {
    	chiffre.setSelected(false);
		if (qxqL.isVisible() &&
				nxnL.isVisible() &&
				sxsL.isVisible()) {
			qxq.setVisible(false);
			qxq.setSelected(false);
			qxqL.setVisible(false);
			nxn.setVisible(false);
			nxn.setSelected(false);
			nxnL.setVisible(false);
			//sxs.setVisible(false);
			//sxs.setSelected(false);
			sxsL.setVisible(false);
			commencer.setDisable(true);
		}
		else {
			qxqN.setVisible(false);
			nxnN.setVisible(false);
			sxsN.setVisible(false);
			qxq.setVisible(true);
			qxqL.setVisible(true);
			nxn.setVisible(true);
			nxnL.setVisible(true);
			//sxs.setVisible(true);
			sxsL.setVisible(true);
		}
    }
}
