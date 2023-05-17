package main;

import armes.armes_infos;
import entity.Monstre1;
import objetspassifs.Armes;
import objetspassifs.Nourriture;
import objetspassifs.Obstacles;
import objetspassifs.Speed;
import objetspassifs.Obstacles;
import objetspassifs.Teleporteur;
import teleporteur.teleporteur_info;

public class CreateComponents {
	GamePanel gp;

	public CreateComponents(GamePanel gp) {
		this.gp = gp;
	}
	public void setComponents() {
		gp.objets.add(new Obstacles(50,100));
		gp.objets.add(new Armes(2,100,200));
		gp.objets.add(new Nourriture(2,200,300));
		gp.objets.add(new Speed(2,300,200));
		}

	public void setObjetsPassifs() {
		gp.objets.add(new Armes(armes_infos.damage,gp.TILE_SIZE*armes_infos.position_x,gp.TILE_SIZE*armes_infos.position_y));
		gp.objets.add(new Obstacles(gp.TILE_SIZE*4,gp.TILE_SIZE*5));
		gp.objets.add(new Teleporteur(gp.TILE_SIZE*teleporteur_info.position_x,gp.TILE_SIZE*teleporteur_info.position_y));
		
	}
	
	public void setMonsters() {
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*7, gp.TILE_SIZE*3));
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
		
	}
}
