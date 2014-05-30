package fr.iutvalence.java.morpion.vues.graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Bouton 'A propos de'
 * 
 *  */
public class BoutonAProposDe implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Développeurs : " + "\n CHAUVEAU Aristide & GARAYT Thomas");
	}
}
