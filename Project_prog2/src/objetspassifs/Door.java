package objetspassifs;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends ObjetsPassifs{

	
	public Door(int x, int y){
		m_worldx=x;
		m_worldy=y;
		getDoorImage();
	}
	void getDoorImage() { // 
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/door/open_door.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}