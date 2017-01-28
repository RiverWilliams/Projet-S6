package menu;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Menu extends Application{
	
	public static void main(String[] args) {
        Menu.launch(args);
    }
	
	private int t;
	
	public void start(Stage stage) throws Exception {
		stage.setHeight(600);
		stage.setWidth(800);
		stage.setTitle("Menu");	

		//on définit la scene
		Pane root = new Pane();
		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);
		root.setBackground(new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY , Insets.EMPTY)));
		
		//2eme scene affichée quand on clique sur 'charger'
		Group root2 = new Group();
		Scene scene2 = new Scene(root2);
		scene2.setFill(Color.WHITE);
		Text textback = new Text(200, 200, "retour au menu");
		textback.setFont(new Font(60));
		textback.setOnMouseClicked(mouseEvent -> stage.setScene(scene));
		root2.getChildren().add(textback);
		
		//les 4 options du menu
		Text text1 = new Text(80, 100, "Nouvelle Partie");
	    text1.setFont(new Font(30));
	    text1.setFill(Color.WHITE);	    
		Text text2 = new Text(80, 200, "Charger Partie");
	    text2.setFont(new Font(30));
	    text2.setFill(Color.WHITE);
		Text text3 = new Text(80, 300, "Options");
	    text3.setFont(new Font(30));
	    text3.setFill(Color.WHITE);
		Text text4 = new Text(80, 400, "Comment Jouer ?");
	    text4.setFont(new Font(30));
	    text4.setFill(Color.WHITE);
	    
	    //3eme scene affiché quand on clique sur options
	    Group explications = new Group();
	    Scene commentJouer = new Scene(explications);
	    Text expli = new Text(70, 80, "Avec la souris : "
	    							+ "\n Cliquez sur la case où le personnage doit se déplacer (la case choisie doit être"
	    							+ "\n dans la zone visible directement sur l'écran prinicpal."
	    							+ "\n "
	    							+ "\nAvec le clavier : "
	    							+ "\n Appuyer sur la touche directionnelle (ou zqsd) correspondant à la direction où"
	    							+ "\n le personnage doit aller. Maintenez la touche enfoncée pour qu'il progresse "
	    							+ "\n de plusieurs cases à la fois."
	    							+ "\n "
	    							+ "\nDerrière les portes peuvent se trouver un ennemi, un coffre, ou rien du tout, "
	    							+ "\nserez vous assez téméraire pour les ouvrir ?"
	    							+ "\n "
	    							+ "\nVous pouvez combattre ou esquiver un ennemi, mais si l'esquive n'est pas assez \n"
	    							+ "discète, le monstre peut vous attaquer. ");
	    Text retour = new Text(700,520,"Retour");
	    retour.setFont(new Font(25));
	    expli.setFont(new Font(20));
	    URL imageURL2 = getClass().getResource("retour.jpg");
	    Image imageRetour = new Image(imageURL2.toExternalForm());
	    ImageView iv2 = new ImageView(imageRetour);
	    iv2.setX(676.0);
	    iv2.setY(500.0);
	    explications.getChildren().add(iv2);
	    explications.getChildren().add(expli);
	    explications.getChildren().add(retour);
	    
	    //options
	    int type = 3;
	    Group options = new Group();
	    Scene opt = new Scene(options);
	    Text choixTypeJeu = new Text(50,80,"Selectionnez votre type de jeu :");
	    choixTypeJeu.setFont(new Font(25));
	    Text clavier1 = new Text(60,120,"Touches directionnelles du clavier ");
	    clavier1.setFont(new Font(20));
	    Text clavier2 = new Text(60,260,"Touches ZQSD du clavier ");
	    clavier2.setFont(new Font (20));
	    Text souris = new Text(60,400,"Souris");
	    souris.setFont(new Font(20));
	    URL urlclavier = getClass().getResource("fleches.png");
	    Image clavier = new Image(urlclavier.toExternalForm());
	    ImageView iv3 = new ImageView(clavier);
	    iv3.setX(100.0);
	    iv3.setY(140.0);
	    options.getChildren().add(iv3);
	    URL urlzqsd = getClass().getResource("zqsd.png");
	    Image zqsd = new Image(urlzqsd.toExternalForm());
	    ImageView iv4 = new ImageView(zqsd);
	    iv4.setX(100.0);
	    iv4.setY(280.0);
	    options.getChildren().add(iv4);
	    URL urlsouris = getClass().getResource("souris.png");
	    Image sou = new Image(urlsouris.toExternalForm());
	    ImageView iv5 = new ImageView(sou);
	    iv5.setX(100.0);
	    iv5.setY(420.0);
	    options.getChildren().add(choixTypeJeu);
	    options.getChildren().add(clavier1);
	    options.getChildren().add(clavier2);
	    options.getChildren().add(souris);
	    options.getChildren().add(iv5);	   
	    clavier1.setOnMouseClicked(mouseEvent -> setT(1));
	    clavier2.setOnMouseClicked(mouseEvent -> setT(2));
	    souris.setOnMouseClicked(mouseEvent -> setT(3));
	    iv3.setOnMouseClicked(mouseEvent -> setT(1));
	    iv4.setOnMouseClicked(mouseEvent -> setT(2));
	    iv5.setOnMouseClicked(mouseEvent -> setT(3));
	    System.out.println("type jeu " + type);
	    Text retour2 = new Text(700,520,"Retour");
	    retour2.setFont(new Font(25));
	    URL imageURL22 = getClass().getResource("retour.jpg");
	    Image imageRetour2 = new Image(imageURL22.toExternalForm());
	    ImageView iv6 = new ImageView(imageRetour2);
	    iv6.setX(676.0);
	    iv6.setY(500.0);
	    options.getChildren().add(iv6);
	    options.getChildren().add(retour2);
	    retour2.setOnMouseClicked(mouseEvent -> stage.setScene(scene));
	    iv6.setOnMouseClicked(mouseEvent -> stage.setScene(scene));


	    
	    //interractions avec les choix du menu
	    text1.setOnMouseEntered(mouseEvent -> text1.setFill(Color.GREEN));
	    text1.setOnMouseExited(mouseEvent -> text1.setFill(Color.WHITE));
	    text2.setOnMouseEntered(mouseEvent -> text2.setFill(Color.GREEN));
	    text2.setOnMouseExited(mouseEvent -> text2.setFill(Color.WHITE));
	    text3.setOnMouseEntered(mouseEvent -> text3.setFill(Color.GREEN));
	    text3.setOnMouseExited(mouseEvent -> text3.setFill(Color.WHITE));
	    text4.setOnMouseEntered(mouseEvent -> text4.setFill(Color.GREEN));
	    text4.setOnMouseExited(mouseEvent -> text4.setFill(Color.WHITE));
		text1.setOnMouseClicked(mouseEvent -> NouvellePartie.newGame(stage));
	    text2.setOnMouseClicked(mouseEvent -> stage.setScene(scene2));
	    text3.setOnMouseClicked(mouseEvent -> stage.setScene(opt));
	    text4.setOnMouseClicked(mouseEvent -> stage.setScene(commentJouer));
	    retour.setOnMouseClicked(mouseEvent -> stage.setScene(scene));
	    iv2.setOnMouseClicked(mouseEvent -> stage.setScene(scene));	    
	    
	    //les gifs à droite
	    URL imageURLc = getClass().getResource("chemin.gif"); 
        Image imagec = new Image(imageURLc.toExternalForm());
	    ImageView ivc = new ImageView(imagec);
	    ivc.setX(485.0);
	    ivc.setY(00.0);
	    root.getChildren().add(ivc);
	    URL imageURL = getClass().getResource("juliemarche.gif"); 
        Image image = new Image(imageURL.toExternalForm());
	    ImageView iv = new ImageView(image);
	    iv.setX(500.0);
	    iv.setY(80.0);
	    root.getChildren().add(iv); 
	    URL imageURLp = getClass().getResource("pemarche.gif"); 
        Image imagep = new Image(imageURLp.toExternalForm());
	    ImageView ivp = new ImageView(imagep);
	    ivp.setX(500.0);
	    ivp.setY(200.0);
	    root.getChildren().add(ivp); 
	    URL imageURLf = getClass().getResource("florianmarche.gif"); 
        Image imagef = new Image(imageURLf.toExternalForm());
	    ImageView ivf = new ImageView(imagef);
	    ivf.setX(500.0);
	    ivf.setY(320.0);
	    root.getChildren().add(ivf); 
	    
	    //bouton quitter
	    Button quit = new Button("Quitter");
	    quit.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(2.0) , Insets.EMPTY)));
	    quit.setTranslateX(650);
	    quit.setTranslateY(500);
	    quit.setOnAction(actionEvent -> stage.close());

	    //gestion de l'affichage
	    root.getChildren().add(text1);
	    root.getChildren().add(text2);
	    root.getChildren().add(text3);
	    root.getChildren().add(text4);
	    root.getChildren().add(quit);
		stage.setScene(scene);
		stage.show();
	}
	
	

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
		System.out.println("type " + t);
	}
	
	
}
