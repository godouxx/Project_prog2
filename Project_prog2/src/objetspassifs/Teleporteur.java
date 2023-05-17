package objetspassifs;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Teleporteur extends ObjetsPassifs{

	
	public Teleporteur(int x, int y){
		m_worldx=x;
		m_worldy=y;
		getTeleporteurImage();
	}
	void getTeleporteurImage() { // recuperation image nourriture
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/teleporteur/scroll.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
