package fr.iutvalence.java.morpion.vues.graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Bouton 'Quitter'
 * 
 */
public class BoutonQuitter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
