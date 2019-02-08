package jeux;

import java.awt.event.*;

import javax.swing.JButton;

public class Controleur implements ActionListener {
	Vue maVue;
	Modele monModele;
	 Controleur(Vue v, Modele m){
		 maVue=v;
		 monModele = m;
	 }
	public void actionPerformed(ActionEvent e){
		monModele.incremente();
		monModele.gagne();
		maVue.setMessage(monModele.getCompteur()+"");
		maVue.verifWin(monModele.gagne()+"");
	}
}

