package jeux;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class Vue extends JFrame{
	JLabel message;
	JTextField[][] tabChamps;
	Modele monModele;
	int color [][]= new int[4][4];
	Vue(){
		this.setTitle("Eteignez la lumière version Salim");
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		monModele = new Modele();
		 message = new JLabel("0");
		 
		Controleur monControleur =new Controleur(this, monModele);
		// la zone des champs de saisie
		JPanel zoneChamps = new JPanel();
		zoneChamps.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		zoneChamps.setLayout(new GridLayout(4,4));
		JButton[][] carres = new JButton[4][4];
		this.getContentPane().add(message, BorderLayout.SOUTH);
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				carres[i][j] = new JButton();
				carres[i][j].setLayout(new GridLayout(3,3));
				carres[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
				carres[i][j].addActionListener(monControleur);
				zoneChamps.add(carres[i][j]);
				
			}
		}
		
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				double random=Math.random();
				if(random<0.5){
					carres[i][j].setBackground(Color.red);
					color[i][j]=1;
					
				}
				else{
					carres[i][j].setBackground(Color.white);
				}
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int i1=i;
				int j1=j;
		carres[i][j].addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		       if(color[i1][j1]==1){
		    	   carres[i1][j1].setBackground(Color.white);
		    	   color[i1][j1]=0;
		    	   for(int i=0;i<4;i++){
		    		   if(color[i1][i]!=1){
		    			   carres[i1][i].setBackground(Color.red);
		    			   color[i1][i]=1;
		    			   
		    		   }
		    		   else{
		    		   carres[i1][i].setBackground(Color.white);
		    		   color[i1][i]=0;
		    		   }
		    		   
		    		 
		    	   }
		    	   for(int i=0;i<4;i++){
		    		   if(color[i][j1]!=1){
		    			   carres[i][j1].setBackground(Color.red);
		    			   color[i][j1]=1;
		    			   
		    		   }
		    		   else{
		    		   carres[i][j1].setBackground(Color.white);
		    		   color[i][j1]=0;
		    		   }
		    		   
		    		 
		    	   }
		    	  
		    	   
		       }
		       else{
		    	   carres[i1][j1].setBackground(Color.white);
		    	   color[i1][j1]=1;
		    	   for(int i=0;i<4;i++){
		    		   if(color[i1][i]==1){
		    			   carres[i1][i].setBackground(Color.white);
		    			   color[i1][i]=0;
		    			   
		    			   
		    		   }
		    		   else{
		    		   carres[i1][i].setBackground(Color.red);
		    		   color[i1][i]=1;
		    		   }
		    		   
		    		 
		    	   }
		    	   for(int i=0;i<4;i++){
		    		   if(color[i][j1]==1){
		    			   carres[i][j1].setBackground(Color.white);
		    			   color[i][j1]=0;
		    		   }
		    		   else{
		    		   carres[i][j1].setBackground(Color.red);
		    		   color[i][j1]=1;
		    		   }
		    		   
		    		 
		    	   }
		    	   	
		       }
		      
				
		    }
		});
			}
			}
		// la zone des boutons
		EcouteurBoutons ecoutB = new EcouteurBoutons(this,monModele);
		JPanel zoneBoutons = new JPanel();
		zoneBoutons.setLayout(new GridLayout(1,2));
		
		JButton editer = new JButton("(RE)Commencer");
		editer.addActionListener(ecoutB);
		zoneBoutons.add(editer);
		
		
		// ajout des 2 zones dans la fenêtre
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(zoneChamps,BorderLayout.CENTER);
		this.getContentPane().add(zoneBoutons,BorderLayout.SOUTH);
		this.getContentPane().add(message, BorderLayout.NORTH);
		
		
		this.setVisible(true);
		
	}
	
	
	
	
	
	public void verifWin(String chaine){
		
		
				if(this.color[0][0]==0&&this.color[0][1]==0&&this.color[0][2]==0&&this.color[0][3]==0&&this.color[1][0]==0&&this.color[2][0]==0&&this.color[3][0]==0&&this.color[1][1]==0&&this.color[1][2]==0&&this.color[1][3]==0&&this.color[2][1]==0&&this.color[2][2]==0&&this.color[2][3]==0&&this.color[3][1]==0&&this.color[3][2]==0&&this.color[3][3]==0){
					this.message.setText(chaine);
				}
		
	}
	public void initialiser(){
		
		setVisible(false);
		dispose();
		Vue fenetre = new Vue();
		
		}
	public void setMessage(String chaine){
		this.message.setText(chaine);
	}

	
	public void affichage(){
		int[][] initLumiere= monModele.getLumiere();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				this.tabChamps[i][j].setForeground(Color.BLACK);
				if(initLumiere[i][j]!=0){
					initLumiere[i][j]=0;
				}
				else {
					initLumiere[i][j]=1;
				}
			}
		}
	}
}

