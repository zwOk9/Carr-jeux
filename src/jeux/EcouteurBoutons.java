package jeux;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class EcouteurBoutons implements ActionListener{
	
	Vue maVue;
	Modele monSudo;
	
	EcouteurBoutons(Vue v,Modele m){
		maVue = v;
		monSudo = m;
	}
	
	public void actionPerformed(ActionEvent e){
		JButton cible = (JButton)e.getSource();
		if(cible.getActionCommand().equals("(RE)Commencer")){
			maVue.initialiser();
			}
		
			
			
		}
		
	}
	
	


