package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import player.Player;

public class MenuScoreController {
	@FXML
	private Label bddclass;
	@FXML
	private Label testScore;
	 
	@FXML
	private TableView<String> tableau;

	@FXML
	private TableColumn<String, String> pseudo;

	@FXML
	private TableColumn<String, String> scoreG; 
	
	@FXML
    private Button retour;

    @FXML
    private Button quitter;
    
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
    void initialize() 
    {
    	try {
    		Class.forName("org.postgresql.Driver");
    		System.out.print("Driver OK.");

    		String url = "jdbc:postgresql://localhost:5432/AlgoEtDev";
    		String user = "postgres";
    		String passwd = "101506";

    		Connection con = DriverManager.getConnection(url, user, passwd);
    		

    		/*
    		String sql3 = "UPDATE player SET scorependu = 0";
    		PreparedStatement sta = con.prepareStatement(sql3);
    		sta.executeUpdate();
    		*/
    		
    		String nbPersonnes = "SELECT COUNT(*) FROM player";
			PreparedStatement state = con.prepareStatement(nbPersonnes);
			ResultSet resultat = state.executeQuery();
			resultat.next();
			int nb = resultat.getInt(1);
    		
    		String sql4 = "UPDATE player SET scoregeneral = scorependu + scoremotus + scoremotsmeles + scoresudokulettres + scoresudokuchiffres";
    		PreparedStatement staa = con.prepareStatement(sql4);
    		staa.executeUpdate();    		
    		
    		String sql = "SELECT scoregeneral FROM player WHERE  id = player.id";
    		PreparedStatement statement = con.prepareStatement(sql);
    		ResultSet result = statement.executeQuery();
    		result.next();
    		int score = result.getInt(1);
    		testScore.setText(Player.id + " votre score est de : " + score +".");
    		
    		String sql1 = "SELECT id, scoregeneral FROM player order by scoregeneral ASC";
    		PreparedStatement statem = con.prepareStatement(sql1);
    		ResultSet resul = statem.executeQuery();
    		resul.next();
    		String max = resul.getString(1);
    		String max2 = resul.getString(2);
    		for(int i=1; i<=nb; i++)
    			bddclass.setText(i+ ". "+ max + max2);

    		/*
    		pseudo.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
    		tableau.getColumns().add(pseudo);
    		ObservableList<String> items = FXCollections.observableArrayList(max);
    		tableau.setItems(items);
    		*/
    		
    		statement.close();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void clickOnExit(ActionEvent event) {
    	Stage stage = (Stage)quitter.getScene().getWindow();
    	stage.close();
    }

}
