package main;

import armes.armes_infos;
import door.door_info;
import door.door_info2;
import entity.Monstre1;
import entity.Monstre2;
import objetspassifs.Armes;
import objetspassifs.Door;
import objetspassifs.Door2;
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
		gp.objets.add(new Door2(gp.TILE_SIZE * door_info2.position_x, gp.TILE_SIZE * door_info2.position_y));

		gp.objets.add(new Obstacles(gp.TILE_SIZE * 4, gp.TILE_SIZE * 4));

		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 39, gp.TILE_SIZE * 39));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 23, gp.TILE_SIZE * 45));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 28, gp.TILE_SIZE * 1));
		gp.objets.add(new Nourriture(2, gp.TILE_SIZE * 8, gp.TILE_SIZE * 18));

		gp.objets.add(new Speed(3, gp.TILE_SIZE * 10, gp.TILE_SIZE * 23));
		gp.objets.add(new Speed(3, gp.TILE_SIZE * 45, gp.TILE_SIZE * 1));
		gp.objets.add(new Speed(3, gp.TILE_SIZE * 11, gp.TILE_SIZE * 38));
		gp.objets.add(new Speed(3, gp.TILE_SIZE * 11, gp.TILE_SIZE * 15));

	}

	public void setMonsters() {
		gp.monstres2.add(new Monstre1(gp, gp.TILE_SIZE * 7, gp.TILE_SIZE * 2));
		gp.monstres2.add(new Monstre1(gp, gp.TILE_SIZE*38, gp.TILE_SIZE*38));
		gp.monstres2.add(new Monstre1(gp, gp.TILE_SIZE*30, gp.TILE_SIZE*4));
		gp.monstres2.add(new Monstre2(gp, gp.TILE_SIZE*21, gp.TILE_SIZE*42));
		gp.monstres2.add(new Monstre2(gp, gp.TILE_SIZE*4, gp.TILE_SIZE*39));
		gp.monstres2.add(new Monstre2(gp, gp.TILE_SIZE*5, gp.TILE_SIZE*14));
		gp.monstres2.add(new Monstre2(gp, gp.TILE_SIZE*6, gp.TILE_SIZE*28));

	}
}
