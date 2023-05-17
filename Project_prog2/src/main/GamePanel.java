package main;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

import entity.Entity;
import entity.Monstre1;
import entity.Player;
import objetspassifs.Armes;
import objetspassifs.ObjetsPassifs;
import objetspassifs.Obstacles;
import tile.TileManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.EventHandler;
import java.util.ArrayList;

/**
 * Panel principal du jeu contenant la map principale
 *
 */
public class GamePanel extends JPanel implements Runnable {

	// Param�tres de l'�cran
	final int ORIGINAL_TILE_SIZE = 16; // une tuile de taille 16x16
	final int SCALE = 3; // �chelle utilis�e pour agrandir l'affichage
	public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48
	public final int MAX_SCREEN_COL = 16;
	public final int MAX_SCREE_ROW = 12; // ces valeurs donnent une r�solution 4:3
	public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768 pixels
	public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREE_ROW; // 576 pixels

	// param�tres du monde :
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = TILE_SIZE * maxWorldCol;
	public final int worldHeight = TILE_SIZE * maxWorldRow;
	public int bloquer_action = 0;

	// FPS : taux de rafraichissement
	int m_FPS;

	// Creation des differentes instances (Player, KeyHandler, TileManager,
	// GameThread ...)
	KeyHandler m_keyH;
	Thread m_gameThread;
	public Player m_player;
	public CreateComponents createComponents = new CreateComponents(this);
	public ArrayList<Entity> monstres;
	public ArrayList<ObjetsPassifs> objets;
	TileManager m_tileM;
	public EventManager eventManagerr = new EventManager(this);
	public ColisionVerif colisionVerif = new ColisionVerif(this);
	public boolean win = false;

	/**
	 * Constructeur
	 */
	public GamePanel() {
		m_FPS = 60;
		m_keyH = new KeyHandler();
		m_player = new Player(this, m_keyH);
		m_tileM = new TileManager(this);

		monstres = new ArrayList<Entity>();
		objets = new ArrayList<ObjetsPassifs>();

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(m_keyH);
		this.setFocusable(true);
	}

	public void setupGame() {
		createComponents.setObjetsPassifs();
		createComponents.setMonsters();
	}

	/**
	 * Lancement du thread principal
	 */
	public void startGameThread() {
		m_gameThread = new Thread(this);
		m_gameThread.start();
	}

	public void run() {

		double drawInterval = 1000000000 / m_FPS; // rafraichissement chaque 0.0166666 secondes
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (m_gameThread != null) { // Tant que le thread du jeu est actif

			// Permet de mettre a jour les differentes variables du jeu
			this.update();

			// Dessine sur l'�cran le personnage et la map avec les nouvelles
			// informations. la m�thode "paintComponent" doit obligatoirement �tre
			// appel�e avec "repaint()"
			this.repaint();

			// Calcule le temps de pause du thread
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mise � jour des donn�es des entit�s
	 */
	public void update() {
		bloquer_action++;
		m_player.update();
		for (int i = 0; i < monstres.size(); i++) {
			if(monstres.get(i)!=null) {
				monstres.get(i).update();
			}
			
		}
		if (bloquer_action == 120) {
			bloquer_action = 0;
		}
	}

	/**
	 * Affichage des elements
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (m_player.getPvACTUAL() == 0) {
			m_player.over(g2);
		} else {
			if (win == false) {
				// DRAW LES TILES
			m_tileM.draw(g2);
			// DRAW LE PLAYER
			m_player.draw(g2);
			// DRAW OBJECTS
			for (int i = 0; i < objets.size(); i++) {
				objets.get(i).draw(g2, this);
			}
			// DRAW MONSTERS
			for (int i = 0; i < monstres.size(); i++) {
				monstres.get(i).draw(g2, this);
			}
			// DRAW MINI MAP
			m_tileM.draw_mini_map(g2);
			// DRAW LE POINT DE LA MINIMAP
			m_tileM.point_rouge(g2, m_player);

			g2.dispose();
			}
			else m_player.win(g2);
		}

	}

}
