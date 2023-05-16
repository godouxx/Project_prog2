package entity;

import main.GamePanel;

public class Monstre1 extends Entity {
	private GamePanel m_gp;
	
//constructeur de monstre
	public Monstre1(GamePanel a_gp) {
		this.m_gp = a_gp;
		setM_speed(m_speed);
		
	}
	protected void setDefaultValues() {
		setDegat(degat);
	}
}
