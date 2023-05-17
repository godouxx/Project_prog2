package main;

import armes.armes_infos;
import door.door_info;
import door.door_info2;
import entity.Monstre1;
import objetspassifs.Armes;
import objetspassifs.Door;
import objetspassifs.Nourriture;
import objetspassifs.Obstacles;
import objetspassifs.Speed;
import objetspassifs.Obstacles;
import objetspassifs.Teleporteur;
import teleporteur.teleporteur_info;

public class CreateComponents2 {
	GamePanel gp;

	public CreateComponents2(GamePanel gp) {
		this.gp = gp;
	}

	public void setObjetsPassifs() {
		gp.objets.add(new Door(gp.TILE_SIZE * door_info2.position_x, gp.TILE_SIZE * door_info2.position_y));
//		gp.objets.add(new Armes(armes_infos.damage, gp.TILE_SIZE * armes_infos.position_x,
//				gp.TILE_SIZE * armes_infos.position_y));
//		gp.objets.add(new Obstacles(gp.TILE_SIZE * 4, gp.TILE_SIZE * 4));
//		gp.objets.add(new Door(gp.TILE_SIZE * door_info.position_x, gp.TILE_SIZE * door_info.position_y));
//		gp.objets.add(new Teleporteur(gp.TILE_SIZE * teleporteur_info.position_x,
//				gp.TILE_SIZE * teleporteur_info.position_y));
//		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 12, gp.TILE_SIZE * 5));
//		gp.objets.add(new Speed(3, gp.TILE_SIZE * 7, gp.TILE_SIZE * 10));

	}

	public void setMonsters() {
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE * 7, gp.TILE_SIZE * 2));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));
//		gp.monstres.add(new Monstre1(gp, gp.TILE_SIZE*8, gp.TILE_SIZE*4));

	}
}
