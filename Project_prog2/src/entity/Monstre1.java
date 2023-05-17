package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.ColisionVerif;
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

		// length de 29 et wiegth de 24 sur l'image
		this.area_collision = new Rectangle(0, 0, 24, 29);
		this.area_collision_x_default = area_collision.x;
		this.area_collision_y_default = area_collision.y;
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

	@Override
	public void update() {

		Random random = new Random();

		int i = random.nextInt(3);
//On change de direction toutes les 2 secondes
		if (m_gp.bloquer_action == 1) {

			if (i == 0) {
				direction = "up";

			}
			if (i == 1) {
				direction = "down";

			}
			if (i == 2) {
				direction = "left";

			}
			if (i == 3) {
				direction = "right";
			}
		}
		
		collision = false;
		this.m_gp.colisionVerif.checkTileMonster(this);
		
		if (collision == false) {
			if (direction == "up") {
				goUpNext();
				System.out.println("up");
			} else if (direction == "down") {
				goDownNext();
				System.out.println("down");
			} else if (direction == "left") {
				goLeftNext();
				System.out.println("left");
			} else if (direction == "right") {
				goRightNext();
				System.out.println("right");
			}
		}

	}

	@Override
	public void draw(Graphics2D a_g2, GamePanel gp) {
		int screenX = getM_x() - gp.m_player.getM_x() + gp.m_player.screenX;
		int screenY = getM_y() - gp.m_player.getM_y() + gp.m_player.screenY;

		if (getM_x() + gp.TILE_SIZE > gp.m_player.getM_x() - gp.m_player.screenX
				&& getM_x() - gp.TILE_SIZE < gp.m_player.getM_x() + gp.m_player.screenX
				&& getM_y() + gp.TILE_SIZE > gp.m_player.getM_y() - gp.m_player.screenY
				&& getM_y() - gp.TILE_SIZE < gp.m_player.getM_y() + gp.m_player.screenY) {
			a_g2.drawImage(m_idleImage, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE, null);
		}
	}

}
