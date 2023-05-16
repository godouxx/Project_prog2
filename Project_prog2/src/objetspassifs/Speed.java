package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Speed extends ObjetsPassifs {

	private int m_speedBonus;

	public Speed(int speedBonus, int x, int y) {

		m_speedBonus = speedBonus;
		this.getSpeedImage();
		m_worldx = x;
		m_worldy = y;
	}

	int getSpeedBonus() {
		return m_speedBonus;
	}

	void getSpeedImage() { // recuperation image nourriture
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/speed/boost.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
