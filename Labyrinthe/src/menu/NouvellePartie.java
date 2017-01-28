package menu;


import java.util.Optional;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;



public class NouvellePartie {

	public static void newGame(Stage stage) {
		Group root = new Group();
		Scene nouv = new Scene(root);
		nouv.setFill(Color.BLACK);
		
		Text text = new Text("test joueur ok");
		text.setFill(Color.WHITE);
		text.setFont(new Font(30));
		text.setX(30.0);
		text.setY(30.0);
		
		TextInputDialog selectNom = new TextInputDialog();  
		selectNom.setTitle("Nouvelle Partie");  
		selectNom.setHeaderText("Joueur");  
		selectNom.setContentText("Nom du joueur");  
		Optional<String> nom = selectNom.showAndWait();  
		nom.ifPresent(guestString -> { 
		     selectNom.close();
		     String joueur = nom.get();
		     System.out.println(nom);
		     System.out.println(joueur);
		});
		
		root.getChildren().add(text);
		stage.setScene(nouv);

		
	}

}
