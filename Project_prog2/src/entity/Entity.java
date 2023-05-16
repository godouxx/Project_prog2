package entity;

import java.awt.image.BufferedImage;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
	protected int m_x, m_y;				//position sur la map
	protected int m_speed;					//Déplacement de l'entité
	protected BufferedImage m_idleImage;	//Une image de l'entité
	protected int size;
	protected int pvMAX;
	protected int pvACTUAL;
	protected int degat;
}
