package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Armes extends ObjetsPassifs {

	private int m_dammage;
			GamePanel m_gp;
	
	public 
	
	Armes(GamePanel a_gp, int dammage) { //constructeur
		
		m_gp = a_gp;
		m_dammage = dammage;
		this.getArmeImage();
		this.setDefaultValues();} 
	
	int getDammage() {return m_dammage;} //nombre de degats fait par l'arme

	void getArmeImage() { //recuperation image arme
		//gestion des expections 
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/armes/Arme2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void setDefaultValues() { //recuperation position arme
		m_x = 300;
		m_y = 100;
	}
	
	/**
	 * Affichage du l'image de l'arme dans la fenetre du jeu
	 * @param a_g2 Graphics2D 
	 */
	public void draw(Graphics2D a_g2) {
		// recupere l'image de l'arme
		BufferedImage l_image = m_ObjetImage;
		// affiche l'arme avec l'image "image", avec les coordonnees x et y, et de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}
}