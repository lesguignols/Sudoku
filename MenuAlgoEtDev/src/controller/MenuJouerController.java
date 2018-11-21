package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import player.Player;

public class MenuJouerController {
    @FXML
    private Label text;
    
	@FXML
    private CheckBox motus;

    @FXML
    private CheckBox pendu;

    @FXML
    private CheckBox motsMeles;

    @FXML
    private CheckBox sudokuLettres;

    @FXML
    private CheckBox sudokuChiffres;
    
    @FXML
    private Button jouer;
    
    @FXML
    private Button classement;
    
    @FXML
    private Button retour;

    @FXML
    private Button quitter; 
    
    @FXML
    void initialize()
    {
    	text.setText(Player.id + ", choisis ton jeu !");
    }
    
    @FXML
    void clickOnMotsMeles(ActionEvent event) {
    	motus.setSelected(false);
    	pendu.setSelected(false);
    	sudokuLettres.setSelected(false);
    	sudokuChiffres.setSelected(false);
    	if(motsMeles.isSelected())
    	{
    		jouer.setDisable(false);
    		classement.setDisable(false);
    	}
    	else 
    	{
    		jouer.setDisable(true);
    		classement.setDisable(true);
    	}
    }

    @FXML
    void clickOnMotus(ActionEvent event) {
    	pendu.setSelected(false);
    	motsMeles.setSelected(false);
    	sudokuLettres.setSelected(false);
    	sudokuChiffres.setSelected(false);
    	if(motus.isSelected())
    	{
    		jouer.setDisable(false);
    		classement.setDisable(false);
    	}
    	else 
    	{
    		jouer.setDisable(true);
    		classement.setDisable(true);
    	}
    }

    @FXML
    void clickOnPendu(ActionEvent event) {
    	motus.setSelected(false);
    	motsMeles.setSelected(false);
    	sudokuLettres.setSelected(false);
    	sudokuChiffres.setSelected(false);
    	if(pendu.isSelected())
    	{
    		jouer.setDisable(false);
    		classement.setDisable(false);
    	}
    	else 
    	{
    		jouer.setDisable(true);
    		classement.setDisable(true);
    	}
    }


    @FXML
    void clickOnSudokuChiffres(ActionEvent event) {
    	motus.setSelected(false);
    	motsMeles.setSelected(false);
    	pendu.setSelected(false);
    	sudokuLettres.setSelected(false);
    	if(sudokuChiffres.isSelected())
    	{
    		jouer.setDisable(false);
    		classement.setDisable(false);
    	}
    	else 
    	{
    		jouer.setDisable(true);
    		classement.setDisable(true);
    	}
    }
    
    @FXML
    void clickOnSudokuLettres(ActionEvent event) {
    	motus.setSelected(false);
    	motsMeles.setSelected(false);
    	pendu.setSelected(false);
    	sudokuChiffres.setSelected(false);
    	if(sudokuLettres.isSelected())
    	{
    		jouer.setDisable(false);
    		classement.setDisable(false);
    	}
    	else 
    	{
    		jouer.setDisable(true);
    		classement.setDisable(true);
    	}
    }
    
    @FXML
    void clickOnJouer(ActionEvent event) {
    	
    }
    
    @FXML
    void clickOnClassement(ActionEvent event) {
    	if(motus.isSelected())
    	{
    		Stage stage = new Stage();
    		Stage stage1 = new Stage();
    		try
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("../ressources/ClassementMotus.fxml"));
    			stage.setScene(new Scene(root));
    			stage.setTitle("Classement MOTUS");
    			stage.getIcons().add(new Image("file:BckClassement.jpg"));
    			stage.setResizable(false);
    			stage.show();
			
    			stage1 = (Stage)classement.getScene().getWindow();
    			stage1.close();
    		
    		} catch(IOException e)
    		{
    			System.out.println(e);
    		}
    	}
    	if(pendu.isSelected())
    	{
    		Stage stage = new Stage();
    		Stage stage1 = new Stage();
    		try
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("../ressources/ClassementPendu.fxml"));
    			stage.setScene(new Scene(root));
    			stage.setTitle("Classement PENDU");
    			stage.getIcons().add(new Image("file:BckClassement.jpg"));
    			stage.setResizable(false);
    			stage.show();
			
    			stage1 = (Stage)classement.getScene().getWindow();
    			stage1.close();
    		
    		} catch(IOException e)
    		{
    			System.out.println(e);
    		}
    	}
    	if(motsMeles.isSelected())
    	{
    		Stage stage = new Stage();
    		Stage stage1 = new Stage();
    		try
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("../ressources/ClassementMotsMeles.fxml"));
    			stage.setScene(new Scene(root));
    			stage.setTitle("Classement MOTS MELES");
    			stage.getIcons().add(new Image("file:BckClassement.jpg"));
    			stage.setResizable(false);
    			stage.show();
			
    			stage1 = (Stage)classement.getScene().getWindow();
    			stage1.close();
    		
    		} catch(IOException e)
    		{
    			System.out.println(e);
    		}
    	}
    	if(sudokuLettres.isSelected())
    	{
    		Stage stage = new Stage();
    		Stage stage1 = new Stage();
    		try
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("../ressources/ClassementSudokuLettres.fxml"));
    			stage.setScene(new Scene(root));
    			stage.setTitle("Classement SUDOKU LETTRES");
    			stage.getIcons().add(new Image("file:BckClassement.jpg"));
    			stage.setResizable(false);
    			stage.show();
			
    			stage1 = (Stage)classement.getScene().getWindow();
    			stage1.close();
    		
    		} catch(IOException e)
    		{
    			System.out.println(e);
    		}
    	}
    	if(sudokuChiffres.isSelected())
    	{
    		Stage stage = new Stage();
    		Stage stage1 = new Stage();
    		try
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("../ressources/ClassementSudokuChiffres.fxml"));
    			stage.setScene(new Scene(root));
    			stage.setTitle("Classement SUDOKU CHIFFRES");
    			stage.getIcons().add(new Image("file:BckClassement.jpg"));
    			stage.setResizable(false);
    			stage.show();
			
    			stage1 = (Stage)classement.getScene().getWindow();
    			stage1.close();
    		
    		} catch(IOException e)
    		{
    			System.out.println(e);
    		}
    	}
    }
    
    @FXML
    void clickOnRetour(ActionEvent event) {
    	Stage stage = new Stage();
    	Stage stage1 = new Stage();
    	try
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("../ressources/MenuIndex.fxml"));
    		stage.setScene(new Scene(root));
			stage.setTitle("Accueil");
			stage.getIcons().add(new Image("file:bienvenue.jpg"));
			stage.setResizable(false);
			stage.show();
			
			stage1 = (Stage)retour.getScene().getWindow();
			stage1.close();
    		
    	} catch(IOException e)
    	{
    		System.out.println(e);
    	}
    }
    @FXML
    void clickOnExit(ActionEvent event) {
    	Stage stage = (Stage)quitter.getScene().getWindow();
    	stage.close();
    }
   

}
