package PacMan;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Grille extends JPanel{

	private char[][] grilleMur;
	private char [][] grilleBille;
	private int nbBille;
	private int nbFantome;
	public Pac pM;
	private Fantome[] tabFantome;
	private int[][] poseFantome;
	private int[] posePac;
	public static final int ROUGE=0;
	public static final int ROSE=1;
	public static final int BLEU=2;
	public static final int JAUNE=3;// 0-> Rouge(R), 1-> Rose(O), 2 -> Bleu(L), 3 -> Jaune(J)

	public Fantome fantomeRouge = new Fantome(new ImageIcon("C:/Users/Dorian/Documents/projet/Java/PacMan/src/PacMan/Image/fantome_rouge.png").getImage(), 'R',this); //Rouge
	public Fantome fantomeRose = new Fantome(null,'O',this); //Rose
	public Fantome fantomeBleu = new Fantome(null,'L',this); //Bleu
	public Fantome fantomeJaune = new Fantome(new ImageIcon("C:/Users/Dorian/Documents/projet/Java/PacMan/src/PacMan/Image/fantome_jaune.png").getImage(),'J',this); //Jaune


	public Grille() {
		grilleBille = grilleDeDepart();
		nbBille = 5;
		nbFantome = 4; // Faudra changer selon le niveau de difficulté
		pM = new Pac(this); //on donne cette grille a pacman
		int i=0;
		tabFantome = new Fantome[] {fantomeRouge,fantomeRose,fantomeBleu,fantomeJaune};
		posePac = new int[2];
		poseFantome = new int[4][1];
	}

	public Pac getPac() {
		return pM;
	}

	public int[][] getPoseFantome() {
		return poseFantome;
	}

	public int[] getPosePac() {
		return posePac;
	}

	public void ajouteFantome(char c,Fantome f) {
		switch(c) {
		case 'R':
			poseFantome[0]=f.getCoord();
			nbFantome++;
			break;
		case 'O':
			poseFantome[1]=f.getCoord();
			nbFantome++;
			break;
		case 'L':
			poseFantome[2]=f.getCoord();
			nbFantome++;
			break;
		case 'J':
			poseFantome[3]=f.getCoord();
			nbFantome++;
			break;
		}
	}

	public void ajoutePac() {
		posePac = new int[] {14,19};
	}

	private char[][] grilleDeDepart() { // M = murs , B = bille, V = vide, P = grosse bille
		char[][] depart = new char[][] {
			{'M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M'},
			{'M','B','B','B','B','B','B','B','B','B','B','B','B','M','M','B','B','B','B','B','B','B','B','B','B','B','B','M'},
			{'M','B','M','M','M','M','B','M','M','M','M','M','B','M','M','B','M','M','M','M','M','B','M','M','M','M','B','M'},
			{'M','P','M','M','M','M','B','M','M','M','M','M','B','M','M','B','M','M','M','M','M','B','M','M','M','M','P','M'},
			{'M','B','M','M','M','M','B','M','M','M','M','M','B','M','M','B','M','M','M','M','M','B','M','M','M','M','B','M'},
			{'M','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','M'},
			{'M','B','M','M','M','M','B','M','M','B','M','M','M','M','M','M','M','M','B','M','M','B','M','M','M','M','B','M'},
			{'M','B','M','M','M','M','B','M','M','B','M','M','M','M','M','M','M','M','B','M','M','B','M','M','M','M','B','M'},
			{'M','B','B','B','B','B','B','M','M','B','B','B','B','M','M','B','B','B','B','M','M','B','B','B','B','B','B','M'},
			{'M','M','M','M','M','M','B','M','M','M','M','M','V','M','M','V','M','M','M','M','M','B','M','M','M','M','M','M'},
			{'T','T','T','T','T','M','B','M','M','M','M','M','V','M','M','V','M','M','M','M','M','B','M','T','T','T','T','T'},
			{'T','T','T','T','T','M','B','M','M','V','V','V','V','V','V','V','V','V','V','M','M','B','M','T','T','T','T','T'},
			{'T','T','T','T','T','M','B','M','M','V','M','M','M','M','M','M','M','M','V','M','M','B','M','T','T','T','T','T'},
			{'M','M','M','M','M','M','B','M','M','V','M','T','T','T','T','T','T','M','V','M','M','B','M','M','M','M','M','M'},
			{'M','V','V','V','V','V','B','V','V','V','M','T','T','T','T','T','T','M','V','V','V','B','V','V','V','V','V','M'},
			{'M','M','M','M','M','M','B','M','M','V','M','T','T','T','T','T','T','M','V','M','M','B','M','M','M','M','M','M'},
			{'T','T','T','T','T','M','B','M','M','V','M','M','M','M','M','M','M','M','V','M','M','B','M','T','T','T','T','T'},
			{'T','T','T','T','T','M','B','M','M','V','V','V','V','V','V','V','V','V','V','M','M','B','M','T','T','T','T','T'},
			{'T','T','T','T','T','M','B','M','M','V','V','V','V','V','V','V','V','V','V','M','M','B','M','T','T','T','T','T'},
			{'M','M','M','M','M','M','B','M','M','V','M','M','M','M','M','M','M','M','V','M','M','B','M','M','M','M','M','M'},
			{'M','B','B','B','B','B','B','B','B','B','B','B','B','M','M','B','B','B','B','B','B','B','B','B','B','B','B','M'},
			{'M','B','M','M','M','M','B','M','M','M','M','M','B','M','M','B','M','M','M','M','M','B','M','M','M','M','B','M'},
			{'M','B','M','M','M','M','B','M','M','M','M','M','B','M','M','B','M','M','M','M','M','B','M','M','M','M','B','M'},
			{'M','P','B','B','M','M','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','M','M','B','B','P','M'},
			{'M','M','M','B','M','M','B','M','M','M','M','M','M','M','M','M','M','M','M','M','M','B','M','M','B','M','M','M'},
			{'M','M','M','B','M','M','B','M','M','M','M','M','M','M','M','M','M','M','M','M','M','B','M','M','B','M','M','M'},
			{'M','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','M'},
			{'M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M','M'},
		};
		return depart;
	}
	
	
	

	public char[][] getGrille(){
		return grilleBille;
	}

	public boolean deplacementValide(Entite e, int direction) {

		if(e instanceof Pac) {


			if(prochainDeplacementPossbilePac()) {


				if(direction==0) {
					if(grilleBille[e.getAbscisse()][e.getOrdonnee()+1]=='T' || grilleBille[e.getAbscisse()][e.getOrdonnee()+1]=='M') {
						return false;
					}
					else {
						e.deplacementSelonDirection(direction);
						return true;
					}
				}
				if(direction==1) {
					if(grilleBille[e.getAbscisse()+1][e.getOrdonnee()]=='T' || grilleBille[e.getAbscisse()+1][e.getOrdonnee()]=='M') {
						return false;
					}
					else {
						e.deplacementSelonDirection(direction);
						return true;
					}

				}
				if(direction==2) {
					if(grilleBille[e.getAbscisse()][e.getOrdonnee()-1]=='T' || grilleBille[e.getAbscisse()][e.getOrdonnee()-1]=='M') {
						return false;
					}
					else {
						e.deplacementSelonDirection(direction);
						return true;
					}

				}
				if(direction==3) {
					if(grilleBille[e.getAbscisse()-1][e.getOrdonnee()]=='T' || grilleBille[e.getAbscisse()-1][e.getOrdonnee()]=='M') {
						return false;
					}
					else {
						e.deplacementSelonDirection(direction);
						return true;
					}
				}
			}
		}
		return false;
	}



	public int[] tabCoordSelonDirection(int[] tab, int direction) {
		switch(direction) {
		case 0:
			return new int[] {tab[0],tab[1]+1};
		case 1:
			return new int[] {tab[0]+1,tab[1]};
		case 2:
			return new int[] {tab[0],tab[1]-1};
		case 3:
			return new int[] {tab[0]-1,tab[1]};
		}
		return tab;
	}

	public void deplacePacSelonDirection(int direction) {
		if(deplacementValide(pM,direction)) {
			posePac = tabCoordSelonDirection(posePac, direction);
			pM.deplacementSelonDirection(direction);
			pM.changementDirection(direction);
		}
		return;
	}

	public Color charToColor(char c) {
		switch(c) {
		case 'R':
			return Color.red;
		case 'O':
			return Color.PINK;
		case 'L':
			return Color.blue;
		case 'J':
			return Color.yellow;
		}
		return Color.black;
	}

	public int charToIntFantome(char c) {
		switch(c) {
		case 'R':
			return 0;
		case 'O':
			return 1;
		case 'L':
			return 2;
		case 'J':
			return 3;
		}
		return -1;
	} 

	public void deplaceFantomeSelonDirection(char c, int direction) {
		if(deplacementValide(tabFantome[charToIntFantome(c)],direction))
			switch(c) {
			case 'R':
				poseFantome[0]= tabCoordSelonDirection(poseFantome[0],direction);
				break;
			case 'O':
				poseFantome[1]=tabCoordSelonDirection(poseFantome[1],direction);
				break;
			case 'L':
				poseFantome[2]=tabCoordSelonDirection(poseFantome[2],direction);
				break;
			case 'J':
				poseFantome[3]=tabCoordSelonDirection(poseFantome[3],direction);
				break;
			}
	}

	public boolean pacEstSurBille() {
		if(grilleBille[posePac[0]][posePac[1]]== 'B') {
			modifCase(posePac[0],posePac[1],'V');
			return true;
		}
		return false;
	}

	public boolean pacGrosseBille() {
		if(grilleBille[posePac[0]][posePac[1]]=='P') {
			modifCase(posePac[0],posePac[1],'V');
			pM.changementEtat();
			int i=0;
			while(i<4) {
				tabFantome[i].changementEtat();
				i++;
			}
			return true;
		}
		return false;
	}

	public void modifCase(int x, int y, char c) {
		grilleBille[x][y]=c;
	}


	public int pixelToCase(int pixel) {
		return (int) (pixel/22);
	}

	public boolean prochainDeplacementPossbilePac() {
		int dir = pM.getDirection();
		if(dir==0) {
			if(grilleBille[posePac[0]][posePac[1]+1]=='M') {
				return false;
			}
		}
		if(dir==1) {
			if(grilleBille[posePac[0]+1][posePac[1]]=='M') {
				return false;
			}
		}
		if(dir==2) {
			if(grilleBille[posePac[0]][posePac[1]-1]=='M') {
				return false;
			}
		}
		if(dir==3) {
			if(grilleBille[posePac[0]-1][posePac[1]+1]=='M') {
				return false;
			}
		}
		return true;

	}

	public boolean prochainDeplacementPossbileFantome(char c) {
		Fantome f = tabFantome[charToIntFantome(c)];
		int dir = f.getDirectionCourante();
		if(dir==0) {
			if(grilleBille[posePac[0]][posePac[1]+1]=='M') {
				return false;
			}
		}
		if(dir==1) {
			if(grilleBille[posePac[0]+1][posePac[1]]=='M') {
				return false;
			}
		}
		if(dir==2) {
			if(grilleBille[posePac[0]][posePac[1]-1]=='M') {
				return false;
			}
		}
		if(dir==3) {
			if(grilleBille[posePac[0]-1][posePac[1]+1]=='M') {
				return false;
			}
		}
		return true;

	}

	public char[] getVoisinesPac() {
		char[] rendu = new char [] {grilleBille[pM.getAbscisse()][pM.getOrdonnee()+1], //Nord, est, sud, ouest
				grilleBille[pM.getAbscisse()+1][pM.getOrdonnee()],
				grilleBille[pM.getAbscisse()][pM.getOrdonnee()-1],
				grilleBille[pM.getAbscisse()-1][pM.getOrdonnee()]};
		return rendu;
	}
	public char[] getVoisinesFantome(char c) {
		Fantome f = tabFantome[charToIntFantome(c)];
		char[] rendu = new char [] {grilleBille[f.getAbscisse()][f.getOrdonnee()+1],  //Nord, est, sud, ouest
				grilleBille[f.getAbscisse()+1][f.getOrdonnee()],
				grilleBille[f.getAbscisse()][f.getOrdonnee()-1],
				grilleBille[f.getAbscisse()-1][f.getOrdonnee()]};
		return rendu;
	}
	public boolean aGagner() {
		int i=0;
		int j=0;
		while(i<28) {
			j=0;
			while(j<31) {
				if(grilleBille[i][j]=='P') {
					return false;
				}
				j++;
			}
			i++;
		}
		return true;
	}

	public int confrontaion () { //1 si pac tue le fantome, -1 si il meurt, 0 si il ne se passe rien
		int i=0;
		while (i<=3) {
			if((poseFantome[i][0]==posePac[0])&&(poseFantome[i][1]==posePac[1])) {
				if(pM.getEtat()==1) {
					/////on verra ca par rapport à l'interface
					return 1;
				}
				else {
					return -1;

				}
			}
		}
		return 0;

	}
	
	//public void 
	
}


