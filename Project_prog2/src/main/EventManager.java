package main;

import java.awt.Rectangle;

import door.door_info;
import door.door_info2;
import teleporteur.teleporteur_info;

public class EventManager {

	GamePanel gp;
	Rectangle eventRectangle;
	int eventRectDefaultX, eventRectDefaultY;

	public EventManager(GamePanel gp) {

		this.gp = gp;
		eventRectangle = new Rectangle(23, 23, 2, 2);
		eventRectDefaultX = eventRectangle.x;
		eventRectDefaultY = eventRectangle.y;
	}

	public void checkEvent() {
		System.out.println(gp.m_player.getM_x() / (16 * 3));
		System.out.println(gp.m_player.getM_y() / (16 * 3));
		// permet de cr�er un pi�ge si on est sur la 4�me ligne 5�me colonne on
		// peut
		// changer les PV par exemple
		// permet de faire une t�l�portation
		if (teleporteur_info.position_x == (gp.m_player.getM_x() / (16 * 3))
				&& teleporteur_info.position_y == gp.m_player.getM_y() / (16 * 3)) {
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}

		if (door_info.position_x == (gp.m_player.getM_x() / (16 * 3))
				&& door_info.position_y == gp.m_player.getM_y() / (16 * 3)) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info.destination_y);
			gp.changeMap = true;
		}
	}

	public void checkEvent2() {
		if (door_info2.position_x == (gp.m_player.getM_x() / (16 * 3))
				&& door_info2.position_y == gp.m_player.getM_y() / (16 * 3)) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info2.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info2.destination_y);
			gp.win = true;
		}
	}

	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		boolean hit = false;
		gp.m_player.area_collision.x = gp.m_player.getM_x() + gp.m_player.area_collision.x;
		gp.m_player.area_collision.y = gp.m_player.getM_y() + gp.m_player.area_collision.y;
		eventRectangle.x = eventCol * gp.TILE_SIZE + eventRectangle.x;
		eventRectangle.y = eventCol * gp.TILE_SIZE + eventRectangle.y;
		// On v�rifie si le rectangle de notre joueur est en collision avec le
		// rectangle
		// de notre �v�nement
		if (gp.m_player.area_collision.intersects(eventRectangle)) {
			if (gp.m_player.direction.contentEquals(reqDirection)) {
				hit = true;
			}
		}
		// on reset ensuite nos valeurs de rectangles de hitbox
		gp.m_player.area_collision.x = gp.m_player.area_collision_x_default;
		gp.m_player.area_collision.y = gp.m_player.area_collision_y_default;
		eventRectangle.x = eventRectDefaultX;
		eventRectangle.y = eventRectDefaultY;
		return hit;

	}

}
