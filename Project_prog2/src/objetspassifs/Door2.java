package objetspassifs;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door2 extends ObjetsPassifs{

	
	public Door2(int x, int y){
		m_worldx=x;
		m_worldy=y;
		getDoorImage();
	}
	void getDoorImage() { // 
		// gestion des expections
		try {
			m_ObjetImage = ImageIO.read(getClass().getResource("/door/door2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}