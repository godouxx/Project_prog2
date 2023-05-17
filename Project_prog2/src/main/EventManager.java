package main;

import java.awt.Rectangle;

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
		// permet de créer un piège si on est sur la 4ème ligne 5ème colonne on peut
		// changer les PV par exemple
		if (hit(4, 5, "right") == true) {
			gp.m_player.setPvACTUAL(0);
		}
		// permet de faire une téléportation
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "up")) {
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "down")) {
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "left") == true) {
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "right")) {
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
	}

	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		boolean hit = false;
		gp.m_player.area_collision.x = gp.m_player.getM_x() + gp.m_player.area_collision.x;
		gp.m_player.area_collision.y = gp.m_player.getM_y() + gp.m_player.area_collision.y;
		eventRectangle.x = eventCol * gp.TILE_SIZE + eventRectangle.x;
		eventRectangle.y = eventCol * gp.TILE_SIZE + eventRectangle.y;
		// On vérifie si le rectangle de notre joueur est en collision avec le rectangle
		// de notre évènement
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
