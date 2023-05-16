package main;

import entity.Entity;

public class ColisionVerif {
	public GamePanel gp;

	public ColisionVerif(GamePanel gp) {

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

		if (entity.direction == "up") {
//entityTopRow = gp.til
		}
		if (entity.direction == "right") {

		}
		if (entity.direction == "left") {

		}
		if (entity.direction == "down") {

		}
	}
}
