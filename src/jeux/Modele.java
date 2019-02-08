package jeux;


public class Modele {
	int compteur;
	String gagne;
	int[][] lumiere;
	Modele(){
		lumiere = new int[9][9];
		initLumiere();
	}
	void initLumiere(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				lumiere[i][j] = 0;
			}
		}
	}
	public int[][] getLumiere(){
		return this.lumiere;
	}
	
	public int getCompteur(){
		return this.compteur;
	}
	
	public void incremente(){
		
		compteur++;
	}
	
public String gagne(){
	gagne="bravo vous avez gagné en "+compteur+" coups";
	return this.gagne;
		
		
	}
	

	
	
	
	
	
	
	
	
	
}

