package main;

import java.awt.Rectangle;

import door.door_info;
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
		// permet de crï¿½er un piï¿½ge si on est sur la 4ï¿½me ligne 5ï¿½me colonne on peut
		// changer les PV par exemple
		if (hit(4, 5, "right") == true) {
			gp.m_player.setPvACTUAL(0);
		}
		// permet de faire une tï¿½lï¿½portation
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "up")) {
			System.out.println("on se téléporte");
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "down")) {
			System.out.println("on se téléporte");
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "left")) {

			System.out.println("on se téléporte");

			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		if (hit(teleporteur_info.position_x, teleporteur_info.position_y, "right")) {
			System.out.println("on se téléporte");
			gp.m_player.setM_x(gp.TILE_SIZE * teleporteur_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * teleporteur_info.destination_y);
		}
		
		if (hit(door_info.position_x, door_info.position_y, "up")) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info.destination_y);
			gp.changeMap = true;
		}
		if (hit(door_info.position_x, door_info.position_y, "down")) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info.destination_y);
			gp.changeMap = true;
		}
		if (hit(door_info.position_x, door_info.position_y, "left")) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info.destination_y);
			gp.changeMap = true;
		}
		if (hit(door_info.position_x, door_info.position_y, "right")) {
			gp.m_player.setM_x(gp.TILE_SIZE * door_info.destination_x);
			gp.m_player.setM_y(gp.TILE_SIZE * door_info.destination_y);
			gp.changeMap = true;
		}
	}

	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		boolean hit = false;
		gp.m_player.area_collision.x = gp.m_player.getM_x() + gp.m_player.area_collision.x;
		gp.m_player.area_collision.y = gp.m_player.getM_y() + gp.m_player.area_collision.y;
		eventRectangle.x = eventCol * gp.TILE_SIZE + eventRectangle.x;
		eventRectangle.y = eventCol * gp.TILE_SIZE + eventRectangle.y;
		// On vï¿½rifie si le rectangle de notre joueur est en collision avec le rectangle
		// de notre ï¿½vï¿½nement
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
