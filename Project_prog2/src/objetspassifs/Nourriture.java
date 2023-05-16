package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Nourriture extends ObjetsPassifs {
	private int m_heal;


	public

	Nourriture(int heal, int x, int y) {
	
		m_heal = heal;
		this.getNourritureImage();
		m_worldx = x;
		m_worldy = y;
	}

	int getHeal() {
		return m_heal;
	}

	void getNourritureImage() { // recuperation image nourriture
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/nourriture/pomme.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public int getM_heal() {
		return m_heal;
	}

	public void setM_heal(int m_heal) {
		this.m_heal = m_heal;
	}
}
