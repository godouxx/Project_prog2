package objetspassifs;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

//cette classe sert à faire pop un objet invisible pour remplacer l'objet pris par le player.
//on remplace cet objet pour avoir une liste d'objet toujour de même taille

public class Rechange extends ObjetsPassifs{

	GamePanel m_gp;

	public

	Rechange(int x, int y) { // constructeur

		m_worldx = x;
		m_worldy = y;

	}
}
