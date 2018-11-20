package sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sudoku.Programme;

public class controllerAide {

	@FXML
    private TextArea liste;

    @FXML
    private Button fermer;

    @FXML
    private Text texteListe;

    @FXML
    void clickOnFermer(ActionEvent event) {
    	Stage stage = (Stage) fermer.getScene().getWindow();
		stage.close();
    }
    
    void setTexteListe() {
    	if (Programme.getGrille().getTaille() == 4) {
    		texteListe.setText(texteListe.getText() + "4x4");
    	}
    	if (Programme.getGrille().getTaille() == 9) {
    		texteListe.setText(texteListe.getText() + "9x9");
    	}
    	if (Programme.getGrille().getTaille() == 16) {
    		texteListe.setText(texteListe.getText() + "16x16");
    	}
    }
    
}
