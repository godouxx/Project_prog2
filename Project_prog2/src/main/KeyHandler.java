package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Gestionnaire d'�v�nements (touche clavier)
 *
 */
public class KeyHandler implements KeyListener{

    public HashSet<Integer> liste = new HashSet<Integer>();

	 

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// r�cup�re le code du boutton appuy�
		int code = e.getKeyCode();
		liste.add(code);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		liste.remove(code);
	}

}
