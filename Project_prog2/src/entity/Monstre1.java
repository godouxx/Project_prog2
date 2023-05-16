package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import monster.monster1_info;

public class Monstre1 extends Entity {
	private GamePanel m_gp;

//constructeur de monstre
	public Monstre1(GamePanel a_gp, int X, int Y) {
		this.m_gp = a_gp;
		this.setM_x(X);
		this.setM_y(Y);
		this.setDefaultValues();
		this.getMonstre1Image();
	}

	@Override public void update() {
		//setM_x(m_x+1);
	}
	public void getMonstre1Image() {
		// gestion des expections
		try {
			m_idleImage = ImageIO.read(getClass().getResource("/monster/monster1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//utilisé dans le constructeur pour intialiser nos monstres avec les valeurs qui ne bougent pas
	protected void setDefaultValues() {
		setM_speed(monster1_info.speed);
		setPvMAX(monster1_info.pvMAX);
		setPvACTUAL(getPvMAX());
	}
	
	
	@Override public void draw(Graphics2D a_g2) {
		// récupère l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonnées x et y, et
		// de taille tileSize (16x16) sans échelle, et 48x48 avec échelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}
	
}
