package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Nourriture extends ObjetsPassifs {
	private String name = "food";
	private int m_heal;
	GamePanel m_gp;

	public

	Nourriture(GamePanel a_gp, int heal, int x, int y) {
		m_gp = a_gp;
		m_heal = heal;
		this.getNourritureImage();
		m_x = x;
		m_y = y;
	}

	int getHeal() {
		return m_heal;
	}

	void getNourritureImage() { // recuperation image nourriture
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/nourriture/pomme.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Affichage du l'image de l'arme dans la fenetre du jeu
	 * 
	 * @param a_g2 Graphics2D
	 */
	public void draw(Graphics2D a_g2) {
		// recupere l'image de la nourriture
		BufferedImage l_image = m_ObjetImage;
		// affiche la nourriture avec l'image "image", avec les coordonnees x et y, et
		// de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}

	void delete() {
		this.m_gp = null;
		this.m_heal = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getM_heal() {
		return m_heal;
	}

	public void setM_heal(int m_heal) {
		this.m_heal = m_heal;
	}
}
