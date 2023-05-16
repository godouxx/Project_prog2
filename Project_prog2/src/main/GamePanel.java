package main;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

import entity.Entity;
import entity.Monstre1;
import entity.Player;
import objetspassifs.Armes;
import objetspassifs.Obstacles;
import tile.TileManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Panel principal du jeu contenant la map principale
 *
 */
public class GamePanel extends JPanel implements Runnable{
	
	//Param�tres de l'�cran
	final int ORIGINAL_TILE_SIZE = 16; 							// une tuile de taille 16x16
	final int SCALE = 3; 										// �chelle utilis�e pour agrandir l'affichage
	public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; 	// 48x48
	public final int MAX_SCREEN_COL = 16;
	public final int MAX_SCREE_ROW = 12; 					 	// ces valeurs donnent une r�solution 4:3
	public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768 pixels
	public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREE_ROW;	// 576 pixels

	// FPS : taux de rafraichissement
	int m_FPS;
	
	// Creation des differentes instances (Player, KeyHandler, TileManager, GameThread ...)
	KeyHandler m_keyH;
	Thread m_gameThread;
	Player m_player;
	ArrayList<Entity> monstres;
	TileManager m_tileM;
	Armes m_arme1;
	Obstacles m_obstacle1;
		
	/**
	 * Constructeur
	 */
	public GamePanel() {
		m_FPS = 60;				
		m_keyH = new KeyHandler();
		m_player = new Player(this, m_keyH);
		m_tileM = new TileManager(this);
		m_arme1 = new Armes(this, 2, 100, 100);
		m_obstacle1 = new Obstacles(this, 100, 300);
	
		monstres=new ArrayList<Entity>();
		intializeMonster();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(m_keyH);
		this.setFocusable(true);
	}
	
	public void intializeMonster() {
		Monstre1 test =new Monstre1(this, 200, 200);
		Monstre1 test2 =new Monstre1(this, 100, 100);
		monstres.add(test);
		monstres.add(test2);
	}
	
	
	/**
	 * Lancement du thread principal
	 */
	public void startGameThread() {
		m_gameThread = new Thread(this);
		m_gameThread.start();
	}
	
	public void run() {
		
		double drawInterval = 1000000000/m_FPS; // rafraichissement chaque 0.0166666 secondes
		double nextDrawTime = System.nanoTime() + drawInterval; 
		
		while(m_gameThread != null) { //Tant que le thread du jeu est actif
			
			//Permet de mettre a jour les differentes variables du jeu
			this.update();
			
			//Dessine sur l'�cran le personnage et la map avec les nouvelles informations. la m�thode "paintComponent" doit obligatoirement �tre appel�e avec "repaint()"
			this.repaint();
			
			//Calcule le temps de pause du thread
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * m�j des monstres
	 */
public void update_monstres() {
	for(int i=0;i<this.monstres.size();i++) {
		monstres.get(i).update();
	}
}
	/**
	 * Mise � jour des donn�es des entit�s
	 */
	public void update() {
		m_player.update();
	}
	
	/**
	 * Affichage des elements
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		m_tileM.draw(g2);
		m_player.draw(g2);
		m_arme1.draw(g2);
		m_obstacle1.draw(g2);
		drawMonster(g2);
		g2.dispose();
	}
	
public void drawMonster(Graphics2D g2) {
		for(int i=0;i<this.monstres.size();i++) {
			monstres.get(i).draw(g2);
		}
	}
	
}
