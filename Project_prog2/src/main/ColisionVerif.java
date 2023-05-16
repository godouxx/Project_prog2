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
		System.out.println(gp.TILE_SIZE);
		System.out.println(x_g / gp.TILE_SIZE);
		int entityLeftCol = x_g / gp.TILE_SIZE;
		int entityRightCol = x_g / gp.TILE_SIZE;
		int entityTopRow = y_g / gp.TILE_SIZE;
		int entityBottomRow = y_d / gp.TILE_SIZE;

		int tile1, tile2;
		if (entity.goDown == true && entity.goLeft) {
			entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				System.out.println("On entre en collsion avec un obstacle vers le bas et la gauche");
				entity.collision = true;
			}

		} else if (entity.goDown && entity.goRight) {
			entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
			entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				System.out.println("On entre en collsion avec un obstacle vers le bas et la droite");
				entity.collision = true;
			}
		} else if (entity.goUp && entity.goRight) {
			entityTopRow = (y_g + entity.getM_speed()) / gp.TILE_SIZE;
			entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				System.out.println("On entre en collsion avec un obstacle vers le haut et la droite");
				entity.collision = true;
			}
		} else if (entity.goUp && entity.goLeft) {
			entityTopRow = (y_g + entity.getM_speed()) / gp.TILE_SIZE;
			entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
			tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
			tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
			if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
				System.out.println("On entre en collsion avec un obstacle vers le haut et la gauche");
				entity.collision = true;
			} else if (entity.goUp == true) {

				entityTopRow = (y_g + entity.getM_speed()) / gp.TILE_SIZE;
				tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
				tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
				if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
					System.out.println("On entre en collsion avec un obstacle vers le haut");
					entity.collision = true;
				}
			} else if (entity.goRight == true) {
				entityRightCol = (x_d - entity.getM_speed()) / gp.TILE_SIZE;
				tile1 = gp.m_tileM.m_mapTileNum[entityRightCol][entityTopRow];
				tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
				if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
					System.out.println("On entre en collsion avec un obstacle vers la droite");
					entity.collision = true;
				}
			} else if (entity.goLeft == true) {
				entityLeftCol = (x_g - entity.getM_speed()) / gp.TILE_SIZE;
				tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityTopRow];
				tile2 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
				if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
					System.out.println("On entre en collsion avec un obstacle vers la gauche");
					entity.collision = true;
				}
			} else if (entity.goDown == true) {
				entityBottomRow = (y_d + entity.getM_speed()) / gp.TILE_SIZE;
				tile1 = gp.m_tileM.m_mapTileNum[entityLeftCol][entityBottomRow];
				tile2 = gp.m_tileM.m_mapTileNum[entityRightCol][entityBottomRow];
				if (gp.m_tileM.m_tile[tile1].m_collision == true || gp.m_tileM.m_tile[tile2].m_collision == true) {
					System.out.println("On entre en collsion avec un obstacle vers le bas");
					entity.collision = true;
				}

			}
		}
	}

}
