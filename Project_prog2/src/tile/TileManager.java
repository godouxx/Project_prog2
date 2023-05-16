package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import main.GamePanel;

/**
 * 
 * Gestionnaire des tiles du jeu
 *
 */
public class TileManager {
	GamePanel m_gp;			//panel du jeu principal
	public Tile[] m_tile;			//tableau de toutes les tiles possibles dans le jeu
	int m_maxTiles = 10;	//nombre maximum de tiles chargeable dans le jeu
	public int m_mapTileNum[][];	//répartition des tiles dans la carte du jeu
	
	/**
	 * Constructeur
	 * @param gp
	 */
	public TileManager(GamePanel gp) {
		this.m_gp =  gp;
		m_tile = new Tile[m_maxTiles];
		m_mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		this.getTileImage();
		this.loadMap("/maps/map2.txt");
	}
	
	/**
	 * Chargement de toutes les tuiles du jeu
	 */
	public void getTileImage() {
		try {
			m_tile[0] = new Tile();
			m_tile[0].m_image = ImageIO.read(getClass().getResource("/tiles/GRASS.png"));
			m_tile[0].m_collision=false;
			
			m_tile[1] = new Tile();
			m_tile[1].m_image = ImageIO.read(getClass().getResource("/tiles/BRICK2.png"));
			m_tile[1].m_collision=true;
			
			m_tile[2] = new Tile();
			m_tile[2].m_image = ImageIO.read(getClass().getResource("/tiles/WATER.png"));
			m_tile[2].m_collision=true;
			
			m_tile[3] = new Tile();
			m_tile[3].m_image = ImageIO.read(getClass().getResource("/tiles/LAVA.png"));
			m_tile[3].m_collision=true;
			
			m_tile[4] = new Tile();
			m_tile[4].m_image = ImageIO.read(getClass().getResource("/tiles/SAND.png"));
			m_tile[4].m_collision=false;
			
			m_tile[5] = new Tile();
			m_tile[5].m_image = ImageIO.read(getClass().getResource("/tiles/SNOW.png"));
			m_tile[5].m_collision=false;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lecture du fichier txt contenant la map et chargement des tuiles correspondantes.
	 */
	public void loadMap(String filePath) {
		//charger le fichier txt de la map
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			int col = 0;
			int row = 0;
			
			// Parcourir le fichier txt pour rï¿½cupï¿½rer les valeurs
			while (col < m_gp.maxWorldCol && row < m_gp.maxWorldRow) {
				String line = br.readLine();
				while (col < m_gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					m_mapTileNum [col][row] = num;
					col++;
				}
				if (col == m_gp.maxWorldCol) {
					col = 0;
					row ++;
				}
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Affichage de la carte avec les différentes tuiles
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		
		while (worldCol < m_gp.maxWorldCol && worldRow < m_gp.maxWorldRow) {
			int tileNum = m_mapTileNum[worldCol][worldRow];
			
			int worldX=worldCol*m_gp.TILE_SIZE;
			int worldY=worldRow*m_gp.TILE_SIZE;
			int screenX= worldX - m_gp.m_player.getM_x() +m_gp.m_player.screenX;
			int screenY= worldY - m_gp.m_player.getM_y() +m_gp.m_player.screenY;

			//permet d'afficher seulement les tiles autour pour par dessiner toute la map a chaque fois
			if (	   worldX + m_gp.TILE_SIZE > m_gp.m_player.getM_x() - m_gp.m_player.screenX
                    && worldX - m_gp.TILE_SIZE < m_gp.m_player.getM_x() + m_gp.m_player.screenX
                    && worldY + m_gp.TILE_SIZE > m_gp.m_player.getM_y() - m_gp.m_player.screenY
                    && worldY - m_gp.TILE_SIZE < m_gp.m_player.getM_y() + m_gp.m_player.screenY) {
				g2.drawImage(m_tile[tileNum].m_image, screenX, screenY, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);

			}
			
			worldCol ++;
			if (worldCol == m_gp.maxWorldCol) {
				worldCol = 0;
				worldRow ++;

			}
		}
		
	}
}
