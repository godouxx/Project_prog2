package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Armes extends ObjetsPassifs {

	private int m_dammage;
	
	public

	Armes(int dammage, int x, int y) { // constructeur

		m_dammage = dammage;
		m_worldx = x;
		m_worldy = y;
		this.getArmeImage();

	}

	int getDammage() {
		return m_dammage;
	} // nombre de degats fait par l'arme

	void getArmeImage() { // recuperation image arme
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/armes/sword.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
