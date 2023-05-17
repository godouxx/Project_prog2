package main;

import objetspassifs.Armes;
import objetspassifs.Nourriture;
import objetspassifs.Obstacles;
import objetspassifs.Speed;

public class CreateComponents {
	GamePanel gp;

	public CreateComponents(GamePanel gp) {
		this.gp = gp;
	}
	public void setComponents() {
		gp.objets.add(new Obstacles(50,100));
		gp.objets.add(new Armes(2,100,200));
		gp.objets.add(new Nourriture(gp, 2,200,300));
		gp.objets.add(new Speed(gp, 2,300,200));
	}
}
