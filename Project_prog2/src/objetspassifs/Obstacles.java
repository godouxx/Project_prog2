package objetspassifs;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obstacles extends ObjetsPassifs{
	
	public
	Obstacles() {
		this.getObstaclesImage();
		this.setDefaultValues();
		}
	void getObstaclesImage() { //recuperation image nourriture
		//gestion des expections 
		try {
			m_idleImage = ImageIO.read(getClass().getResource(""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void setDefaultValues() { //recuperation position arme
		m_x = 50;
		m_y = 50;}
	
}
