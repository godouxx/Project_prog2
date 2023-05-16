package entity;

import java.awt.image.BufferedImage;

/**
 * Entit� de base du jeu
 *
 */
public abstract class Entity {
	protected int m_x, m_y;				//position sur la map
	protected int m_speed;					//D�placement de l'entit�
	protected BufferedImage m_idleImage;	//Une image de l'entit�
	protected int size;
	protected int pvMAX;
	protected int pvACTUAL;
	protected int degat;
}
