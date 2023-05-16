package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

/**
 * Dï¿½fintition du comportement d'un joueur
 *
 */
public class Player extends Entity {

	GamePanel m_gp;
	KeyHandler m_keyH;

	/**
	 * Constructeur de Player
	 * 
	 * @param a_gp   GamePanel, pannel principal du jeu
	 * @param a_keyH KeyHandler, gestionnaire des touches
	 */
	public Player(GamePanel a_gp, KeyHandler a_keyH) {
		this.m_gp = a_gp;
		this.m_keyH = a_keyH;
		this.setDefaultValues();
		this.getPlayerImage();
	}

	/**
	 * Initialisation des donnï¿½es membres avec des valeurs par dï¿½faut
	 */
	protected void setDefaultValues() {
		m_x = 100;
		m_y = 100;
		m_speed = 4;
	}

	/**
	 * Rï¿½cupï¿½ration de l'image du personnage
	 */
	public void getPlayerImage() {
		// gestion des expections
		try {
			m_idleImage = ImageIO.read(getClass().getResource("/Player/superhero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mise ï¿½ jour des donnï¿½es du joueur
	 */
	@Override
	public void update() {
	    boolean goUp = false;
	    boolean goDown = false;
	    boolean goLeft = false;
	    boolean goRight = false;

	    for (int element : m_keyH.liste) {
	        System.out.println(element);
	        if (element == 90) {
	            goUp = true;
	        }
	        if (element == 83) {
	            goDown = true;
	        }
	        if (element == 81) {
	            goLeft = true;
	        }
	        if (element == 68) {
	            goRight = true;
	        }
	    }

	    // Déplacement diagonal
	    if (goUp && goLeft) {
	        goUpLeftNext();
	    } else if (goUp && goRight) {
	        goUpRightNext();
	    } else if (goDown && goLeft) {
	        goDownLeftNext();
	    } else if (goDown && goRight) {
	        goDownRightNext();
	    }
	    // Déplacement vertical ou horizontal
	    else if (goUp) {
	        goUpNext();
	    } else if (goDown) {
	        goDownNext();
	    } else if (goLeft) {
	        goLeftNext();
	    } else if (goRight) {
	        goRightNext();
	    }
	}


	public void goUpNext() {
		this.m_y -= 1*m_speed;
	}

	public void goDownNext() {
		this.m_y += 1*m_speed;
	}

	
	public void goLeftNext() {
		this.m_x -= 1*m_speed;
	}

	public void goRightNext() {
		this.m_x += 1*m_speed;
	}

	public void goUpLeftNext() {
	    this.m_y -= Math.sqrt(2)/2 * m_speed;
	    this.m_x -= Math.sqrt(2)/2 * m_speed;
	}

	public void goUpRightNext() {
	    this.m_y -= Math.sqrt(2)/2 * m_speed;
	    this.m_x += Math.sqrt(2)/2 * m_speed;
	}

	public void goDownLeftNext() {
	    this.m_y += Math.sqrt(2)/2 * m_speed;
	    this.m_x -= Math.sqrt(2)/2 * m_speed;
	}

	public void goDownRightNext() {
	    this.m_y += Math.sqrt(2)/2 * m_speed;
	    this.m_x += Math.sqrt(2)/2 * m_speed;
	}

	
	/**
	 * Affichage du l'image du joueur dans la fenï¿½tre du jeu
	 * 
	 * @param a_g2 Graphics2D
	 */
	@Override
	public void draw(Graphics2D a_g2) {
		// rï¿½cupï¿½re l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonnï¿½es x et y, et
		// de taille tileSize (16x16) sans ï¿½chelle, et 48x48 avec ï¿½chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}

}
