package objetspassifs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Obstacles extends ObjetsPassifs{
	
	
	
	public
	Obstacles( int x, int y) {
	
		this.getObstaclesImage();
		m_worldx = x;
		m_worldy = y;
	}
	
	void getObstaclesImage() { //recuperation image nourriture
		//gestion des expections 
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/obstacle/rocher(2).png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	
}
