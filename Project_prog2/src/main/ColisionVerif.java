package main;

import entity.Entity;

public class ColisionVerif {
	public GamePanel gp;

	public ColisionVerif(GamePanel gp) {
		this.gp = gp;

	}

	// cette fonction verifie si un joueur touche un objet, si c'est le cas on
	// renvoie l'index de l'objet
	public int checkObjet(Entity entity, boolean player) { // on verifie si l'entite est bien un player
		int index = 999;

		for (int i = 0; i < gp.objets.size(); i++) {

			if (gp.objets.get(i) != null) {
				// get solid area position du player
				entity.area_collision.x = entity.getM_x() + entity.area_collision.x;
				entity.area_collision.y = entity.getM_y() + entity.area_collision.y;

				// get solid area position de l'objet
				gp.objets.get(i).area_collision.x = gp.objets.get(i).m_worldx + gp.objets.get(i).area_collision.x;
				gp.objets.get(i).area_collision.y = gp.objets.get(i).m_worldy + gp.objets.get(i).area_collision.y;

				// ou va aller le player

				if (entity.goUp == true) {
					entity.area_collision.y -= entity.getM_speed();
					// si il y a une intersection entre les deux area
					if (entity.area_collision.intersects(gp.objets.get(i).area_collision)) {
						System.out.print("collision up");
					}
				} else if (entity.goDown == true) {
					entity.area_collision.y += entity.getM_speed();
					// si il y a une intersection entre les deux area
					if (entity.area_collision.intersects(gp.objets.get(i).area_collision)) {
						System.out.print("collision down");
					}

				} else if (entity.goLeft == true) {
					entity.area_collision.x -= entity.getM_speed();
					// si il y a une intersection entre les deux area
					if (entity.area_collision.intersects(gp.objets.get(i).area_collision)) {
						System.out.print("collision left");
					}

				} else if (entity.goRight == true) {
					entity.area_collision.x += entity.getM_speed();
					// si il y a une intersection entre les deux area
					if (entity.area_collision.intersects(gp.objets.get(i).area_collision)) {
						System.out.print("collision right");
					}
				}
				// reinitialisation area entite et objet
				entity.area_collision.x = entity.area_collision_x_default;
				entity.area_collision.y = entity.area_collision_y_default;

				gp.objets.get(i).area_collision.x = gp.objets.get(i).area_collision_x_default;
				gp.objets.get(i).area_collision.y = gp.objets.get(i).area_collision_y_default;

			}

		}
		return index;
	}

	

	public void checkTile(Entity entity) {
		int x_g = entity.getM_x() + entity.area_collision.x;
		int x_d = entity.getM_x() + entity.area_collision.x + entity.area_collision.width;
		int y_g = entity.getM_y() + entity.area_collision.y;
		int y_d = entity.getM_y() + entity.area_collision.y + entity.area_collision.height;

		int entityLeftCol = x_g / gp.TILE_SIZE;
		int entityRightCol = x_g / gp.TILE_SIZE;
		int entityTopRow = y_g / gp.TILE_SIZE;
		int entityBottomRow = y_d / gp.TILE_SIZE;

		int tile1, tile2;
//on verifie si on est en collision avec un obstacle en bas a gauche
		if (entity.goDown == true && entity.goLeft) {
			entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {

				entity.collision = true;
			}
			return;
		}
		// on verifie si on est en collision avec un obstacle en bas a droite
		else if (entity.goDown && entity.goRight) {
			entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
			entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {

				entity.collision = true;
			}
			return;
		}
		// On vérifie si on est en collision avec un obstacle en haut à gauche
		else if (entity.goUp && entity.goLeft) {
			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE; // Mettez à jour y_g avec une soustraction
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;

			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision || gp.m_tileM.m_tile[tile2].m_collision) {

				entity.collision = true;
			}
			return;
		}

		// On vérifie si on est en collision avec un obstacle en haut à droite
		else if (entity.goUp && entity.goRight) {
			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE; // Mettez à jour y_g avec une soustraction
			entityRightCol = (x_d + entity.getM_speed()) / gp.TILE_SIZE; // Mettez à jour x_d avec une addition
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision || gp.m_tileM.m_tile[tile2].m_collision) {

				entity.collision = true;
			}
			return;
		}

		// on vÃ©rifie si on est en collision avec un obstacle en haut
		else if (entity.goUp) {

			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				entity.collision = true;
			}
			return;
		}
		// on vÃ©rifie si on est en collision avec un obstacle Ã  droite
		else if (entity.goRight) {
			entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {

				entity.collision = true;
			}
		}
		// on vÃ©rifie si on est en collision avec un obstacle Ã  gauche
		else if (entity.goLeft == true) {
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				entity.collision = true;
			}
			return;
		}
		// on vÃ©rifie si on est en collision avec un obstacle en bas
		else if (entity.goDown == true) {
			entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {

				entity.collision = true;
			}
			return;

		}

	}

}
