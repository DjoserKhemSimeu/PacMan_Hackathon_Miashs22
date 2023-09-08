package PacMan;

import java.awt.Image;
import java.util.Arrays; 

public class Fantome extends Entite {
	
	private int posX;
	private int posY;
	
	private Image fantome;
	
	private int abscisse;
	private int ordonnee;
	private char couleur;
	///etat= l'etat de pac qui a 2 modalité Fort (capable de manger des fantome) et Normal
	private int etat;

	///direction=La direction de pac qui a 4 modalités Nord,Est,Ouest,Sud
	private int directionCourante ;

	///g= la grille de jeu
	private Grille g;

	///Déclaration des constantes
	public final static int FAIBLE=0;
	public final static int NORMAL=1;
	public final static int NORD=0;
	public final static int EST=1;
	public final static int SUD=2;
	public final static int OUEST = 3;

	public Fantome (Image m,char col,Grille g) {
		etat=NORMAL;
		couleur=col;
		fantome = m;
		this.g=g;
		//placementAuto();

	}




	public int getDirectionCourante() {
		return directionCourante;
	}
	public void changementEtat() { //FAUDRA mettre un timer 
		if(etat==NORMAL) {
			etat=FAIBLE;
		}
		if(etat==FAIBLE) {
			etat=NORMAL;
		}
	}




	public int[] getCoord() {
		int[] rendu = new int[] {getAbscisse(),getOrdonnee()};
		return rendu;
	}
	public int getAbscisse() {
		return abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}

	private void placementAuto() {
		int x,y;
		x =(int)(Math.random()*28 );
		y = (int)(Math.random()*28);
		while((g.getGrille()[x][y]=='M')||(g.getGrille()[x][y]=='R')||(g.getGrille()[x][y]=='O')||(g.getGrille()[x][y]=='L')||(g.getGrille()[x][y]=='J')||(g.getGrille()[x][y]=='Z')||(g.getGrille()[x][y]=='T')) {
			x =(int)(Math.random()*28 );
			y = (int)(Math.random()*28);
		}
		abscisse = x;
		ordonnee = y;
		g.ajouteFantome(couleur, this);
	}



	private void deplacement() {
		char[] tab = g.getVoisinesFantome(couleur);
		int[] directionPosbbile = new int[4];
		int i=0,j=0;
		while(i<4) {
			if (tab[i]!='V' && tab[i]!='T') {
				directionPosbbile[j]=i;
				j++;
			}
			i++;
		}
		int[] newPossible = Arrays.copyOf(directionPosbbile,j);
		int rdm = (int)(Math.random()*j+1);
		if(rdm==j) {
			return;
		}
		else {
			directionCourante = rdm;
			deplacementSelonDirection(rdm);
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
		g.deplaceFantomeSelonDirection(couleur,direction);
	}

}



