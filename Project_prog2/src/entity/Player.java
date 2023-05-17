package entity;

import java.awt.Color;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import objetspassifs.Armes;
import objetspassifs.Nourriture;
import objetspassifs.ObjetsPassifs;
import objetspassifs.Obstacles;
import objetspassifs.Speed;
import objetspassifs.Rechange;
import main.ColisionVerif;
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
	BufferedImage succes;

	public final int screenX;
	public final int screenY;

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
		this.area_collision = new Rectangle(0, 0, 40, 40);
		this.pvMAX = 6;
		this.pvACTUAL = this.pvMAX;
		this.direction="down";
		this.getHeartImage();
		this.getGameOver();
		this.getSucces();
		screenX = a_gp.SCREEN_WIDTH / 2 - (a_gp.TILE_SIZE / 2);
		screenY = a_gp.SCREEN_HEIGHT / 2 - (a_gp.TILE_SIZE / 2);
		area_collision_y_default=area_collision.y;
		area_collision_x_default=area_collision.x;
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
		a_g2.drawImage(game_over, m_gp.SCREEN_WIDTH / 4, m_gp.SCREEN_HEIGHT / 4, 400, 400, null);
	}
	
	public void getSucces() {
		try {
			succes = ImageIO.read(getClass().getResource("/ecran_fin/succes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void win(Graphics2D a_g2) {
		a_g2.drawImage(succes, m_gp.SCREEN_WIDTH / 4, m_gp.SCREEN_HEIGHT / 4, 400, 400, null);
	}

	/**
	 * Mise � jour des donn�es du joueur
	 */
	@Override
	public void update() {
	
		for (int element : m_keyH.liste) {
			
			if (element == 90) {
				goUp = true;
				direction="up";
				
			}
			if (element == 83) {
				goDown = true;
				direction="down";
			}
			if (element == 81) {
				goLeft = true;
				direction="left";
			}
			if (element == 68) {
				goRight = true;
				direction="right";
			}


		}

		collision = false;
		this.m_gp.colisionVerif.checkTile(this);
		int index = this.m_gp.colisionVerif.checkObjet(this, true);
		prendreObjet(index);
		
		if (collision == false) {

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

			System.out.println("dega : " +this.degat +".");
			//System.out.println("pv : " +this.getPvACTUAL());
			//System.out.println("speed : " +this.getM_speed());
			
			//System.out.println(m_gp.objets);
			//System.out.println(m_gp.objets.get(2));
		}

		m_gp.eventManagerr.checkEvent();
		
		goUp = false;
		goDown = false;
		goLeft = false;
		goRight = false;
	}
	
	public void prendreObjet(int index) {
		
		System.out.println("index : " +index);
		
		if(index != 999 && index>=0) { //si l'index est != de 999 cela signifie que l'on a toucher un objet
		
			if(m_gp.objets.get(index) instanceof Armes) {
				this.setDegat(this.degat+4);
				
				Rechange rechange = new Rechange(500,400);
				m_gp.objets.set(index, rechange);
			}
			
			if(m_gp.objets.get(index) instanceof Nourriture) {
				
				if(this.getPvACTUAL() != this.getPvMAX()) { //ne pas avior plus que MaxPV
					
					this.setPvACTUAL(this.pvACTUAL+1);
				}
				Rechange rechange = new Rechange(500,400);
				m_gp.objets.set(index, rechange);
			}
			
			if(m_gp.objets.get(index) instanceof Obstacles) {
	
				this.collision = true;
			}
			
			if(m_gp.objets.get(index) instanceof Speed) {
				
				this.setM_speed(this.m_speed+3);   //m_gp.objets.getSpeedBonus()
				Rechange rechange = new Rechange(500,400);
				m_gp.objets.set(index, rechange);
			}
			
			//m_gp.objets.remove(index);
			
			//Rechange rechange = new Rechange(500,400);
			//m_gp.objets.set(index, rechange);
		}
	}
 
	

	public void goUpLeftNext() {
		this.m_y -= Math.sqrt(2) / 2 * m_speed;
		this.m_x -= Math.sqrt(2) / 2 * m_speed;
	}

	public void goUpRightNext() {
		this.m_y -= Math.sqrt(2) / 2 * m_speed;
		this.m_x += Math.sqrt(2) / 2 * m_speed;
	}

	public void goDownLeftNext() {
		this.m_y += Math.sqrt(2) / 2 * m_speed;
		this.m_x -= Math.sqrt(2) / 2 * m_speed;
	}

	public void goDownRightNext() {
		this.m_y += Math.sqrt(2) / 2 * m_speed;
		this.m_x += Math.sqrt(2) / 2 * m_speed;
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
		a_g2.drawImage(l_image, screenX, screenY, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);

		switch (this.getPvACTUAL()) {
		case 6:
			a_g2.drawImage(heart_full, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 5:
			a_g2.drawImage(heart_full, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_half, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 4:
			a_g2.drawImage(heart_full, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_full, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 3:
			a_g2.drawImage(heart_full, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_half, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 2:
			a_g2.drawImage(heart_full, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		case 1:
			a_g2.drawImage(heart_half, 20, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 70, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			a_g2.drawImage(heart_empty, 120, 8, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			break;
		default:
			a_g2.drawImage(game_over, m_gp.SCREEN_WIDTH / 2, m_gp.SCREEN_HEIGHT / 2, 200, 200, null);

		}

	}

}
