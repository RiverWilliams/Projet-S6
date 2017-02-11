package niveau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
	private void afficher(GraphicsContext gc, Image tileset, int[][] table) {
		for (int j = 0; j < table.length; j++) {
			for (int i = 0; i < table[j].length; i++) {
				Rectangle2D source;
				Rectangle2D destination = new Rectangle2D((double)(i * 16), (double)(j * 16), 16.0, 16.0);
				if (table[j][i] != 0) {
					source = new Rectangle2D(0.0, 0.0, 16.0, 16.0);
					gc.drawImage(tileset, source.getMinX(), source.getMinY(), source.getWidth(), source.getHeight(), destination.getMinX(), destination.getMinY(), destination.getWidth(), destination.getHeight());
				}
				source = new Rectangle2D((double)(table[j][i] * 16), 0.0, 16.0, 16.0);
				gc.drawImage(tileset, source.getMinX(), source.getMinY(), source.getWidth(), source.getHeight(), destination.getMinX(), destination.getMinY(), destination.getWidth(), destination.getHeight());
			}
		}
	}
	
	private int[][] importation(String nomFichier) throws IOException {
		// TODO Auto-generated method stub
		int [][] table = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(nomFichier)));
			int hauteur = -1;
			int largeur = -1;
			StringTokenizer line = new StringTokenizer(br.readLine());
			while ((br.readLine()) != null){
				if (largeur == -1){
					hauteur += 2;
					largeur = line.countTokens();
				}
				hauteur++;
			}
			//			System.out.println("hauteur : " + hauteur);
			//			System.out.println("largeur : " + largeur);
			br.close();
			br = new BufferedReader(new FileReader(new File(nomFichier)));
			table = new int[hauteur][largeur];
			for (int i = 0; i < table.length; i++) {
				line = new StringTokenizer(br.readLine());
				for (int j = 0; j < table[i].length; j++) {
					table[i][j]= Integer.parseInt(line.nextToken());
				}
			}
			br.close();
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table[i].length; j++) {
					System.out.print(table[i][j]+" ");
				}
				System.out.println("");
			}
		} catch (FileNotFoundException e){
			System.out.println("erreur ouverture");
		}

		return table;
	}
}
