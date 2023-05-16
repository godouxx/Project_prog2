package objetspassifs;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Nourriture extends ObjetsPassifs{
	
	private int m_heal;
	
	public
	
	Nourriture(int heal) {
		m_heal = heal;
		this.getNourritureImage();
		this.setDefaultValues();
	}

	int getHeal(){return m_heal;}
	
	void getNourritureImage() { //recuperation image nourriture
		//gestion des expections 
		try {
			m_idleImage = ImageIO.read(getClass().getResource(""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void setDefaultValues() { //recuperation position arme
		m_x = 100;
		m_y = 50;
	}
}
