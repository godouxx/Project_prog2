package main;

import objetspassifs.Armes;

public class CreateComponents {
	GamePanel gp;

	public CreateComponents(GamePanel gp) {
		this.gp = gp;
	}
	public void setComponents() {
		gp.objets.add(new Armes(2,100,200));
	}
}
