package menu;


import java.util.Optional;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sauvegarde.Sauvegarde_Chargement;
import javafx.scene.control.TextInputDialog;



public class NouvellePartie {

	public static void newGame(Stage stage) {
		Group root = new Group();
		Scene nouv = new Scene(root);
		nouv.setFill(Color.BLACK);
		
		//on demande au joueur de saisir un nom
		TextInputDialog selectNom = new TextInputDialog();  
		selectNom.setTitle("Nouvelle Partie");  
		selectNom.setHeaderText("Joueur");  
		selectNom.setContentText("Nom du joueur");  
		Optional<String> nom = selectNom.showAndWait();  
		nom.ifPresent(guestString -> { 
			 String joueur = nom.get();
		     selectNom.close();
		     System.out.println(nom);
		     System.out.println(joueur);
		     //si le nom existe déjà, le joueur peut en saisir un autre ou charger la partie
		     try {
				if (! Sauvegarde_Chargement.nouvelle_sauvegarde(joueur)){
					Text text = new Text("Nom de joueur déjà pris, voulez vous ");
					text.setFont(new Font(25));
					text.setFill(Color.WHITE);
					text.setX(30.0);
					text.setY(30.0);
					Text t2 = new Text(" • Charger la partie correspondante ?");
					t2.setFont(new Font(25));
					t2.setFill(Color.WHITE);
					t2.setX(35.0);
					t2.setY(70.0);
					//t2.setOnMouseClicked(mouseEvent -> Menu.launch());
					Text t3 = new Text(" • Choisir un autre nom ?");
					t3.setFont(new Font(25));
					t3.setFill(Color.WHITE);
					t3.setX(35.0);
					t3.setY(110.0);
					t3.setOnMouseClicked(mouseEvent -> NouvellePartie.newGame(stage));
					root.getChildren().add(text);
					root.getChildren().add(t2);
					root.getChildren().add(t3);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		
		stage.setScene(nouv);
		//root.getChildren().add(e)

		
	}

}
