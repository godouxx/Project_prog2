package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import tile.Tile;

/**
 * D�fintition du comportement d'un joueur
 *
 */
public class Player extends Entity {

	GamePanel m_gp;
	KeyHandler m_keyH;
	BufferedImage heart_empty;
	BufferedImage heart_half;
	BufferedImage heart_full;
	BufferedImage game_over;


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
		this.area_collision=new Rectangle(0,0,48,48);
		this.pvMAX = 6;
		this.pvACTUAL = this.pvMAX;
		this.getHeartImage();
		this.getGameOver();
	}
	

	/**
	 * Initialisation des donn�es membres avec des valeurs par d�faut
	 */
	protected void setDefaultValues() {
		m_x = 100;
		m_y = 100;
		m_speed = 4;
	}

	/**
	 * R�up�ration de l'image du personnage
	 */
	public void getPlayerImage() {
		// gestion des expections
		try {
			m_idleImage = ImageIO.read(getClass().getResource("/Player/superhero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getHeartImage() {
		try {
			heart_empty = ImageIO.read(getClass().getResource("/maps/heart_red_empty.png"));
			
			heart_half = ImageIO.read(getClass().getResource("/maps/heart_red_half.png"));
			
			heart_full = ImageIO.read(getClass().getResource("/maps/heart_red_full.png"));
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getGameOver() {
		try {
			game_over = ImageIO.read(getClass().getResource("/ecran_fin/game_over.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void over(Graphics2D a_g2) {
		a_g2.drawImage(game_over, m_gp.SCREEN_WIDTH/4 , m_gp.SCREEN_HEIGHT/4, 400 , 400 ,  null);
	}
	
	/**
	 * Mise � jour des donn�es du joueur
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
	        
	        
	        
	        collision=false;
	       // m_gp.colisionVerif.checkTile(this);
	      //  m_gp.colisionVerif.checkTile(this);
	    }

	    // D�placement diagonal
	    if (goUp && goLeft) {
	        goUpLeftNext();
	    } else if (goUp && goRight) {
	        goUpRightNext();
	    } else if (goDown && goLeft) {
	        goDownLeftNext();
	    } else if (goDown && goRight) {
	        goDownRightNext();
	    }
	    // D�placement vertical ou horizontal
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
	 * Affichage du l'image du joueur dans la fen�tre du jeu
	 * 
	 * @param a_g2 Graphics2D
	 */
	@Override
	public void draw(Graphics2D a_g2) {
		// r�cup�re l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonn�es x et y, et
		// de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
		
		switch(this.getPvACTUAL()) {
		case 6:
			a_g2.drawImage(heart_full , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 5:
			a_g2.drawImage(heart_full , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_half , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 4:
			a_g2.drawImage(heart_full , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 3:
			a_g2.drawImage(heart_full , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_half , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 2:
			a_g2.drawImage(heart_full , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 1:
			a_g2.drawImage(heart_half , 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty , 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		default:
			a_g2.drawImage(game_over, m_gp.SCREEN_WIDTH/2 , m_gp.SCREEN_HEIGHT/2, 200 , 200 ,  null);
	
		}
		
		

	}

}
