package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Obstacles extends ObjetsPassifs{
	
	private GamePanel m_gp;
	
	public
	Obstacles(GamePanel a_gp, int x, int y) {
		m_gp = a_gp;
		this.getObstaclesImage();
		m_x = x;
		m_y = y;
	}
	
	void getObstaclesImage() { //recuperation image nourriture
		//gestion des expections 
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/obstacle/rocher(2).png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Affichage du l'image de l'arme dans la fenetre du jeu
	 * @param a_g2 Graphics2D 
	 */
	public void draw(Graphics2D a_g2) {
		// recupere l'image de l'obstacle
		BufferedImage l_image = m_ObjetImage;
		// affiche l'obstacle avec l'image "image", avec les coordonnees x et y, et de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}
	
}
