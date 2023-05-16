package main;

import entity.Entity;

public class ColisionVerif {
	public GamePanel gp;

	public ColisionVerif(GamePanel gp) {
		this.gp = gp;

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
		// On vÈrifie si on est en collision avec un obstacle en haut ‡ gauche
		else if (entity.goUp && entity.goLeft) {
			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE; // Mettez ‡ jour y_g avec une soustraction
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;

			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision || gp.m_tileM.m_tile[tile2].m_collision) {

				entity.collision = true;
			}
			return;
		}

		// On vÈrifie si on est en collision avec un obstacle en haut ‡ droite
		else if (entity.goUp && entity.goRight) {
			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE; // Mettez ‡ jour y_g avec une soustraction
			entityRightCol = (x_d + entity.getM_speed()) / gp.TILE_SIZE; // Mettez ‡ jour x_d avec une addition
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision || gp.m_tileM.m_tile[tile2].m_collision) {

				entity.collision = true;
			}
			return;
		}

		// on v√©rifie si on est en collision avec un obstacle en haut
		else if (entity.goUp) {

			entityTopRow = (y_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
					entity.collision = true;
			}
			return;
		}
		// on v√©rifie si on est en collision avec un obstacle √† droite
		else if (entity.goRight) {
			entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {

				entity.collision = true;
			}
		}
		// on v√©rifie si on est en collision avec un obstacle √† gauche
		else if (entity.goLeft == true) {
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				entity.collision = true;
			}
			return;
		}
		// on v√©rifie si on est en collision avec un obstacle en bas
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
