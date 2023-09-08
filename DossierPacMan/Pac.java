package PacMan;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Pac extends Entite { 
	
	private int posX=33;
	private int posY=33;
	
	private int velocity = 3;
	
	private Image pac; // image du pac man
	
	///Attribut d'instance: abscisse/ordonnee= la pos de pac sur la grille
	private int abscisse;
	private int ordonnee;

	///etat= l'etat de pac qui a 2 modalité Fort (capable de manger des fantome) et Normal
	private int etat;

	///direction=La direction de pac qui a 4 modalités Nord,Est,Ouest,Sud
	private int direction ;

	///g= la grille de jeu
	private Grille g;

	///Déclaration des constantes
	public final static int NORMAL=0;
	public final static int FORT=1;
	public final static int NORD=0;
	public final static int EST=1;
	public final static int SUD=2;
	public final static int OUEST = 3;
	
	
	public boolean okNord;
	public boolean okEst;
	public boolean okSud;
	public boolean okOuest;


	///Constructeur qui prend en paramètre une grille et qui instancie tout les atributs
	public Pac(Grille g) {
		/// Initilisation de la pos de pac au centre de la grille
		abscisse=14;
		ordonnee=16;
		///Initialisation de l'etat à Normal
		etat=NORMAL;
		///Initilisation de la direction vers l'ouest
		direction=EST;
		///Initialistion de la grille de jeu
		this.g=g;
		
	   	pac = new ImageIcon("C:/Users/Dorian/Documents/projet/Java/PacMan/src/PacMan/Image/pacman2.png").getImage();
		
		g.ajoutePac();
	}
	
	public void updateBooleanDirection(boolean b1, boolean b2, boolean b3, boolean b4) {
		okNord = b1;
		okEst = b2;
		okSud = b3;
		okOuest = b4;
	}
	
	public void setVelocity(int i) {
		velocity = i;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	/// methodes qui retourne l'abscisse et l'ordonnee
	public int getAbscisse() {
		return abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	
	
	public void setAbscisse(int i) {
		abscisse = i;
	}
	
	public void setOrdonnee(int i) {
		ordonnee = i;
	}
	/// Methode pour changer la direction de pac qui prend
	//en parametre un entier qui represente la nouvel direction


	public boolean changementDirection (int i) {
		if (i==NORD) {
			direction=NORD;
			return true;
		}
		else if (i==SUD) {
			direction=SUD;
			return true;
		}
		else if (i==EST) {
			direction=EST;
			return true;
		}
		else if(i==OUEST) {
			direction=OUEST;
			return true;
		}
		else {
			return false;
		}
	}


	///Methode qui retourne la direction courante
	public int getDirection() {
		return direction;
	}


	///Methode qui change  L'etat
	public void changementEtat() {
		if(etat==NORMAL) {
			etat=FORT;
		}
		if(etat==FORT) {
			etat=NORMAL;
		}
	}

	public void deplacementSelonDirection(int direction) {
		switch(direction) {
		case 0:
			ordonnee = ordonnee +1;
		case 1:
			abscisse = abscisse +1;
		case 2:
			ordonnee = ordonnee -1;
		case 3:
			abscisse = abscisse -1;
		}
		g.deplacePacSelonDirection(direction);
	}


	///Methode qui retourne l'etat de pac
	public int getEtat() {
		return etat;
	}
	
	
    public void drawPac(Graphics2D g) {
    	g.drawImage(pac, posX-10, posY-10, null);
    }
	
    public void move(int direction) {
    	switch(direction) {
    		case NORD:
    			moveToNord();
    			break;
    		case EST:
    			moveToEst();
    			break;
    		case OUEST:
    			moveToOuest();
    			break;
    		case SUD:
    			moveToSud();
    			break;
    	}
    }
	private void moveToSud() {
		if(okSud)
		posY = posY + velocity;
		
	}
	private void moveToOuest() {
		if(okOuest)
		posX = posX - velocity;
		
	}
	private void moveToEst() {
		if(okEst)
		posX = posX + velocity;
		
	}
	private void moveToNord() {
		if(okNord)
		posY = posY - velocity;		
	}


}


















