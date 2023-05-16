package objetspassifs;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Objets de base du jeu
 *
 */

public class ObjetsPassifs {
	public int m_x, m_y; // position sur la map
	public BufferedImage m_ObjetImage; // Une image d'objet
	public Rectangle area_collision;
	public boolean collision;

	public void draw(Graphics2D a_g2) {

	}
}
