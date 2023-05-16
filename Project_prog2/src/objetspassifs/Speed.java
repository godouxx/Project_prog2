package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Speed extends ObjetsPassifs {

	private int m_speedBonus;
				GamePanel m_gp;
	
	public 
	Speed(GamePanel a_gp, int speedBonus, int x, int y) {
		m_gp = a_gp;
		m_speedBonus = speedBonus;
		this.getSpeedImage();
		m_x = x;
		m_y = y;
	}
	
	int getSpeedBonus() {return m_speedBonus;}
	
	void getSpeedImage() { //recuperation image nourriture
		//gestion des expections 
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/speed/boost.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Affichage du l'image de l'arme dans la fenetre du jeu
	 * @param a_g2 Graphics2D 
	 */
	public void draw(Graphics2D a_g2) {
		// recupere l'image de la Speed
		BufferedImage l_image = m_ObjetImage;
		// affiche la Speed avec l'image "image", avec les coordonnees x et y, et de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}
	
	void delete() {
		this.m_gp = null;
		this.m_speedBonus = 0;
	}
}
