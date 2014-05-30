package fr.iutvalence.java.morpion.vues.graphique;

import fr.iutvalence.java.morpion.controleurs.ControleurGraphique;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Vue graphique de l'application
 * 
 * @author CHAUVEAU Aristide - GARAYT Thomas
 *
 */
public class VueGraphique extends JFrame                                                                  
{

	private final class Case extends JButton implements ActionListener
	{
		
		private final int x;
		
		private final int y;
		
		public Case(String nom, int x, int y)
		{
			super(nom);
			this.addActionListener(this);
			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			VueGraphique.this.controleurGraphique.placerPion(this.x, this.y);
			this.mettreAJourLeBouton(VueGraphique.this.controleurGraphique.obtenirSignatureJoueurCourant());
		}

		private void mettreAJourLeBouton(String symboleJoueurCourant)
		{
			this.setText(symboleJoueurCourant);
			this.updateUI();
		}
	}



	public static final JPanel tabBouton = new JPanel();

	private JMenuBar menuPrincipal = new JMenuBar();
					 
	private JMenu menu1 = new JMenu("Fichier");

	private JMenuItem sousMenuQuitter = new JMenuItem("Quitter");
	
	private JMenu menu2 = new JMenu("?");

	private JMenuItem sousMenuAPropos = new JMenuItem("A propos de");
	
	private ControleurGraphique controleurGraphique;
	
	public VueGraphique()
	{
		this.controleurGraphique = new ControleurGraphique();
		
		this.setTitle("Morpion");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Actions possibles dans le menu "Fichier"
		this.menu1.add(this.sousMenuQuitter);
		
		// Actions possibles dans le menu "?"
		this.menu2.add(this.sousMenuAPropos);

		// Ajout des écouteurs liés aux différents boutons
		this.sousMenuQuitter.addActionListener(new BoutonQuitter());
		this.sousMenuAPropos.addActionListener(new BoutonAProposDe());

		// menuBar principal
		this.menuPrincipal.add(this.menu1);
		this.menuPrincipal.add(this.menu2);

		// Ajout du menu principal à la fenêtre
		this.setJMenuBar(this.menuPrincipal);
		
		tabBouton.setLayout(new GridLayout(3,3));
		tabBouton.add(new Case(" ",1,1));
		tabBouton.add(new Case(" ",1,2));
		tabBouton.add(new Case(" ",1,3));
		tabBouton.add(new Case(" ",2,1));
		tabBouton.add(new Case(" ",2,2));
		tabBouton.add(new Case(" ",2,3));
		tabBouton.add(new Case(" ",3,1));
		tabBouton.add(new Case(" ",3,2));
		tabBouton.add(new Case(" ",1,1));
		
		tabBouton.setBackground(Color.GRAY);
		this.setContentPane(tabBouton);
		this.setVisible(true);
	}
}
