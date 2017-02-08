package affichage;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Heros extends Parent {
	Rectangle rec;
	double positionX=0;
	double positionY=0;
	public Heros(){
		this.setTranslateX(positionX);
		this.setTranslateY(positionY);
		rec=new Rectangle();
		rec.setWidth(20);
		rec.setHeight(50);
		rec.setFill(Color.RED);
		this.getChildren().add(rec);
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
		switch(direction){
		case "O":
			this.positionY=this.positionY-10;
			this.setTranslateY(this.positionY);
			break;
		case "K":
			this.positionX=this.positionX-10;
			this.setTranslateX(this.positionX);
			break;
		case "L":
			this.positionY=this.positionY+10;
			this.setTranslateY(this.positionY);
			break;
		case "M":
			this.positionX=this.positionX+10;
			this.setTranslateX(this.positionX);
			break;
		}
		
	}
	public void deplacerSouris(){
		/*
		 * a continué
		switch()
		*/
	}
}
