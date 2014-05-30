package fr.iutvalence.java.morpion;

import javax.swing.SwingUtilities;

import fr.iutvalence.java.morpion.vues.graphique.VueGraphique;


public class Morpion
{

	/** Permet de lancer le jeu.
	 * 
	 * @param args
	 *            args. */
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater((Runnable) new VueGraphique());
		
		/*if ((args.length > 0) && args[0].equals("--gui"))
		{
			/* Attention : l'interface graphique n'est pas encore aboutie. */
			//new VueGraphique();
		}
		/*else
		{
			ControleurConsole unControleurConsole;
			boolean choixVue = false;
			
			if ((args.length > 0) && args[0].equals("--ainsi"))
				choixVue = true;
			
			do
			{
				unControleurConsole = new ControleurConsole(choixVue);
			}
			while (unControleurConsole.nouvellePartie());
		}
	}*/
}
