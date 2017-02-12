package affichage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
import niveau.Map;


public class Heros extends Parent {
	URL imageURLd = getClass().getResource("jdmarche.gif");
    Image imaged = new Image(imageURLd.toExternalForm());
    ImageView ivd = new ImageView(imaged);
    URL imageURLg = getClass().getResource("jgmarche.gif");
    Image imageg = new Image(imageURLg.toExternalForm());
    ImageView ivg = new ImageView(imageg);
    URL imageURLa = getClass().getResource("jamarche.gif");
    Image imagea = new Image(imageURLa.toExternalForm());
    ImageView iva = new ImageView(imagea);
    URL imageURL = getClass().getResource("jmarche.gif");
    Image image = new Image(imageURL.toExternalForm());
    ImageView iv = new ImageView(image);
	//Rectangle rec;
	double positionX=45;
	double positionY=365;
	public Heros(){
		this.setTranslateX(positionX);
		this.setTranslateY(positionY);
		//rec=new Rectangle();
		//rec.setWidth(5);
		//rec.setHeight(5);
		//rec.setFill(Color.RED);
		//this.getChildren().add(rec);
		this.getChildren().add(ivd);
		this.setOnMousePressed(new EventHandler<MouseEvent>(){
	        public void handle(MouseEvent me){
	        	deplacerSouris();
	        }
	    });
		this.setOnKeyPressed(new EventHandler<KeyEvent>(){
        	public void handle(KeyEvent ke){
        		deplacer(ke.getText().toUpperCase());
        	}
        });
	}
	public void deplacer(String direction){
		int [][] tab = null;
		try {
			tab = Map.importation(new File("C:/Users/Julie/Documents/GitHub/Projet-S6/Labyrinthe/src/niveau/niveau1.txt").getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(direction){
		case "Z":
			if (tab[(int) ((this.positionY-10)/32)][(int) (this.positionX/32)] != 1){
			this.positionY=this.positionY-10;
			this.setTranslateY(this.positionY);
			this.getChildren().remove(ivd);
			this.getChildren().remove(ivg);
			this.getChildren().remove(iv);
			this.getChildren().remove(iva);
			this.getChildren().add(iva);
			}
			break;
		case "Q":
			if(tab[(int) (this.positionY/32)][(int) ((this.positionX-10)/32)] != 1){
			this.positionX=this.positionX-10;
			this.setTranslateX(this.positionX);
			this.getChildren().remove(ivd);
			this.getChildren().remove(iva);
			this.getChildren().remove(iv);
			this.getChildren().remove(ivg);
			this.getChildren().add(ivg);
			}
			break;
		case "S":
			if (tab[(int) ((this.positionY+34)/32)][(int) (this.positionX/32)] != 1){
			this.positionY=this.positionY+10;
			this.setTranslateY(this.positionY);
			this.getChildren().remove(ivd);
			this.getChildren().remove(ivg);
			this.getChildren().remove(iva);
			this.getChildren().remove(iv);
			this.getChildren().add(iv);
			}
			break;
		case "D":
			if (tab[(int) (this.positionY/32)][(int) ((this.positionX+26)/32)] != 1){
			this.positionX=this.positionX+10;
			this.setTranslateX(this.positionX);
			this.getChildren().remove(iva);
			this.getChildren().remove(ivg);
			this.getChildren().remove(iv);
			this.getChildren().remove(ivd);
			this.getChildren().add(ivd);
			}
			break;
		}
		if ((int)(this.positionY/32)==12 && (int) (this.positionX/32)==13){
			Text win = new Text("Niveau terminé !");
			win.setFont(new Font(60));
			win.setX(-400.0);
			win.setY(-200.0);
			this.getChildren().add(win);
		}
		
	}
	public void deplacerSouris(){
		/*
		 * a continuÃ©
		switch()
		*/
	}
}
