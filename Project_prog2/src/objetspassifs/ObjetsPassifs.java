package objetspassifs;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

/**
 * Objets de base du jeu
 *
 */

public class ObjetsPassifs {
	public int m_worldx, m_worldy; // position sur la map
	public BufferedImage m_ObjetImage; // Une image d'objet
	public Rectangle area_collision = new Rectangle(0, 0, 48, 48);
	public boolean collision;
	public int area_collision_x_default = 0, area_collision_y_default = 0;

	public void draw(Graphics2D a_g2, GamePanel gp) {
		int screenX = m_worldx - gp.m_player.getM_x() + gp.m_player.screenX;
		int screenY = m_worldy - gp.m_player.getM_y() + gp.m_player.screenY;

		if (m_worldx + gp.TILE_SIZE > gp.m_player.getM_x() - gp.m_player.screenX
				&& m_worldx - gp.TILE_SIZE < gp.m_player.getM_x() + gp.m_player.screenX
				&& m_worldy + gp.TILE_SIZE > gp.m_player.getM_y() - gp.m_player.screenY
				&& m_worldy - gp.TILE_SIZE < gp.m_player.getM_y() + gp.m_player.screenY) {
			a_g2.drawImage(m_ObjetImage, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE, null);
		}
	}
}
