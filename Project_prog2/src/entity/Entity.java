package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.text.Position;

import main.GamePanel;

import java.awt.Rectangle;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
	protected int m_x, m_y; // position sur la map
	protected int m_speed; // Déplacement de l'entité
	protected BufferedImage m_idleImage; // Une image de l'entité

	protected int pvMAX;
	protected int pvACTUAL;
	protected int degat;
	public Rectangle area_collision;
	public boolean collision;
	public String direction;
	public boolean goUp = false;
	public boolean goDown = false;
	public boolean goLeft = false;
	public boolean goRight = false;
	public int area_collision_x_default, area_collision_y_default;

	public int getM_x() {
		return m_x;
	}

	public void setM_x(int m_x) {
		this.m_x = m_x;
	}

	public int getM_y() {
		return m_y;
	}

	public void setM_y(int m_y) {
		this.m_y = m_y;
	}

	public int getM_speed() {
		return m_speed;
	}

	public void setM_speed(int m_speed) {
		this.m_speed = m_speed;
	}

	public int getPvMAX() {
		return pvMAX;
	}

	public void setPvMAX(int pvMAX) {
		this.pvMAX = pvMAX;
	}

	public int getPvACTUAL() {
		return pvACTUAL;
	}

	public void setPvACTUAL(int pvACTUAL) {
		this.pvACTUAL = pvACTUAL;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public void draw(Graphics2D a_g2) {

	}

	public void goUpNext() {
		this.m_y -= 1 * m_speed;
	}

	public void goDownNext() {
		this.m_y += 1 * m_speed;
	}

	public void goLeftNext() {
		this.m_x -= 1 * m_speed;
	}

	public void goRightNext() {
		this.m_x += 1 * m_speed;
	}

	public void update() {

	}

	public void draw(Graphics2D a_g2, GamePanel gp) {

	}

	public void takeDamage(Entity e) {
		pvACTUAL = pvACTUAL - e.getDegat();
	}

}
