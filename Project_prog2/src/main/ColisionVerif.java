package main;

import entity.Entity;

public class ColisionVerif {
	public GamePanel gp;

	public ColisionVerif(GamePanel gp) {

	}
	
	public void checkTile(Entity entity) {
		int x_g=entity.getM_x()+entity.area_collision.x;
		int x_d=entity.getM_x()+entity.area_collision.x+entity.area_collision.width;
		int y_g=entity.getM_y()+entity.area_collision.y;
		int y_d=entity.getM_y()+entity.area_collision.y+entity.area_collision.height;
		
		//int entityLefCol = entity
	}
}
