package main;

import objetspassifs.Armes;
import objetspassifs.Obstacles;

public class CreateComponents {
	GamePanel gp;

	public CreateComponents(GamePanel gp) {
		this.gp = gp;
	}
	public void setComponents() {
		gp.objets.add(new Armes(2,100,200));
		gp.objets.add(new Obstacles(gp.TILE_SIZE*4,gp.TILE_SIZE*5));
	}
}
