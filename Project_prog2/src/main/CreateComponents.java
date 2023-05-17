package main;

import armes.armes_infos;
import door.door_info;
import entity.Monstre1;
import objetspassifs.Armes;
import objetspassifs.Door;
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

	public void setObjetsPassifs() {
		gp.objets.add(new Armes(armes_infos.damage, gp.TILE_SIZE * armes_infos.position_x,
				gp.TILE_SIZE * armes_infos.position_y));
		gp.objets.add(new Teleporteur(gp.TILE_SIZE * teleporteur_info.position_x,
				gp.TILE_SIZE * teleporteur_info.position_y));
		
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 15, gp.TILE_SIZE * 10));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 12, gp.TILE_SIZE * 7));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 12, gp.TILE_SIZE * 10));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 11, gp.TILE_SIZE * 10));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 30, gp.TILE_SIZE * 10));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 25, gp.TILE_SIZE * 25));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 48, gp.TILE_SIZE * 40));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 34, gp.TILE_SIZE * 35));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 48, gp.TILE_SIZE * 5));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 46, gp.TILE_SIZE * 45));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 46, gp.TILE_SIZE * 46));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 45, gp.TILE_SIZE * 43));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 42, gp.TILE_SIZE * 43));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 43, gp.TILE_SIZE * 43));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 48, gp.TILE_SIZE * 43));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 47, gp.TILE_SIZE * 48));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 48, gp.TILE_SIZE * 46));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 47, gp.TILE_SIZE * 46));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 42, gp.TILE_SIZE * 46));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 43, gp.TILE_SIZE * 44));
		gp.objets.add(new Obstacles(gp.TILE_SIZE * 42, gp.TILE_SIZE * 42));
		
		
		gp.objets.add(new Door(gp.TILE_SIZE * door_info.position_x, gp.TILE_SIZE * door_info.position_y));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 12, gp.TILE_SIZE * 5));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 39, gp.TILE_SIZE * 40));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 29, gp.TILE_SIZE * 5));
	
		gp.objets.add(new Speed(3, gp.TILE_SIZE * 2, gp.TILE_SIZE * 8));
		gp.objets.add(new Speed(3, gp.TILE_SIZE * 48, gp.TILE_SIZE * 48));

	}

	public void setMonsters() {
		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE * 10, gp.TILE_SIZE * 40));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));

	}
}
