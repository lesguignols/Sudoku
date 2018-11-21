package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InscriptionController 
{
	@FXML
    private TextField id;

    @FXML
    private PasswordField password;
    
	@FXML
    private Button inscrire;
	
    @FXML
    private Text messErreur;

    @FXML
    private Button retour;

    @FXML
    private Button quitter;

    @FXML
    void clickOnSInscrire(ActionEvent event) throws SQLException 
    {

		String Id = id.getText();
		String psw = password.getText();
    	if(id.getText().isEmpty() || password.getText().isEmpty())
    	{
    		messErreur.setOpacity(1);
    	}
    	else
    	{
    		try {
    			Class.forName("org.postgresql.Driver");
    			System.out.print("Driver OK.");

    			String url = "jdbc:postgresql://localhost:5432/AlgoEtDev";
    			String user = "postgres";
    			String passwd = "101506";

    			Connection con = DriverManager.getConnection(url, user, passwd);
    			
    			String sql1 = "SELECT COUNT( * ) FROM player WHERE id = ? OR password = ?";
    			PreparedStatement state = con.prepareStatement(sql1);
    			state.setString(1, Id);
    			state.setString(2, psw);
    			ResultSet result = state.executeQuery();
    			result.next();
    			int nb = result.getInt(1);
    			if(nb>0)
    			{
    				messErreur.setOpacity(1);      			
    			} else {
        			String sql = "INSERT INTO player (ID, password) VALUES(?,?)";
        			PreparedStatement statement = con.prepareStatement(sql);
        			statement.setString(1, Id);
        			statement.setString(2, psw);
        			statement.executeUpdate();
    				Stage stage = new Stage();
        			Stage stage1 = new Stage();
        			try
        			{
        				Parent root = FXMLLoader.load(getClass().getResource("../ressources/Connexion.fxml"));
        				stage.setScene(new Scene(root));
        				stage.setTitle("Bienvenue");
        				stage.setResizable(false);
        				stage.show();

        				stage1 = (Stage)inscrire.getScene().getWindow();
        				stage1.close();

        			} catch(IOException e)
        			{
        				System.out.println(e);
        			}
    			}
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    		
    	}
    }

    @FXML
    void clickOnRetour(ActionEvent event) 
    {
    	Stage stage = new Stage();
    	Stage stage1 = new Stage();
    	try
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("../ressources/Connexion.fxml"));
    		stage.setScene(new Scene(root));
			stage.setTitle("Connexion");
			stage.getIcons().add(new Image("file:connexionIcon.jpg"));
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
    void clickOnExit(ActionEvent event) 
    {
    	Stage stage = (Stage)quitter.getScene().getWindow();
    	stage.close();
    }
}
