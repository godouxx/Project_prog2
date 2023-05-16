package main;

import java.awt.Rectangle;

public class EventManager {

	GamePanel gp;
	Rectangle eventRectangle;
	int eventRectDefaultX, eventRectDefaultY;

	public EventManager(GamePanel gp) {
		
		this.gp = gp;
		eventRectangle=new Rectangle(23,23,2,2);
		eventRectDefaultX=eventRectangle.x;
		eventRectDefaultY=eventRectangle.y;
	}

	public void checkEvent() {
if(hit(4,5,"right")==true) {
	gp.m_player.setPvACTUAL(0);
}


if(hit(2,9,"up")==true) {
	gp.m_player.setM_x(10*gp.TILE_SIZE);
	gp.m_player.setM_y(10*gp.TILE_SIZE);
}
	}

	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		boolean hit = false;
		gp.m_player.area_collision.x = gp.m_player.getM_x() + gp.m_player.area_collision.x;
		gp.m_player.area_collision.y = gp.m_player.getM_y() + gp.m_player.area_collision.y;
		eventRectangle.x = eventCol * gp.TILE_SIZE + eventRectangle.x;
		eventRectangle.y = eventCol * gp.TILE_SIZE + eventRectangle.y;
		//On vérifie si le rectangle de notre joueur est en collision avec le rectangle de notre évènement
		if(gp.m_player.area_collision.intersects(eventRectangle)) {
			if(gp.m_player.direction.contentEquals(reqDirection)) {
				hit =true;
			}
		}
		//on reset ensuite nos valeurs de rectangles de hitbox
		gp.m_player.area_collision.x=gp.m_player.area_collision_x_default;
		gp.m_player.area_collision.y=gp.m_player.area_collision_y_default;
		eventRectangle.x=eventRectDefaultX;
		eventRectangle.y=eventRectDefaultY;
		return hit;

	}

}
